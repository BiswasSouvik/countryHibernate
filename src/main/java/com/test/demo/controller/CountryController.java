package com.test.demo.controller;

import com.test.demo.model.Country;
import com.test.demo.service.CountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/country")
public class CountryController {
    private static final Logger logger = LoggerFactory.getLogger(CountryController.class);

    @Autowired
    private CountryService service;

    @RequestMapping(method = RequestMethod.GET, headers = "Accept=application/json")
    private List<Country> getCountries() {
        logger.info("getCountries: returned list");
        return service.getAllCountries();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public Optional<Country> getCountryById(@PathVariable(name = "id") int id) {
        logger.info("getCountryById: returned Country with id {}", id);
        return service.getCountry(id);
    }

    @RequestMapping(method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<Object> addCountry(@RequestBody Country country) {
        Country item = service.addCountry(country);
        if (item != null) {
            logger.info("addCountry: added Country with id {}", country.getId());
            return new ResponseEntity<>(item, HttpStatus.OK);
        }
        else {
            logger.error("addCountry: Country with id {} already exixts", country.getId());
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
    public ResponseEntity<Object> deleteById(@PathVariable(name = "id") int id) {
        if (service.deleteCountry(id) != null) {
            logger.error("deleteById: No country found");
            return new ResponseEntity<>("Item deleted", HttpStatus.OK);
        } else {
            logger.info("deleteById: deleted Country with id {}", id);
            return new ResponseEntity<>("No Content Exists", HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, headers = "Accept=application/json")
    public ResponseEntity<Object> updateById(@RequestBody Country country) {
        if (service.updateCountry(country) != null) {
            logger.info("updateById: updated Country with id {}", country.getId());
            return new ResponseEntity<>(service.updateCountry(country), HttpStatus.OK);
        } else {
            logger.error("updateById: No country exists with id {}", country.getId());
            return new ResponseEntity<>("No Content Exists", HttpStatus.NOT_FOUND);
        }
    }
}