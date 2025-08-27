package com.example.gestionemagazzino.Dto;


import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

import java.time.LocalDateTime;
import java.util.List;

public class OrdineDto {

    private int id;


    @Positive(message = "la quantità non può essere 0 o minore di 0")
    private int quantita;

    @NotNull(message = "la data deve essere presente")
    private LocalDateTime dataOra;

    @Positive(message = "prezzo totale non valido")
    private double prezzoTotale;

    @NotNull(message = "inserire un valore di default")
    private boolean sospeso;

    @NotNull
    @Valid
    private ClienteDto cliente;

    public OrdineDto(int id, int quantita, LocalDateTime dataOra, double prezzoTotale, boolean sospeso, ClienteDto cliente) {
        this.id = id;
        this.quantita = quantita;
        this.dataOra = dataOra;
        this.prezzoTotale = prezzoTotale;
        this.sospeso = sospeso;
        this.cliente = cliente;
    }

    public OrdineDto() {
    }

    public OrdineDto(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    public LocalDateTime getDataOra() {
        return dataOra;
    }

    public void setDataOra(LocalDateTime dataOra) {
        this.dataOra = dataOra;
    }

    public double getPrezzoTotale() {
        return prezzoTotale;
    }

    public void setPrezzoTotale(double prezzoTotale) {
        this.prezzoTotale = prezzoTotale;
    }

    public boolean isSospeso() {
        return sospeso;
    }

    public void setSospeso(boolean sospeso) {
        this.sospeso = sospeso;
    }

    public ClienteDto getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDto cliente) {
        this.cliente = cliente;
    }

}
