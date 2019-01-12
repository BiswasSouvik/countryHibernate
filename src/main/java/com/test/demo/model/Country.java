package com.test.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "country", uniqueConstraints = {@UniqueConstraint(columnNames = {"name"})})
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "population")
    private long population;

    @OneToMany(targetEntity = City.class, mappedBy = "country",
            cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<City> cities;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "nation_id")
    private Nationality nationality;

    /*
        public Country(int id, String name, long population, List<City> cities, Nationality nationality) {
            this.id = id;
            this.name = name;
            this.population = population;
            this.cities = cities;
            this.nationality = nationality;
        }
    */

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    public Nationality getNationality() {
        return nationality;
    }

    public void setNationality(Nationality nationality) {
        this.nationality = nationality;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", population=" + population +
                ", cities=" + cities +
                ", nationality=" + nationality +
                '}';
    }
}