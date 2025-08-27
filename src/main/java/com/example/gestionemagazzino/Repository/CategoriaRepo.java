package com.example.gestionemagazzino.Repository;

import com.example.gestionemagazzino.Entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepo extends JpaRepository<Categoria, Integer> {

}
