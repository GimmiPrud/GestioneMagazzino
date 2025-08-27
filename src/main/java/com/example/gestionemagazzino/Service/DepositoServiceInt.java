package com.example.gestionemagazzino.Service;


import com.example.gestionemagazzino.Dto.CategoriaDto;
import com.example.gestionemagazzino.Dto.ProdottoDto;
import com.example.gestionemagazzino.Dto.SottoCategoriaDto;
import com.example.gestionemagazzino.Dto.UnitaMisuraDto;

import java.util.List;

public interface DepositoServiceInt {

    // METODI PER PRODOTTO
    public List<ProdottoDto> cercaProdottoPerCategoria(int cat);
    public List<ProdottoDto> findByCategoriaAndSotto(int id, int sottoId);
    public ProdottoDto insertProdotto(ProdottoDto prod);
    public ProdottoDto updateProdotto(int id,ProdottoDto prod);
    public ProdottoDto deleteProdotto(int id);
    public ProdottoDto cercaProdottoPerId(int id);
    public List<ProdottoDto> listaProdotti();
    public ProdottoDto updateDisponibilita(int id);

    // METODI PER CATEGORIA
    public CategoriaDto insertCategoria(CategoriaDto cat);
    public CategoriaDto cercaCategoriaPerId(int id);
    public List<CategoriaDto> listaCategorie();
    public CategoriaDto updateCategoria(int id,CategoriaDto cat);
    public CategoriaDto deleteCategoria(int idCat);

    // METODI PER SOTTOCATEGORIA
    public SottoCategoriaDto insertSottoCategoria(SottoCategoriaDto sottoCat);
    public SottoCategoriaDto cercaSottoCategoriaPerId(int id);
    public List<SottoCategoriaDto> listaSottoCategorie();
    public SottoCategoriaDto updateSottoCategoria(int id,SottoCategoriaDto sottoCat);
    public SottoCategoriaDto deleteSottoCategoria(int idSottoCat);


    // METODI PER UNITÀ DI MISURA
    public UnitaMisuraDto insertMisura(UnitaMisuraDto um);
    public UnitaMisuraDto cercaMisuraPerId(int id);
    public List<UnitaMisuraDto> listaMisure();
    public UnitaMisuraDto updateMisura(int id,UnitaMisuraDto um);
    public UnitaMisuraDto deleteMisura(int idUm);
}
