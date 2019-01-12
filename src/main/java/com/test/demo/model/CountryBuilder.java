package com.test.demo.model;

import java.util.List;

public class CountryBuilder {
    private int id;
    private String name;
    private long population;
    private List<City> cities;
    private Nationality nationality;

    public CountryBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public CountryBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public CountryBuilder setPopulation(long population) {
        this.population = population;
        return this;
    }

    public CountryBuilder setCities(List<City> cities) {
        this.cities = cities;
        return this;
    }

    public CountryBuilder setNationality(Nationality nationality) {
        this.nationality = nationality;
        return this;
    }
/*
    public Country build() {
        return new Country(id, name, population, cities, nationality);
    }
    */
}
