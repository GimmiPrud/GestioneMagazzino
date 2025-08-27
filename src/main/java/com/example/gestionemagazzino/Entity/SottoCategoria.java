package com.example.gestionemagazzino.Entity;

import jakarta.persistence.*;

@Entity(name = "SOTTOCATEGORIA")
public class SottoCategoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "NOME")
    private String nome;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "CATEGORIA_ID")
    private Categoria categoria;

    public SottoCategoria(int id, String nome, Categoria categoria) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
    }

    public SottoCategoria() {
    }

    public SottoCategoria(int id) {
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

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
