package io.github.arsonistcook.citiesapi.states.resources;

import io.github.arsonistcook.citiesapi.states.entities.State;
import io.github.arsonistcook.citiesapi.states.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/states")
public class StateResource {

    @Autowired
    private StateRepository repository;

    @GetMapping
    public Page<State> getAllStates(Pageable page){
        return repository.findAll(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<State> getOneState(@PathVariable Long id){
        Optional<State> searchResult = repository.findById(id);

        if(searchResult.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(searchResult.get());
    }
}
