package com.utn.TP_Final.controller;


//import com.utn.TP_Final.service.CountryService;
import com.utn.TP_Final.model.Country;
import com.utn.TP_Final.service.IntegrationService;
        import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("")
@RequestMapping("/country")
public class CountryController {

    private final IntegrationService integrationService;

    public CountryController(IntegrationService integrationService) {
        this.integrationService = integrationService;
    }

    @GetMapping("/")
    public List<Country> getCountry()
    {
        return integrationService.getCountry();
    }

    @GetMapping("/{id}")
    public Country getCountryById(@RequestParam(required = false)Integer id)
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
    public Optional<Country> getById(@RequestParam(required = true)Integer id)
    {
        return countryService.findById(id);
    }
 */
}
