package com.test.demo.repository;

import com.test.demo.model.City;
import com.test.demo.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CitiesRepo extends JpaRepository<City, Integer> {
    @Modifying
    @Query("update City set name = :name ,pin = :pin, population = :population, country = :country_id where id = :id")
    void update(@Param("id") int id, @Param("id") String name,
                @Param("pin") int pin, @Param("population") long population, @Param("country_id") Country country_id);

    @Modifying
    @Query("update City set country = :country_id where id = :id")
    void updateCountryId(@Param("id") int id, @Param("country_id") Country country_id);
}