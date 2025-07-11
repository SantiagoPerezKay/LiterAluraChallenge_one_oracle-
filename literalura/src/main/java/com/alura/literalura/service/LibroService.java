package com.alura.literalura.service;

import com.alura.literalura.api.GutendexClient;
import com.alura.literalura.model.Autor;
import com.alura.literalura.model.Libro;
import com.alura.literalura.repository.AutorRepository;
import com.alura.literalura.repository.LibroRepository;
import jakarta.transaction.Transactional;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroService {

    @Autowired
    private GutendexClient gutendexClient;

    @Autowired
    private LibroRepository libroRepository;
    @Autowired
    private AutorRepository autorRepository;

    public Libro buscarYGuardar(String nombreLibro) {
        Libro libro = gutendexClient.searchFirstBook(nombreLibro);

        if (libro == null) {
           return  null;
        }

        // Paso 1: asegurar que los autores estén en la BD y gestionados por JPA
        List<Autor> autoresPersistidos = libro.getAutores().stream()
                .map(autor -> {
                    return autorRepository.findByName(autor.getName())
                            .orElseGet(() -> autorRepository.save(autor));
                })
                .toList();

        // Paso 2: crear una nueva instancia de Libro para evitar referencias problemáticas
        Libro libroNuevo = new Libro();
        libroNuevo.setTitulo(libro.getTitulo());
        libroNuevo.setIdioma(libro.getIdioma());
        libroNuevo.setNumerodedescargas(libro.getNumerodedescargas());
        libroNuevo.setAutores(autoresPersistidos);

        // Paso 3: guardar el libro sin problemas de entidades "detached"


        return libroRepository.save(libroNuevo);
    }
    @Transactional
public void mostrarTodosLibros(){


        List<Libro> libros = libroRepository.findAll();

        // Forzar carga de autores
        libros.forEach(libro -> Hibernate.initialize(libro.getAutores()));

        System.out.println(libros);

}
}
