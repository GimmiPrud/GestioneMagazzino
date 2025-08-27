package com.example.gestionemagazzino.Dao;


import com.example.gestionemagazzino.Entity.Movimento;
import com.example.gestionemagazzino.Repository.MovimentoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MovimentoDao {

    @Autowired
    private MovimentoRepo movimentoRepo;

    public Movimento insertMovimento(Movimento mov){
        try {
             return movimentoRepo.save(mov);
        } catch (Exception e) {
            throw new RuntimeException("Errore nell'inserimento del movimento",e);
        }
    }

    public Movimento findMovimentoById(int id){
        if(movimentoRepo.findById(id).isPresent()){
            return movimentoRepo.findById(id).get();
        } else{
            throw new RuntimeException("Movimento non trovato");
        }
    }

    public List<Movimento> findAllMovimento(){
        return movimentoRepo.findAll();
    }

    public Movimento updateMovimento(Movimento mov){
        try {
            if(movimentoRepo.existsById(mov.getId())){
                return movimentoRepo.save(mov);
            } else {
                throw new RuntimeException("Movimento non trovato");
            }
        } catch (Exception e) {
            throw new RuntimeException("Errore nella modifica del movimento",e);
        }
    }

    public Movimento deleteMovimento(int id){
        try {
            if (movimentoRepo.findById(id).isPresent()) {
                Movimento m = movimentoRepo.findById(id).get();
                movimentoRepo.delete(m);
                return m;
            } else  {
                throw new RuntimeException("Movimento non trovato");
            }
        } catch (Exception e) {
            throw new RuntimeException("Errore nell'eliminazione del movimento",e);
        }
    }
}
