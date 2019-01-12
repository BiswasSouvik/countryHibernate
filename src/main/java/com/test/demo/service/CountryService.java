package com.test.demo.service;

import com.test.demo.model.City;
import com.test.demo.model.Country;
import com.test.demo.repository.CitiesRepo;
import com.test.demo.repository.CountryRepo;
import com.test.demo.repository.NationalityRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Scope(scopeName = "prototype")
public class CountryService {
    private static final Logger logger = LoggerFactory.getLogger(CountryService.class);

    @Autowired
    private CountryRepo repo;
    @Autowired
    private NationalityRepo nationalityRepo;
    @Autowired
    private CitiesRepo citiesRepo;

    public List<Country> getAllCountries() {
        logger.debug("getAllCountries: returned list");
        return repo.findAll();
    }

    public Optional<Country> getCountry(int id) {
        logger.debug("getCountry: returned Country with id {}", id);
        return repo.findById(id);
    }

    @Transactional
    public Country addCountry(Country country) {
        if(!repo.findByName(country.getName()).isPresent()) {
            Country item = repo.save(country);
            updateCityCountryId(item);
            logger.debug("addCountry: country with id {} is added", item.getId());
            return item;
        }
        else
            return null;
    }

    @Transactional
    public String deleteCountry(int id) {
        if (repo.existsById(id)) {
            logger.debug("delete: country deleted with id {}", id);
            repo.deleteById(id);
            return "Deleted";
        } else {
            logger.debug("delete: no country found with id {}", id);
            return null;
        }
    }

    @Transactional
    public Country updateCountry(Country country) {
        if (repo.existsById(country.getId())) {
            logger.debug("updateCountry: updated Country with id {}", country.getId());
            repo.update(country, country.getName(), country.getPopulation());
            nationalityRepo.update(country.getNationality().getId(),
                    country.getNationality().getCountryName(), country.getNationality().getNationality());
            updateCity(country);
            return country;
        } else {
            logger.error("updateById: no country found with id {}", country.getId());
            return null;
        }

    }

    private void updateCity(Country country) {
        List<City> cities = country.getCities();
        for (City city : cities) {
            citiesRepo.update(city.getId(), city.getName(),
                    city.getPin(), city.getPopulation(), country);
        }
    }

    private void updateCityCountryId(Country country) {
        List<City> cities = country.getCities();
        for (City city : cities) {
            citiesRepo.updateCountryId(city.getId(), country);
        }
    }

}