package com.example.gestionemagazzino.Dto;

import jakarta.validation.constraints.*;

public class ClienteDto {

    private int id;

    @NotBlank(message = "il nome deve essere inserito")
    @Size(min = 1, max = 100, message = "il nome deve avere almeno un carattere")
    private String nome;

    @NotBlank(message = "il cognome deve essere inserito")
    @Size(min = 1, max = 100, message = "il cognome deve avere almeno un carattere")
    private String cognome;

    @Size(min = 5, max = 100, message = "L'indirizzo deve avere almeno cinque caratteri")
    private String indirizzo;

    @NotBlank(message = "il codice fiscale deve essere inserito")
    @Size(min = 16, max = 16, message = " il codice fiscale deve contenere 16 caratteri")
    private String codiceFiscale;

    @Email(message = "inserire una email valida ")
    private String email;

    private String telefono;

    @NotBlank(message = "numero carta richiesto")
    @Size(min = 15, max = 19, message = "errore")
    private String numeroCarta;

    @Size( min = 11, max = 11, message = " La Partita Iva deve contenere 11 caratteri")
    private String partitaIva;

    public ClienteDto(int id, String nome, String cognome, String indirizzo, String codiceFiscale, String email, String telefono, String numeroCarta, String partitaIva) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.indirizzo = indirizzo;
        this.codiceFiscale = codiceFiscale;
        this.email = email;
        this.telefono = telefono;
        this.numeroCarta = numeroCarta;
        this.partitaIva = partitaIva;
    }

    public ClienteDto() {
    }

    public ClienteDto(int id) {
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

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNumeroCarta() {
        return numeroCarta;
    }

    public void setNumeroCarta(String numeroCarta) {
        this.numeroCarta = numeroCarta;
    }

    public String getPartitaIva() {
        return partitaIva;
    }

    public void setPartitaIva(String partitaIva) {
        this.partitaIva = partitaIva;
    }
}
