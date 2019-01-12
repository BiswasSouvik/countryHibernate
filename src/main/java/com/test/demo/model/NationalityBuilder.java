package com.test.demo.model;

public class NationalityBuilder {
    private int id;
    private String nationality;
    private String countryName;
    private Country country;

    public NationalityBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public NationalityBuilder setNationality(String nationality) {
        this.nationality = nationality;
        return this;
    }

    public NationalityBuilder setCountryName(String countryName) {
        this.countryName = countryName;
        return this;
    }

    public NationalityBuilder setCountry(Country country) {
        this.country = country;
        return this;
    }
/*
    public Nationality build() {
        return new Nationality(id, nationality, countryName, country);
    }
    */
}
