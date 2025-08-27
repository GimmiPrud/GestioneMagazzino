package com.example.gestionemagazzino.Entity;

import jakarta.persistence.*;

@Entity(name = "ORDINEREFPRODOTTO")
public class OrdineRefProdotto {

    @EmbeddedId
    private OrdineRefProdottoId id;

    @ManyToOne
    @MapsId("ordine")
    @JoinColumn(name = "ORDINE_ID")
    private Ordine ordine;

    @ManyToOne
    @MapsId("prodotto")
    @JoinColumn(name = "PRODOTTO_ID")
    private Prodotto prodotto;

    public OrdineRefProdotto() {}

    public OrdineRefProdotto(Ordine ordine, Prodotto prodotto) {
        this.ordine = ordine;
        this.prodotto = prodotto;
        this.id = new OrdineRefProdottoId(ordine.getId(), prodotto.getId());
    }

    public OrdineRefProdottoId getId() {
        return id;
    }

    public void setId(OrdineRefProdottoId id) {
        this.id = id;
    }

    public Ordine getOrdine() {
        return ordine;
    }

    public void setOrdine(Ordine ordine) {
        this.ordine = ordine;
    }

    public Prodotto getProdotto() {
        return prodotto;
    }

    public void setProdotto(Prodotto prodotto) {
        this.prodotto = prodotto;
    }
}

