package com.spring.zerotohero.base.repository;

import com.spring.zerotohero.base.model.Registry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RegistryRepo extends JpaRepository<Registry,Long> {

    Optional<Registry> findBySurname(String surname);
}
