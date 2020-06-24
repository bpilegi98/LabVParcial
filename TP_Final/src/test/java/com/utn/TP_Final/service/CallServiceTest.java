package com.utn.TP_Final.service;

import com.utn.TP_Final.exceptions.TelephoneLineHasNotCalls;
import com.utn.TP_Final.exceptions.TelephoneLineNotExistsException;
import com.utn.TP_Final.model.Call;
import com.utn.TP_Final.model.City;
import com.utn.TP_Final.model.TelephoneLine;
import com.utn.TP_Final.model.User;
import com.utn.TP_Final.projections.LineNumberAndCallsReceived;
import com.utn.TP_Final.repository.CallRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.projection.ProjectionFactory;
import org.springframework.data.projection.SpelAwareProxyProjectionFactory;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

public class CallServiceTest {

    @Autowired
    CallService callService;

    @Mock
    CallRepository callRepository;

    @Before
    public void setUp()
    {
        initMocks(this);
        callService = new CallService(callRepository);
    }

    @Test
    public void getLineNumberAndReceivedCallsTest() throws TelephoneLineNotExistsException, TelephoneLineHasNotCalls {
        List<Call> calls = new ArrayList<Call>();

        City city1 = new City(1,"Mar del Plata", "223", null, null);
        City city2 = new City(2,"La Plata", "291", null, null);

        User user = new User(1, "Bianca", "Pilegi", "41307541", "bpilegi98", "1234", null, true, city1, null, null);

        TelephoneLine telephoneLine1 = new TelephoneLine(1, "2235678987", null, null, user, null);

        TelephoneLine telephoneLine2 = new TelephoneLine(2, "223555555", null, null, null, null);
        TelephoneLine telephoneLine3 = new TelephoneLine(3, "223444444", null, null, null, null);

        List<TelephoneLine> telephoneLines = new ArrayList<TelephoneLine>();
        telephoneLines.add(telephoneLine1);

        user.setTelephoneLines(telephoneLines);

        Call call1 = new Call(1, 5, 50, 15, 25, null, telephoneLine2, null, city1);
        Call call2 = new Call(2, 5, 50, 15, 25, null, telephoneLine2, null, city1);
        Call call3 = new Call(3, 5, 50, 15, 25, null, telephoneLine3, null, city2);

        calls.add(call1);
        calls.add(call2);
        calls.add(call3);

        ProjectionFactory factory = new SpelAwareProxyProjectionFactory();
        LineNumberAndCallsReceived lineNumberAndCallsReceived = factory.createProjection(LineNumberAndCallsReceived.class);
        lineNumberAndCallsReceived.setLineNumber("223555555");
        lineNumberAndCallsReceived.setCallsReceived(2);

        when(callRepository.getLineNumberAndCallsReceived("223555555")).thenReturn(lineNumberAndCallsReceived);

        LineNumberAndCallsReceived lineNumberAndCallsReceivedEmp = factory.createProjection(LineNumberAndCallsReceived.class);
        lineNumberAndCallsReceivedEmp = callService.getLineNumberAndCallsReceived("223555555");

        assertEquals(lineNumberAndCallsReceived, lineNumberAndCallsReceivedEmp);
    }
}
