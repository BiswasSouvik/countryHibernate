package com.test.demo.repository;

import com.test.demo.model.Nationality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface NationalityRepo extends JpaRepository<Nationality, Integer> {
    @Modifying
    @Query("update Nationality set countryName = :country , nationality = :nationality where id = :id")
    void update(@Param("id") int id, @Param("country") String country, @Param("nationality") String nationality);
}
