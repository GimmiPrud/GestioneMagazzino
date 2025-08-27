package com.example.gestionemagazzino.Entity;

import jakarta.persistence.*;

@Entity(name = "PRODOTTO")
public class Prodotto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "NOME")
    private String nome;
    @Column(name = "PREZZO")
    private double prezzo;
    @Column(name = "DESCRIZIONE")
    private String descrizione;
    @Column(name = "QUANTITA")
    private double quantita;
    @Column(name = "DISPONIBILITA")
    private boolean disponibilita;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "UNITAMISURA_ID")
    private UnitaMisura unitaMisura;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "SOTTOCATEGORIA_ID")
    private SottoCategoria sottoCategoria;

    public Prodotto(int id, String nome, double prezzo, String descrizione, double quantita, boolean disponibilita, UnitaMisura unitaMisura, SottoCategoria sottoCategoria) {
        this.id = id;
        this.nome = nome;
        this.prezzo = prezzo;
        this.descrizione = descrizione;
        this.quantita = quantita;
        this.disponibilita = disponibilita;
        this.unitaMisura = unitaMisura;
        this.sottoCategoria = sottoCategoria;
    }

    public Prodotto() {
    }

    public Prodotto(int id) {
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

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public double getQuantita() {
        return quantita;
    }

    public void setQuantita(double quantita) {
        this.quantita = quantita;
    }

    public boolean isDisponibilita() {
        return disponibilita;
    }

    public void setDisponibilita(boolean disponibilita) {
        this.disponibilita = disponibilita;
    }

    public UnitaMisura getUnitaMisura() {
        return unitaMisura;
    }

    public void setUnitaMisura(UnitaMisura unitaMisura) {
        this.unitaMisura = unitaMisura;
    }

    public SottoCategoria getSottoCategoria() {
        return sottoCategoria;
    }

    public void setSottoCategoria(SottoCategoria sottoCategoria) {
        this.sottoCategoria = sottoCategoria;
    }
}
