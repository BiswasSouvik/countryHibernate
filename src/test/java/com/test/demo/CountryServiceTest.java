package com.test.demo;

import com.test.demo.model.Country;
import com.test.demo.repository.CountryRepo;
import com.test.demo.repository.NationalityRepo;
import com.test.demo.service.CountryService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CountryServiceTest {
    /*
    @InjectMocks
    private CountryService countryService;
    @Mock
    private CountryRepo countryRepo;

    @Mock
    private NationalityRepo nationalityRepo;

    private Country india = null;
    private ClassBuilder classBuilder;

    @Before
    public void setUp() {
        classBuilder = new ClassBuilder();
        india = classBuilder.getCountry();
    }

    @Test
    public void addCountryTest() {
        when(countryRepo.save(india)).thenReturn(india);
        Assert.assertEquals(india, countryService.addCountry(india));
        verify(countryRepo).save(india);
    }

    @Test
    public void getCountryTest() {
        when(countryRepo.findById(india.getId())).thenReturn(java.util.Optional.ofNullable(india));
        Assert.assertTrue(countryService.getCountry(india.getId()).isPresent());
        Assert.assertEquals(india, countryService.getCountry(india.getId()).get());
        verify(countryRepo, times(2)).findById(india.getId());
    }

    @Test
    public void getAllCountriesTest() {
        List<Country> countryList = new ArrayList<>();
        countryList.add(india);
        when(countryRepo.findAll()).thenReturn(countryList);
        Assert.assertEquals(countryList, countryService.getAllCountries());
        verify(countryRepo).findAll();
    }

    @Test
    public void updateCountryTest() {
        Country updated = classBuilder.getCountry();
        when(countryRepo.existsById(updated.getId())).thenReturn(true);
        Assert.assertEquals(updated, countryService.updateCountry(updated));
//        verify(countryRepo).update(updated, updated.getName(), updated.getPopulation());
    }

    @Test
    public void deleteCountryTest() {
        when(countryRepo.existsById(india.getId())).thenReturn(true);
        Assert.assertEquals("Deleted", countryService.deleteCountry(india.getId()));
        verify(countryRepo).deleteById(india.getId());
    }
    */
}
