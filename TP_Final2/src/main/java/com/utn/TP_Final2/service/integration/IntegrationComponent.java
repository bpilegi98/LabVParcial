package com.utn.TP_Final2.service.integration;

import com.utn.TP_Final2.model.Country;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class IntegrationComponent {

    private RestTemplate rest;
    private static String url = "http://localhost:8080/";

    @PostConstruct
    private void init()
    {
        rest = new RestTemplateBuilder()
                .build();
    }

    public List<Country> getCountriesFromApi()
    {
        return rest.getForObject(url + "country/", Country[].class);
    }

    public Country getCountryByIdFromApi(Integer id)
    {
        return rest.getForObject(url + "country/?id=" + id, Country.class);
    }
}
