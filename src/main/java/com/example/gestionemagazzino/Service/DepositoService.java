package com.example.gestionemagazzino.Service;


import com.example.gestionemagazzino.Dao.CategoriaDao;
import com.example.gestionemagazzino.Dao.ProdottoDao;
import com.example.gestionemagazzino.Dao.SottoCategoriaDao;
import com.example.gestionemagazzino.Dao.UnitaMisuraDao;
import com.example.gestionemagazzino.Dto.CategoriaDto;
import com.example.gestionemagazzino.Dto.ProdottoDto;
import com.example.gestionemagazzino.Dto.SottoCategoriaDto;
import com.example.gestionemagazzino.Dto.UnitaMisuraDto;
import com.example.gestionemagazzino.Entity.Categoria;
import com.example.gestionemagazzino.Entity.Prodotto;
import com.example.gestionemagazzino.Entity.SottoCategoria;
import com.example.gestionemagazzino.Entity.UnitaMisura;
import com.example.gestionemagazzino.Utility.Conversioni;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class DepositoService implements DepositoServiceInt{

    @Autowired
    private ProdottoDao prodottoDao;
    @Autowired
    private SottoCategoriaDao sottoCategoriaDao;
    @Autowired
    private CategoriaDao categoriaDao;
    @Autowired
    private UnitaMisuraDao unitaMisuraDao;


    @Override
    public List<ProdottoDto> cercaProdottoPerCategoria(int idCat) {
        List<Prodotto> LP = prodottoDao.findProdottiByCategoria(idCat);
        List<ProdottoDto> LD = new ArrayList<>();
        for (Prodotto p : LP) {
            LD.add(Conversioni.daProdottoAProdottoDTO(p));
        }
        return LD;
    }

    @Override
    public List<ProdottoDto> findByCategoriaAndSotto(int id, int sottoId) {
        List<Prodotto> LP = prodottoDao.findByCategoriaAndSotto(id, sottoId);
        List<ProdottoDto> LD = new ArrayList<>();
        for (Prodotto p : LP) {
            LD.add(Conversioni.daProdottoAProdottoDTO(p));
        }
        return LD;
    }

    @Override
    public ProdottoDto insertProdotto(ProdottoDto prod) {
        SottoCategoria sottoC = sottoCategoriaDao.findSottoCategoriaById(prod.getSottoCategoria().getId());
        UnitaMisura unitaM = unitaMisuraDao.findUnitaMisuraById(prod.getUnitaMisura().getId());
        Prodotto e = Conversioni.daProdottoDTOAProdotto(prod);
        e.setSottoCategoria(sottoC);
        e.setUnitaMisura(unitaM);
        return Conversioni.daProdottoAProdottoDTO(prodottoDao.insertProdotto(e));
    }

    @Override
    public ProdottoDto updateProdotto( int id,ProdottoDto prod) {
        Prodotto p = prodottoDao.findProdottoById(id);
        if(p !=null){
            if(prod.getNome()!=null){
                p.setNome(prod.getNome());
            }
            p.setPrezzo(prod.getPrezzo());
            if(prod.getDescrizione()!=null){
                p.setDescrizione(prod.getDescrizione());
            }
            p.setQuantita(prod.getQuantita());
            Prodotto P = prodottoDao.updateProdotto(p);
            return Conversioni.daProdottoAProdottoDTO(P);
        } else {
            throw new RuntimeException("Prodotto non trovata");
        }
    }

    @Override
    public ProdottoDto deleteProdotto(int id) {
        Prodotto p = prodottoDao.deleteProdotto(id);
        return Conversioni.daProdottoAProdottoDTO(p);
    }

    @Override
    public ProdottoDto cercaProdottoPerId(int id) {
        Prodotto p = prodottoDao.findProdottoById(id);
        return Conversioni.daProdottoAProdottoDTO(p);
    }

    @Override
    public List<ProdottoDto> listaProdotti() {
        List<Prodotto> LC = prodottoDao.findAllProdotti();
        List<ProdottoDto> LD = new ArrayList<>();
        for (Prodotto p : LC) {
            LD.add(Conversioni.daProdottoAProdottoDTO(p));
        }
        return LD;
    }

    @Override
    public ProdottoDto updateDisponibilita(int id) {
        Prodotto p = prodottoDao.findProdottoById(id);
        if(p!=null){
            if(p.getQuantita() == 0.0){
                Prodotto pp =  prodottoDao.updateDisponibilita(p.getId());
                return Conversioni.daProdottoAProdottoDTO(pp);
            } else {
                p.setDisponibilita(true);
                return Conversioni.daProdottoAProdottoDTO(p);
            }
        } else {
            throw new RuntimeException("Prodotto non trovata");
        }
    }

    @Override
    public CategoriaDto insertCategoria(CategoriaDto cat) {
        Categoria c = Conversioni.daCategoriaDTOACategoria(cat);
        Categoria insertC = categoriaDao.insertCategoria(c);
        return Conversioni.daCategoriaACategoriaDTO(insertC);
    }

    @Override
    public CategoriaDto cercaCategoriaPerId(int id) {
        Categoria c = categoriaDao.findCategoriaById(id);
        return Conversioni.daCategoriaACategoriaDTO(c);
    }

    @Override
    public List<CategoriaDto> listaCategorie() {
        List<Categoria> LC = categoriaDao.findAllCategoria();
        List<CategoriaDto> LD = new ArrayList<>();
        for (Categoria c : LC) {
            LD.add(Conversioni.daCategoriaACategoriaDTO(c));
        }
        return LD;
    }

    @Override
    public CategoriaDto updateCategoria( int id,CategoriaDto cat) {
        Categoria c = categoriaDao.findCategoriaById(id);
        if(c!=null){
            if(cat.getNome()!=null){
                c.setNome(cat.getNome());
            }
            Categoria P = categoriaDao.updateCategoria(c);
            return Conversioni.daCategoriaACategoriaDTO(P);
        } else  {
            throw new RuntimeException("Categoria non trovata");
        }
    }

    @Override
    public CategoriaDto deleteCategoria(int idCat) {
        Categoria c = categoriaDao.deleteCategoria(idCat);
        return Conversioni.daCategoriaACategoriaDTO(c);
    }

    @Override
    public SottoCategoriaDto insertSottoCategoria(SottoCategoriaDto sottoCat) {
        Categoria cat = categoriaDao.findCategoriaById(sottoCat.getCategoria().getId());
        SottoCategoria e = Conversioni.daSottoCategoriaDTOASottoCategoria(sottoCat);
        e.setCategoria(cat);
        return Conversioni.daSottoCategoriaASottoCategoriaDTO(sottoCategoriaDao.insertSottoCategoria(e));
    }

    @Override
    public SottoCategoriaDto cercaSottoCategoriaPerId(int id) {
        SottoCategoria sc = sottoCategoriaDao.findSottoCategoriaById(id);
        return Conversioni.daSottoCategoriaASottoCategoriaDTO(sc);
    }

    @Override
    public List<SottoCategoriaDto> listaSottoCategorie() {
        List<SottoCategoria> LC = sottoCategoriaDao.findAllSottoCategoria();
        List<SottoCategoriaDto> LD = new ArrayList<>();
        for (SottoCategoria c : LC) {
            LD.add(Conversioni.daSottoCategoriaASottoCategoriaDTO(c));
        }
        return LD;
    }

    @Override
    public SottoCategoriaDto updateSottoCategoria(int id,SottoCategoriaDto sottoCat) {
        SottoCategoria s =  sottoCategoriaDao.findSottoCategoriaById(id);
        if(s!=null){
            if(sottoCat.getNome()!=null){
                s.setNome(sottoCat.getNome());
            }
            SottoCategoria P = sottoCategoriaDao.updateSottoCategoria(s);
            return Conversioni.daSottoCategoriaASottoCategoriaDTO(P);
        } else   {
            throw new RuntimeException("SottoCategoria non trovata");
        }
    }

    @Override
    public SottoCategoriaDto deleteSottoCategoria(int idSottoCat) {
        SottoCategoria sc = sottoCategoriaDao.deleteSottoCategoria(idSottoCat);
        return Conversioni.daSottoCategoriaASottoCategoriaDTO(sc);
    }

    @Override
    public UnitaMisuraDto insertMisura(UnitaMisuraDto um) {
        UnitaMisura u = Conversioni.daUnitaMisuraDTOAUnitaMisura(um);
        UnitaMisura insertU = unitaMisuraDao.insertUnitaMisura(u);
        return Conversioni.daUnitaMisuraAUnitaMisuraDTO(insertU);
    }

    @Override
    public UnitaMisuraDto cercaMisuraPerId(int id) {
        UnitaMisura u = unitaMisuraDao.findUnitaMisuraById(id);
        return Conversioni.daUnitaMisuraAUnitaMisuraDTO(u);
    }

    @Override
    public List<UnitaMisuraDto> listaMisure() {
        List<UnitaMisura> LC = unitaMisuraDao.findAllUnitaMisura();
        List<UnitaMisuraDto> LD = new ArrayList<>();
        for (UnitaMisura c : LC) {
            LD.add(Conversioni.daUnitaMisuraAUnitaMisuraDTO(c));
        }
        return LD;
    }

    @Override
    public UnitaMisuraDto updateMisura(int id,UnitaMisuraDto um) {
        UnitaMisura  u = unitaMisuraDao.findUnitaMisuraById(id);
        if(u!=null){
            if (um.getDescrizione()!=null){
                u.setDescrizione(um.getDescrizione());
            }
            UnitaMisura P = unitaMisuraDao.updateUnitaMisura(u);
            return Conversioni.daUnitaMisuraAUnitaMisuraDTO(P);
        } else   {
            throw new RuntimeException("Misurazione non trovata");
        }
    }

    @Override
    public UnitaMisuraDto deleteMisura(int idUm) {
        UnitaMisura um = unitaMisuraDao.deleteUnitaMisura(idUm);
        return Conversioni.daUnitaMisuraAUnitaMisuraDTO(um);
    }
}

