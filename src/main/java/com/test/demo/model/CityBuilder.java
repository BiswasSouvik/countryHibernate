package com.test.demo.model;

public class CityBuilder {
    private int id;
    private String name;
    private int pin;
    private int population;
    private Country country;

    public CityBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public CityBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public CityBuilder setPin(int pin) {
        this.pin = pin;
        return this;
    }

    public CityBuilder setPopulation(int population) {
        this.population = population;
        return this;
    }

    public CityBuilder setCountry(Country country) {
        this.country = country;
        return this;
    }
/*
    public City build() {
        return new City(id, name, pin, population, country);
    }
    */
}
