package com.example.gestionemagazzino.Utility;


import com.example.gestionemagazzino.Dto.*;
import com.example.gestionemagazzino.Entity.*;

public class Conversioni {

    // Conversione CATEGORIA
    public static Categoria daCategoriaDTOACategoria(CategoriaDto dto) {
        return new Categoria(dto.getId(), dto.getNome());
    }

    public static CategoriaDto daCategoriaACategoriaDTO(Categoria categoria) {
        return new CategoriaDto(categoria.getId(), categoria.getNome());
    }

    // CATEGORIA ID
    public static Categoria daCategoriaDTOACategoriaId(CategoriaDto dto) {
        return new Categoria(dto.getId());
    }

    public static CategoriaDto daCategoriaACategoriaDTOId(Categoria categoria) {
        return new CategoriaDto(categoria.getId());
    }


    // Conversione CLIENTE
    public static Cliente daClienteDTOACliente(ClienteDto dto) {
        return new Cliente(
                dto.getId(),
                dto.getNome(),
                dto.getCognome(),
                dto.getIndirizzo(),
                dto.getCodiceFiscale(),
                dto.getEmail(),
                dto.getTelefono(),
                dto.getNumeroCarta(),
                dto.getPartitaIva()
        );
    }

    public static ClienteDto daClienteAClienteDTO(Cliente cliente) {
        return new ClienteDto(
                cliente.getId(),
                cliente.getNome(),
                cliente.getCognome(),
                cliente.getIndirizzo(),
                cliente.getCodiceFiscale(),
                cliente.getEmail(),
                cliente.getTelefono(),
                cliente.getNumeroCarta(),
                cliente.getPartitaIva()

        );
    }

    // CLIENTE ID
    public static Cliente daClienteDTOAClienteId(ClienteDto dto) {
        return new Cliente(
                dto.getId()
        );
    }

    public static ClienteDto daClienteAClienteDTOId(Cliente cliente) {
        return new ClienteDto(
                cliente.getId()
        );
    }

    // Conversione MOVIMENTO
    public static Movimento daMovimentoDTOAMovimento(MovimentoDto dto) {
        return new Movimento(dto.getId(),dto.getTipo(),dto.getDataOra(),dto.getDescrizione(),Conversioni.daOrdineDTOAOrdine(dto.getOrdine()));
    }

    public static MovimentoDto daMovimentoAMovimentoDTO(Movimento movimento) {
        return new MovimentoDto(movimento.getId(),movimento.getTipo(),movimento.getDataOra(),movimento.getDescrizione(),Conversioni.daOrdineAOrdineDTO(movimento.getOrdine()));
    }

    // MOVIMENTO ID
    public static Movimento daMovimentoDTOAMovimentoId(MovimentoDto dto) {
        return new Movimento(dto.getId());
    }

    public static MovimentoDto daMovimentoAMovimentoDTOId(Movimento movimento) {
        return new MovimentoDto(movimento.getId());
    }


    // Conversione ORDINE
    public static Ordine daOrdineDTOAOrdine(OrdineDto dto) {
        return new Ordine(dto.getId(),dto.getQuantita(),dto.getDataOra(),dto.getPrezzoTotale(),dto.isSospeso(),
                Conversioni.daClienteDTOACliente(dto.getCliente()));
    }

    public static OrdineDto daOrdineAOrdineDTO(Ordine ordine) {
        return new OrdineDto(ordine.getId(),ordine.getQuantita(),ordine.getDataOra(),ordine.getPrezzoTotale(),ordine.isSospeso(),
                Conversioni.daClienteAClienteDTO(ordine.getCliente()));
    }

    // Conversione ORDINEREFPRODOTTO
    public static OrdineRefProdotto daOrdineRefProdottoDTOaOrdineRefProdotto(Ordine o, Prodotto p) {
        return new OrdineRefProdotto(o,p);
    }

    public static OrdineRefProdottoDto daOrdineRefProdottoAOrdineRefProdottoDTO(OrdineRefProdotto or) {
        return new OrdineRefProdottoDto(or.getOrdine().getId(), or.getProdotto().getId());
    }


    // Conversione PRODOTTO
    public static Prodotto daProdottoDTOAProdotto(ProdottoDto dto) {
        return new Prodotto(
                dto.getId(),
                dto.getNome(),
                dto.getPrezzo(),
                dto.getDescrizione(),
                dto.getQuantita(),
                dto.isDisponibilita(),
                Conversioni.daUnitaMisuraDTOAUnitaMisura(dto.getUnitaMisura()),
                Conversioni.daSottoCategoriaDTOASottoCategoria(dto.getSottoCategoria())

        );
    }

    public static ProdottoDto daProdottoAProdottoDTO(Prodotto prodotto) {
        return new ProdottoDto(
                prodotto.getId(),
                prodotto.getNome(),
                prodotto.getPrezzo(),
                prodotto.getDescrizione(),
                prodotto.getQuantita(),
                prodotto.isDisponibilita(),
                Conversioni.daUnitaMisuraAUnitaMisuraDTO(prodotto.getUnitaMisura()),
                Conversioni.daSottoCategoriaASottoCategoriaDTO(prodotto.getSottoCategoria())
        );
    }

    // PRODOTTO ID
    public static Prodotto daProdottoDTOAProdottoId(ProdottoDto dto) {
        return new Prodotto(
                dto.getId()
        );
    }

    public static ProdottoDto daProdottoAProdottoDTOId(Prodotto prodotto) {
        return new ProdottoDto(
                prodotto.getId()
        );
    }


    // Conversione SOTTOCATEGORIA
    public static SottoCategoria daSottoCategoriaDTOASottoCategoria(SottoCategoriaDto dto) {
        return new SottoCategoria(dto.getId(), dto.getNome(), Conversioni.daCategoriaDTOACategoria(dto.getCategoria()));
    }

    public static SottoCategoriaDto daSottoCategoriaASottoCategoriaDTO(SottoCategoria sc) {
        return new SottoCategoriaDto(sc.getId(), sc.getNome(),Conversioni.daCategoriaACategoriaDTO(sc.getCategoria()));
    }

    // SOTTOCATEGORIA ID
    public static SottoCategoria daSottoCategoriaDTOASottoCategoriaId(SottoCategoriaDto dto) {
        return new SottoCategoria(dto.getId());
    }

    public static SottoCategoriaDto daSottoCategoriaASottoCategoriaDTOId(SottoCategoria sc) {
        return new SottoCategoriaDto(sc.getId());
    }


    // Conversione UNITA DI MISURA
    public static UnitaMisura daUnitaMisuraDTOAUnitaMisura(UnitaMisuraDto dto) {
        return new UnitaMisura(dto.getId(), dto.getDescrizione());
    }

    public static UnitaMisuraDto daUnitaMisuraAUnitaMisuraDTO(UnitaMisura um) {
        return new UnitaMisuraDto(um.getId(), um.getDescrizione());
    }

    // UNITA DI MISURA ID
    public static UnitaMisura daUnitaMisuraDTOAUnitaMisuraId(UnitaMisuraDto dto) {
        return new UnitaMisura(dto.getId());
    }

    public static UnitaMisuraDto daUnitaMisuraAUnitaMisuraDTOId(UnitaMisura um) {
        return new UnitaMisuraDto(um.getId());
    }


}

