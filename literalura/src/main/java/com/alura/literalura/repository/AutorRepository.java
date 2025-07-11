package com.alura.literalura.repository;

import com.alura.literalura.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AutorRepository extends JpaRepository<Autor,Long> {

    Optional<Autor> findByName(String name);

    @Query("""
    SELECT a FROM Autor a
    WHERE a.anioNacimiento <= :anioFin
      AND (a.anioMuerte IS NULL OR a.anioMuerte >= :anioInicio)
""")
    List<Autor> encontrarAutoresVivosEntre(
            @Param("anioInicio") Integer anioInicio,
            @Param("anioFin") Integer anioFin
    );
}
