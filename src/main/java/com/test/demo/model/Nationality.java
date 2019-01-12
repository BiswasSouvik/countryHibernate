package com.test.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

@Entity
@Table(name = "nation")
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Nationality {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nationality")
    private String nationality;
    @Column(name = "country")
    private String countryName;
    @OneToOne(mappedBy = "nationality", cascade = CascadeType.ALL)
    private Country country;

    /*
        Nationality(int id, String nationality, String countryName, Country country) {
            this.id = id;
            this.nationality = nationality;
            this.countryName = countryName;
            this.country = country;
        }
    */
    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @JsonIgnore
    public Country getCountry() {
        return country;
    }


    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Nationality{" +
                "id=" + id +
                ", nationality='" + nationality + '\'' +
                ", name=" + countryName +
                '}';
    }
}