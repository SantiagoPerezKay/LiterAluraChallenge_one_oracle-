package com.alura.literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonAlias("title")
    private String titulo;

    @ManyToMany(cascade =  CascadeType.MERGE)
    @JoinTable(
            name = "libro_autor",
            joinColumns = @JoinColumn(name = "libro_id"),
            inverseJoinColumns = @JoinColumn(name = "autor_id")
    )
    @JsonAlias("authors")
    private List<Autor> autores;

    @JsonAlias("languages")
    private List<String> idioma;

    @JsonAlias("download_count")
    private Long numerodedescargas;



    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }


    public List<String> getIdioma() {
        return idioma;
    }

    public void setIdioma(List<String> idioma) {
        this.idioma = idioma;
    }

    public Long getNumerodedescargas() {
        return numerodedescargas;
    }

    public void setNumerodedescargas(Long numerodedescargas) {
        this.numerodedescargas = numerodedescargas;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Libro:"+'\''+

                "titulo='" + titulo + '\'' +
                ", autor=" + (autores != null ? autores.size() : 0)  +
                ", idioma=" + idioma +
                ", numerodedescargas=" + numerodedescargas
               ;
    }
}
