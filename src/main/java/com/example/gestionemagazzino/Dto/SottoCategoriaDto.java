package com.example.gestionemagazzino.Dto;


import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class SottoCategoriaDto {

    private int id;

    @NotBlank(message = "inserire il nome della sottocategoria")
    private String nome;

    @NotNull( message = "la categoria deve essere presente")
    @Valid
    private CategoriaDto categoria;

    public SottoCategoriaDto(int id, String nome, CategoriaDto categoria) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
    }

    public SottoCategoriaDto() {
    }

    public SottoCategoriaDto(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public CategoriaDto getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaDto categoria) {
        this.categoria = categoria;
    }
}
