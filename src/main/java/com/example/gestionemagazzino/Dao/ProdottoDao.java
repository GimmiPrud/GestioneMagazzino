package com.example.gestionemagazzino.Dao;


import com.example.gestionemagazzino.Entity.Prodotto;
import com.example.gestionemagazzino.Repository.ProdottoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProdottoDao {

    @Autowired
    private ProdottoRepo prodottoRepo;

    public Prodotto insertProdotto(Prodotto P){
        try {
             return prodottoRepo.save(P);
        } catch (Exception e) {
            throw new RuntimeException("Errore nell'inserimento del Prodotto",e);
        }
    }

    public Prodotto findProdottoById(int id){
        if(prodottoRepo.findById(id).isPresent()){
            return prodottoRepo.findById(id).get();
        } else{
            throw new RuntimeException("Prodotto non trovato");
        }
    }

    public List<Prodotto> findAllProdotti(){
        if(prodottoRepo.findAll().isEmpty()){
            throw new RuntimeException("Non ci sono Prodotti");
        } else {
            return prodottoRepo.findAll();
        }
    }

    public Prodotto updateProdotto(Prodotto P){
        try {
            if(prodottoRepo.existsById(P.getId())){
                 return prodottoRepo.save(P);
            } else {
                throw new RuntimeException("Prodotto non trovato");
            }
        } catch (Exception e) {
            throw new RuntimeException("Errore nella modifica del Prodotto",e);
        }
    }

    public Prodotto deleteProdotto(int id){
        try {
            if (prodottoRepo.findById(id).isPresent()) {
                Prodotto p =  prodottoRepo.findById(id).get();
                prodottoRepo.delete(p);
                return p;
            } else  {
                throw new RuntimeException("Prodotto non trovato");
            }
        } catch (Exception e) {
            throw new RuntimeException("Errore nell'eliminazione del prodotto",e);
        }
    }

    public List<Prodotto> findProdottiByCategoria(int id){
        try{
            List<Prodotto> LP = prodottoRepo.findByCategoria(id);
                return LP;
        } catch (Exception e) {
            throw new RuntimeException("Errore nella richiesta del prodotto");
        }
    }

    public Prodotto updateDisponibilita(int id){
        try{
            if(prodottoRepo.findById(id).isPresent()){
                Prodotto p =  prodottoRepo.findById(id).get();
                prodottoRepo.updateDisponibilita(p.getId());
                return p;
            } else {
                throw new RuntimeException("Prodotto non trovato");
            }
        } catch (Exception e) {
            throw new RuntimeException("Errore nella richiesta  del prodotto");
        }
    }

    public List<Prodotto> findAllProdottiByCategoria(int id){
        try{
            List<Prodotto> LP = prodottoRepo.findByCategoria(id);
            if (LP.isEmpty()) {
                throw new RuntimeException("la lista è vuota");
            } else  {
                return LP;
            }
        } catch (Exception e) {
            throw new RuntimeException("Errore nella richiesta dei prodotti");
        }
    }

    public List<Prodotto> findByCategoriaAndSotto(int id, int sottoId){
        try{
            List<Prodotto> LP =  prodottoRepo.findByCategoriaAndSotto(id, sottoId);
            if(LP.isEmpty()){
                throw new RuntimeException("lista vuota");
            } else  {
                return LP;
            }
        } catch (Exception e) {
            throw new RuntimeException("Errore nella richiesta del prodotto");
        }
    }
}
