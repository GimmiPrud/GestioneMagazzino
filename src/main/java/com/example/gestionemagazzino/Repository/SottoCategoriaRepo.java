package com.example.gestionemagazzino.Repository;


import com.example.gestionemagazzino.Entity.SottoCategoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SottoCategoriaRepo extends JpaRepository<SottoCategoria, Integer> {

}
