package com.test.demo.repository;

import com.test.demo.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CountryRepo extends JpaRepository<Country, Integer> {
    @Modifying
    @Query("update Country set name = :name ,population = :population where id = :id")
    void update(@Param("id") Country id, @Param("name") String name, @Param("population") Long population);

    Optional<Country> findByName(String name);
}