package com.example.gestionemagazzino.Dao;


import com.example.gestionemagazzino.Entity.Ordine;
import com.example.gestionemagazzino.Repository.OrdineRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrdineDao {

    @Autowired
    private OrdineRepo ordineRepo;

    public Ordine insertOrdine(Ordine o){
        try {
            return ordineRepo.save(o);
        } catch (Exception e) {
            throw new RuntimeException("Errore nell'inserimento dell' ordine",e);
        }
    }

    public Ordine findOrdineById(int id){
        if(ordineRepo.findById(id).isPresent()){
            return ordineRepo.findById(id).get();
        } else{
            throw new RuntimeException("Ordine non trovato");
        }
    }

    public List<Ordine> findAllOrdine(){
            if(ordineRepo.findAll().isEmpty()){
                throw new RuntimeException("Non ci sono Ordini");
            } else {
                return ordineRepo.findAll();
            }
    }

    public Ordine updateOrdine(Ordine o){
        try {
            if(ordineRepo.existsById(o.getId())){
                return ordineRepo.save(o);
            } else {
                throw new RuntimeException("Ordine non trovato");
            }
        } catch (Exception e) {
            throw new RuntimeException("Errore nella modifica dell' Ordine",e);
        }
    }

    public Ordine deleteOrdine(int id){
        try {
            if (ordineRepo.findById(id).isPresent()) {
                Ordine o = ordineRepo.findById(id).get();
                ordineRepo.delete(o);
                return o;
            } else  {
                throw new RuntimeException("Ordine non trovato");
            }
        } catch (Exception e) {
            throw new RuntimeException("Errore nell'eliminazione Ordine",e);
        }
    }

    public Ordine updateSospeso(int id){
        try{
            if(ordineRepo.findById(id).isPresent()){
                Ordine o = ordineRepo.findById(id).get();
                if(o.isSospeso()){
                    ordineRepo.updateSospeso(o.getId());
                    return ordineRepo.save(o);
                } else {
                    throw new RuntimeException("Ordine non disponibile ");
                }
            } else {
                throw new RuntimeException("Ordine non trovato");
            }
        } catch(Exception e){
            throw new RuntimeException("Errore nella modifica dell' Ordine",e);
        }
    }

    public List<Ordine> findOrdineByClientId(int id){
        try {
            List<Ordine> lO = ordineRepo.findOrdineByClientId(id);
            if(lO.isEmpty()){
                throw new RuntimeException("Non ci sono Ordini");
            } else  {
                return lO;
            }
        } catch (Exception e) {
            throw new RuntimeException("Errore nella richiesta",e);
        }
    }
}
