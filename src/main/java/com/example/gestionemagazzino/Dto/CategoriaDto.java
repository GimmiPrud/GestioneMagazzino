package com.example.gestionemagazzino.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CategoriaDto {

    private int id;

    @NotBlank(message = "il nome deve essere inserito")
    @Size(min = 1, max = 100, message = "il nome deve avere almeno un carattere")
    private String nome;

    public CategoriaDto(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public CategoriaDto() {
    }

    public CategoriaDto(int id) {
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
}
