package com.example.gestionemagazzino.Entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity(name = "MOVIMENTO")
public class Movimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "TIPO")
    private String tipo;
    @Column(name = "DATA_ORA")
    private LocalDateTime dataOra;
    @Column(name = "DESCRIZIONE")
    private String descrizione;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ORDINE_ID")
    private Ordine ordine;

    public Movimento(int id, String tipo, LocalDateTime dataOra, String descrizione, Ordine ordine) {
        this.id = id;
        this.tipo = tipo;
        this.dataOra = dataOra;
        this.descrizione = descrizione;
        this.ordine = ordine;
    }

    public Movimento() {
    }

    public Movimento(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDateTime getDataOra() {
        return dataOra;
    }

    public void setDataOra(LocalDateTime dataOra) {
        this.dataOra = dataOra;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public Ordine getOrdine() {
        return ordine;
    }

    public void setOrdine(Ordine ordine) {
        this.ordine = ordine;
    }
}
