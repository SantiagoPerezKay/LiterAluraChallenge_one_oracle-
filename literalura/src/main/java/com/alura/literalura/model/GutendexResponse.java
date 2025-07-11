package com.alura.literalura.model;



import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class GutendexResponse {

    private int count;

    private String next;

    private String previous;

    @JsonProperty("results")
    private List<Libro> results;

    // Getters y setters

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public List<Libro> getResults() {
        return results;
    }

    public void setResults(List<Libro> results) {
        this.results = results;
    }
}
