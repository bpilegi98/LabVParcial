package com.utn.TP_Final.projections;

public interface LineNumberAndCallsReceived {

    String getLineNumber();
    Integer getCallsReceived();

    void setLineNumber(String lineNumber);
    void setCallsReceived(Integer callsReceived);
}
