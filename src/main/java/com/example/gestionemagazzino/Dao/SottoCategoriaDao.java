package com.example.gestionemagazzino.Dao;


import com.example.gestionemagazzino.Entity.SottoCategoria;
import com.example.gestionemagazzino.Repository.SottoCategoriaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SottoCategoriaDao {

    @Autowired
    private SottoCategoriaRepo sottoCategoriaRepo;

    public SottoCategoria insertSottoCategoria(SottoCategoria st){
        try {
            return sottoCategoriaRepo.save(st);
        } catch (Exception e) {
            throw new RuntimeException("Errore nell'inserimento della sottocategoria",e);
        }
    }

    public SottoCategoria findSottoCategoriaById(int id){
        if(sottoCategoriaRepo.findById(id).isPresent()){
            return sottoCategoriaRepo.findById(id).get();
        } else{
            throw new RuntimeException("SottoCategoria non trovata");
        }
    }

    public List<SottoCategoria> findAllSottoCategoria(){
        if(sottoCategoriaRepo.findAll().isEmpty()){
            throw new RuntimeException("Non ci sono sottocategorie");
        } else {
            return sottoCategoriaRepo.findAll();
        }
    }

    public SottoCategoria updateSottoCategoria(SottoCategoria st){
        try {
            if(sottoCategoriaRepo.existsById(st.getId())){
                 return sottoCategoriaRepo.save(st);
            } else {
                throw new RuntimeException("SottoCategoria non trovata");
            }
        } catch (Exception e) {
            throw new RuntimeException("Errore nella modifica della Sottocategoria",e);
        }
    }

    public SottoCategoria deleteSottoCategoria(int id){
        try {
            if (sottoCategoriaRepo.findById(id).isPresent()) {
                SottoCategoria s =  sottoCategoriaRepo.findById(id).get();
                sottoCategoriaRepo.delete(s);
                return s;
            } else  {
                throw new RuntimeException("SottoCategoria non trovata");
            }
        } catch (Exception e) {
            throw new RuntimeException("Errore nell'eliminazione della sottocategoria",e);
        }
    }
}
