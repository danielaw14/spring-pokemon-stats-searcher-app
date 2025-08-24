package com.example.pokemonstatssearcher.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.pokemonstatssearcher.service.PokemonService;

@RestController
public class PokemonController {

    @GetMapping("api/pokemon/{name}")
    public String getPokemonByName(@PathVariable String name) {
        return PokemonService.getPokemonByName(name);
    }

}
