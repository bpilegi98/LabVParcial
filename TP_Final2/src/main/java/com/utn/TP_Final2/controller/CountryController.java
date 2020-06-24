package com.utn.TP_Final2.controller;


import com.utn.TP_Final2.service.CountryService;
import com.utn.TP_Final2.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController("")
@RequestMapping("/country")
public class CountryController {

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
}
