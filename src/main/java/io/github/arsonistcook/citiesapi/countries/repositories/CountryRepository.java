package io.github.arsonistcook.citiesapi.countries.repositories;

import io.github.arsonistcook.citiesapi.countries.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
