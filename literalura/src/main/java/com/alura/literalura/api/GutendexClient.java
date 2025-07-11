package com.alura.literalura.api;

import com.alura.literalura.model.GutendexResponse;
import com.alura.literalura.model.Libro;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

@Service
public class GutendexClient {

    private static final String BASE_URL = "https://gutendex.com/books?search=";

    private final HttpClient client;

    @Autowired
    private ObjectMapper objectMapper;

    public GutendexClient() {
        this.client = HttpClient.newBuilder()
                .followRedirects(HttpClient.Redirect.ALWAYS)
                .build();
    }

    // ✅ Buscar y devolver solo el primer libro
    public Libro searchFirstBook(String query) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + URLEncoder.encode(query, StandardCharsets.UTF_8)))
                .GET()
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println("Código de estado: " + response.statusCode());
            System.out.println("Body de respuesta:");
            System.out.println(response.body());

            GutendexResponse gutendexResponse = objectMapper.readValue(response.body(), GutendexResponse.class);

            if (gutendexResponse.getResults().isEmpty()) {
                return null;
            }

            return gutendexResponse.getResults().get(0); // solo el primer libro

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Error al hacer la solicitud a Gutendex", e);
        }
    }
}
