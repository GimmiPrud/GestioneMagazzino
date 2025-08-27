package com.example.gestionemagazzino.Dao;


import com.example.gestionemagazzino.Entity.Categoria;
import com.example.gestionemagazzino.Repository.CategoriaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoriaDao {

    @Autowired
    private CategoriaRepo categoriaRepo;


    public Categoria insertCategoria(Categoria categoria){
        try {
             return categoriaRepo.save(categoria);
        } catch (Exception e) {
            throw new RuntimeException("Errore nell'inserimento della categoria",e);
        }
    }

    public Categoria findCategoriaById(int id){
        if(categoriaRepo.findById(id).isPresent()){
            return categoriaRepo.findById(id).get();
        } else{
            throw new RuntimeException("Categoria non trovata");
        }
    }

    public List<Categoria> findAllCategoria(){
        return  categoriaRepo.findAll();
    }

    public Categoria updateCategoria(Categoria categoria){
        try {
            if(categoriaRepo.existsById(categoria.getId())){
                 return categoriaRepo.save(categoria);
            } else {
                throw new RuntimeException("Categoria non trovata");
            }
        } catch (Exception e) {
            throw new RuntimeException("Errore nella modifica della categoria",e);
        }
    }

    public Categoria deleteCategoria(int id){
        try {
            if (categoriaRepo.findById(id).isPresent()) {
                Categoria c = categoriaRepo.findById(id).get();
                categoriaRepo.delete(c);
                return c;
            } else  {
                throw new RuntimeException("Categoria non trovata");
            }
        } catch (Exception e) {
            throw new RuntimeException("Errore nell'eliminazione della categoria",e);
        }

    }
}
