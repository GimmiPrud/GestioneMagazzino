package com.example.gestionemagazzino.Entity;

import jakarta.persistence.*;

@Entity(name = "UNITAMISURA")
public class UnitaMisura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "DESCRIZIONE")
    private String descrizione;

    public UnitaMisura(int id, String descrizione) {
        this.id = id;
        this.descrizione = descrizione;
    }

    public UnitaMisura() {
    }

    public UnitaMisura(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
}
