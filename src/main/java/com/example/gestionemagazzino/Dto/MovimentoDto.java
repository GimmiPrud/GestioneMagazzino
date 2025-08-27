package com.example.gestionemagazzino.Dto;


import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public class MovimentoDto {
    private int id;

    @NotBlank(message = "tipo di movimento obbligatorio")
    private String tipo;

    @NotNull(message = "la data deve essere inserita")
    private LocalDateTime dataOra;

    @NotBlank(message = "descrizione richiesta")
    @Size(min = 10, max = 1000, message = "la descrizione deve essere lunga almeno 10 caratteri")
    private String descrizione;

    @NotNull
    @Valid
    private OrdineDto ordine;

    public MovimentoDto(int id, String tipo, LocalDateTime dataOra, String descrizione, OrdineDto ordine) {
        this.id = id;
        this.tipo = tipo;
        this.dataOra = dataOra;
        this.descrizione = descrizione;
        this.ordine = ordine;
    }

    public MovimentoDto() {
    }

    public MovimentoDto(int id) {
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

    public OrdineDto getOrdine() {
        return ordine;
    }

    public void setOrdine(OrdineDto ordine) {
        this.ordine = ordine;
    }
}
