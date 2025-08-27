package com.example.gestionemagazzino.Dto;


import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

public class ProdottoDto {

    private int id;

    @NotBlank(message = "il nome deve essere inserito")
    @Size(min = 3, max = 50, message = "deve contenere almeno 3 caratteri")
    private String nome;

    @Positive(message = "errore nell'inserimento del prezzo")
    private double prezzo;

    @NotBlank(message = "la descrizione deve essere inserita")
    @Size(min = 15, max = 1000, message = "la descrizione deve essere lunga almeno 15 caratteri")
    private String descrizione;

    @PositiveOrZero
    private double quantita;

    @NotNull
    private boolean disponibilita;

    @NotNull
    @Valid
    private UnitaMisuraDto unitaMisura;

    @NotNull
    @Valid
    private SottoCategoriaDto sottoCategoria;

    public ProdottoDto(int id, String nome, double prezzo, String descrizione, double quantita, boolean disponibilita, UnitaMisuraDto unitaMisura, SottoCategoriaDto sottoCategoria) {
        this.id = id;
        this.nome = nome;
        this.prezzo = prezzo;
        this.descrizione = descrizione;
        this.quantita = quantita;
        this.disponibilita = disponibilita;
        this.unitaMisura = unitaMisura;
        this.sottoCategoria = sottoCategoria;
    }

    public ProdottoDto() {
    }

    public ProdottoDto(int id) {
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

    public UnitaMisuraDto getUnitaMisura() {
        return unitaMisura;
    }

    public void setUnitaMisura(UnitaMisuraDto unitaMisura) {
        this.unitaMisura = unitaMisura;
    }

    public SottoCategoriaDto getSottoCategoria() {
        return sottoCategoria;
    }

    public void setSottoCategoria(SottoCategoriaDto sottoCategoria) {
        this.sottoCategoria = sottoCategoria;
    }
}
