package com.alura.literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @JsonAlias("name")
    private String name;

    @JsonAlias("birth_year")
    private Integer anioNacimiento;

    @JsonAlias("death_year")
    private Integer anioMuerte;

    @ManyToMany(mappedBy = "autores")
    private List<Libro> libros;


    public Integer getAnioMuerte() {
        return anioMuerte;
    }

    public void setAnioMuerte(Integer anioMuerte) {
        this.anioMuerte = anioMuerte;
    }

    public Integer getAnioNacimiento() {
        return anioNacimiento;
    }

    public void setAnioNacimiento(Integer anioNacimiento) {
        this.anioNacimiento = anioNacimiento;
    }

    public Long getId() {
        return Id;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "name='" + name + '\'' +
                ", anioNacimiento=" + anioNacimiento +
                ", anioMuerte=" + anioMuerte +
                ", libros=" + libros +
                '}';
    }
}
