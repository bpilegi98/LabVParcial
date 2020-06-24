package com.utn.TP_Final.service.integration;

import com.utn.TP_Final.model.Country;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.query.criteria.internal.expression.function.AggregationFunction;
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
    private static String url = "http://localhost:8081/";

    @PostConstruct
    private void init()
    {
        rest = new RestTemplateBuilder()
                .build();
    }

    public List<Country> getCountriesFromApi()
    {
        List<Country> countries = new ArrayList<Country>();
        Country country = rest.getForObject(url + "country/", Country.class);
        countries.add(country);
        return countries;
    }

    public Country getCountryByIdFromApi(Integer id)
    {
        return rest.getForObject(url + "country/" + id, Country.class);
    }
}
