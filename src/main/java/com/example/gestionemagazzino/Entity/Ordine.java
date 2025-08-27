package com.example.gestionemagazzino.Entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "ORDINE")
public class Ordine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "QUANTITA")
    private int quantita;
    @Column(name = "DATA_ORA")
    private LocalDateTime dataOra;
    @Column(name = "PREZZO_TOTALE")
    private double prezzoTotale;
    @Column(name = "SOSPESO")
    private boolean sospeso;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "CLIENTE_ID")
    private Cliente cliente;


    public Ordine(int id, int quantita, LocalDateTime dataOra, double prezzoTotale, boolean sospeso, Cliente cliente) {
        this.id = id;
        this.quantita = quantita;
        this.dataOra = dataOra;
        this.prezzoTotale = prezzoTotale;
        this.sospeso = sospeso;
        this.cliente = cliente;
    }

    public Ordine() {
    }

    public Ordine(int id) {
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
