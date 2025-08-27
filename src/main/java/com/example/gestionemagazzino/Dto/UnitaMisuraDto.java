package com.example.gestionemagazzino.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UnitaMisuraDto {

    private int id;

    @NotBlank(message = "inserire una descrizione")
    @Size(min = 5, max = 1000, message = "la descrizione deve contenere almeno 2 caratteri" )
    private String descrizione;

    public UnitaMisuraDto(int id, String descrizione) {
        this.id = id;
        this.descrizione = descrizione;
    }

    public UnitaMisuraDto() {
    }

    public UnitaMisuraDto(int id) {
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
