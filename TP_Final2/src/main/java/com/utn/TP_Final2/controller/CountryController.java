package com.utn.TP_Final2.controller;


import com.utn.TP_Final2.model.Country;
//import com.utn.TP_Final2.service.CountryService;
import com.utn.TP_Final2.service.IntegrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("")
@RequestMapping("/country")
public class CountryController {

    private final IntegrationService integrationService;

    @Autowired
    public CountryController(IntegrationService integrationService) {
        this.integrationService = integrationService;
    }

    @GetMapping("/")
    public List<Country> getAll()
    {
        return integrationService.getCountry();
    }

    @GetMapping("/{id}")
    public Country getById(@RequestParam Integer id)
    {
        return integrationService.getCountryById(id);
    }


    /*
    private final CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @PostMapping(value= "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void addCountry(@RequestBody Country newCountry)
    {
        countryService.addCountry(newCountry);
    }

    @GetMapping("/")
    public List<Country> getAll(@RequestParam(required = false) String name)
    {
        return countryService.getAll(name);
    }

    @GetMapping("/{id}")
    public Optional<Country> getById(@RequestParam Integer id)
    {
        return countryService.findById(id);
    }
     */
}
