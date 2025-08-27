package com.example.gestionemagazzino.Dto;



public class OrdineRefProdottoDto {
    private int ordineId;
    private int prodottoId;

    public OrdineRefProdottoDto(int ordineId, int prodottoId) {
        this.ordineId = ordineId;
        this.prodottoId = prodottoId;
    }

    public OrdineRefProdottoDto() {
    }

    public int getOrdineId() {
        return ordineId;
    }

    public void setOrdine(int ordineId) {
        this.ordineId = ordineId;
    }

    public int getProdotto() {
        return prodottoId;
    }

    public void setProdotto(int prodottoId) {
        this.prodottoId = prodottoId;
    }
}
