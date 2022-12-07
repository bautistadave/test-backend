package com.rest.testdh.repositories;

import com.rest.testdh.models.Patito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PatitoRepository extends JpaRepository<Patito, Long> {

    /**@Query("SELECT p FROM Patito p WHERE p.uuid = ?1")
    Optional<Patito> findByUuid(String uuid);*/
}
