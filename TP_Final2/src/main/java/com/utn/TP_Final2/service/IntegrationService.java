package com.utn.TP_Final2.service;

import com.utn.TP_Final2.model.Country;
import com.utn.TP_Final2.service.integration.IntegrationComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IntegrationService {

    @Autowired
    IntegrationComponent integrationComponent;

    public List<Country> getCountry()
    {
        return integrationComponent.getCountriesFromApi();
    }

    public Country getCountryById(Integer id)
    {
        return integrationComponent.getCountryByIdFromApi(id);
    }
}