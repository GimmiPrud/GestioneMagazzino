package com.example.gestionemagazzino.Dao;


import com.example.gestionemagazzino.Entity.OrdineRefProdotto;
import com.example.gestionemagazzino.Repository.OrdineRefProdottoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrdineRefProdottoDao {

    @Autowired
    private OrdineRefProdottoRepo ordineRefProdottoRepo;

    public OrdineRefProdotto insert(OrdineRefProdotto ordineRefProdotto){
        try{
            return ordineRefProdottoRepo.save(ordineRefProdotto);
        } catch(Exception e){
            throw new RuntimeException("Errore nella richiesta",e);
        }
    }
}
