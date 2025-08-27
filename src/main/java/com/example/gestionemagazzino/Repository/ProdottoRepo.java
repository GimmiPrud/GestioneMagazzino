package com.example.gestionemagazzino.Repository;


import com.example.gestionemagazzino.Entity.Prodotto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdottoRepo extends JpaRepository<Prodotto, Integer> {

    // Query

    // Prodotti per categoria
    @Query(value ="SELECT p.* " +
            "FROM PRODOTTO p " +
            "JOIN SOTTOCATEGORIA s ON p.SOTTOCATEGORIA_ID = s.ID " +
            "WHERE s.CATEGORIA_ID = ?", nativeQuery = true)
    List<Prodotto> findByCategoria(int id);

    // prodotti per categoria e sottocategoria
    @Query(value ="SELECT p.* " +
            "FROM PRODOTTO p " +
            "JOIN SOTTOCATEGORIA s ON p.SOTTOCATEGORIA_ID = s.ID " +
            "WHERE s.CATEGORIA_ID = ? " +
            "AND  s.ID = ?", nativeQuery = true)
    List<Prodotto> findByCategoriaAndSotto(int id, int sottoId);


    // Prodotti update disponibilità
    @Modifying
    @Query(value = "UPDATE PRODOTTO " +
            "SET DISPONIBILITA = NOT DISPONIBILITA " +
            "WHERE ID = ?", nativeQuery = true)
    void updateDisponibilita(int id);




}
