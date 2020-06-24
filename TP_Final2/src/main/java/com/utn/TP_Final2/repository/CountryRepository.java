package com.utn.TP_Final2.repository;

import com.utn.TP_Final2.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {

    @Query(value = "select * from countries where name = ?1", nativeQuery = true)
    List<Country> findByName(String name);
}

