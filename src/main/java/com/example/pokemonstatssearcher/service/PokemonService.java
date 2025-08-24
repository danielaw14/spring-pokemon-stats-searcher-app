package com.example.pokemonstatssearcher.service;

import org.springframework.stereotype.Service;

//API to be used: https://pokeapi.co/api/v2/pokemon/{name}

@Service
public class PokemonService {
    
    public static String getPokemonByName(String name) {
        String apiUrl = "https://pokeapi.co/api/v2/pokemon/" + name.toLowerCase();
        // Logic to call the external API and fetch Pokemon data
        try {
            java.net.http.HttpClient client = java.net.http.HttpClient.newHttpClient();
            java.net.http.HttpRequest request = java.net.http.HttpRequest.newBuilder()
                .uri(java.net.URI.create(apiUrl))
                .build();
            java.net.http.HttpResponse<String> response = client.send(request, java.net.http.HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
