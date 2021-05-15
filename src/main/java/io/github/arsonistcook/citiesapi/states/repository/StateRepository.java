package io.github.arsonistcook.citiesapi.states.repository;

import io.github.arsonistcook.citiesapi.states.entities.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State,Long> {
}
