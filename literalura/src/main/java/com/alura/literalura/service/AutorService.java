package com.alura.literalura.service;

import ch.qos.logback.core.encoder.JsonEscapeUtil;
import com.alura.literalura.model.Autor;
import com.alura.literalura.repository.AutorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service


public class AutorService {
    @Autowired
    AutorRepository autorRepository;

    @Transactional
    public void mostrarAutores() {
        autorRepository.findAll().stream().forEach(autor->System.out.println(autor));
    }
    @Transactional
    public void mostrarAutoresVivos(Integer aniomenor, Integer aniomayor) {
        // Autores con fecha de muerte después del año
      autorRepository.encontrarAutoresVivosEntre(aniomenor,aniomayor).stream().forEach(autor-> System.out.println(autor));
    }

}
