package com.example.gestionemagazzino.Entity;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class OrdineRefProdottoId implements Serializable {
    private int ordine;
    private int prodotto;

    public OrdineRefProdottoId() {}

    public OrdineRefProdottoId(int ordine, int prodotto) {
        this.ordine = ordine;
        this.prodotto = prodotto;
    }

    // Getters, Setters, equals(), hashCode()

    public int getOrdine() {
        return ordine;
    }

    public void setOrdine(int ordine) {
        this.ordine = ordine;
    }

    public int getProdotto() {
        return prodotto;
    }

    public void setProdotto(int prodotto) {
        this.prodotto = prodotto;
    }
}

