package com.example.gestionemagazzino.Dao;


import com.example.gestionemagazzino.Entity.UnitaMisura;
import com.example.gestionemagazzino.Repository.UnitaMisuraRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UnitaMisuraDao {

    @Autowired
    private UnitaMisuraRepo unitaMisuraRepo;

    public UnitaMisura insertUnitaMisura(UnitaMisura um){
        try {
             return unitaMisuraRepo.save(um);
        } catch (Exception e) {
            throw new RuntimeException("Errore nell'inserimento unità di misura",e);
        }
    }

    public UnitaMisura findUnitaMisuraById(int id){
        if(unitaMisuraRepo.findById(id).isPresent()){
            return unitaMisuraRepo.findById(id).get();
        } else{
            throw new RuntimeException("Unità di misura non trovata");
        }
    }

    public List<UnitaMisura> findAllUnitaMisura(){
        if(unitaMisuraRepo.findAll().isEmpty()){
            throw new RuntimeException("Non ci sono misure");
        } else {
            System.out.println("Lista delle unità di misura");
            return unitaMisuraRepo.findAll();
        }
    }

    public UnitaMisura updateUnitaMisura(UnitaMisura um){
        try {
            if(unitaMisuraRepo.existsById(um.getId())){
                return unitaMisuraRepo.save(um);
            } else {
                throw new RuntimeException("unità di misura non trovata");
            }
        } catch (Exception e) {
            throw new RuntimeException("Errore nella modifica",e);
        }
    }

    public UnitaMisura deleteUnitaMisura(int id){
        try {
            if (unitaMisuraRepo.findById(id).isPresent()) {
                UnitaMisura unitaMisura = unitaMisuraRepo.findById(id).get();
                unitaMisuraRepo.delete(unitaMisura);
                return unitaMisura;
            } else  {
                throw new RuntimeException("unità di misura non trovata");
            }
        } catch (Exception e) {
            throw new RuntimeException("Errore nell'eliminazione",e);
        }
    }
}
