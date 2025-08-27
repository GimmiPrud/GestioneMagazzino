package com.example.gestionemagazzino.Dto;



import java.util.List;

public class OrdineProdottoDto {
    private OrdineDto ordine;
    private List<ProdottoDto> prodotti;

    public OrdineProdottoDto(OrdineDto ordine, List<ProdottoDto> prodotti) {
        this.ordine = ordine;
        this.prodotti = prodotti;
    }

    public OrdineProdottoDto() {
    }

    public OrdineDto getOrdine() {
        return ordine;
    }

    public void setOrdine(OrdineDto ordine) {
        this.ordine = ordine;
    }

    public List<ProdottoDto> getProdotti() {
        return prodotti;
    }

    public void setProdotti(List<ProdottoDto> prodotti) {
        this.prodotti = prodotti;
    }
}
