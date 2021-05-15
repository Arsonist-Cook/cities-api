package io.github.arsonistcook.citiesapi.cities.resources;

import io.github.arsonistcook.citiesapi.cities.entities.City;
import io.github.arsonistcook.citiesapi.cities.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/cities")
public class CityResource {
    @Autowired
    private CityRepository repository;

    @GetMapping
    public Page<City> getAllCities(Pageable page){
        return repository.findAll(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<City> getOneCity(@PathVariable Long id){
        Optional<City> searchResult = repository.findById(id);

        if (searchResult.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(searchResult.get());
    }
}
