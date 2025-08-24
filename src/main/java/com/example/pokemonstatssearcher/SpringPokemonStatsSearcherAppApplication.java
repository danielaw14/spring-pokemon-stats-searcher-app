package com.example.pokemonstatssearcher;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringPokemonStatsSearcherAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringPokemonStatsSearcherAppApplication.class, args);

		// Example REST client for testing (using Java 11 HttpClient)
		// This should be moved to a test class in src/test/java for proper testing.

		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("http://localhost:8080/api/pokemon/pikachu"))
				.GET()
				.build();

		client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
				.thenApply(HttpResponse::body)
				.thenAccept(System.out::println)
				.join();
	}

}
