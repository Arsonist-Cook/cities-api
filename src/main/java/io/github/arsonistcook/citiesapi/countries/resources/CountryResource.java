package io.github.arsonistcook.citiesapi.countries.resources;

import io.github.arsonistcook.citiesapi.countries.entities.Country;
import io.github.arsonistcook.citiesapi.countries.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/countries")
public class CountryResource {
    @Autowired
    private CountryRepository repository;

    @GetMapping
    public Page<Country> getAllCountries(Pageable page) {
        return repository.findAll(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Country> getOneCountry(@PathVariable Long id){
        Optional<Country> searchResult = repository.findById(id);

        if(searchResult.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(searchResult.get());
    }
}
