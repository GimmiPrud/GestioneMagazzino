package com.example.gestionemagazzino.Repository;


import com.example.gestionemagazzino.Entity.Ordine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdineRepo extends JpaRepository<Ordine, Integer> {

    //--------------------------\\
    @Modifying
    @Query(value = "UPDATE ORDINE " +
            "SET SOSPESO = NOT SOSPESO " +
            "WHERE ID = ?", nativeQuery = true)
    void updateSospeso(int id);

    //---------------------------\\

    @Query(value = "SELECT * " +
            "FROM ORDINE " +
            "WHERE CLIENTE_ID = ?", nativeQuery = true)
     List<Ordine> findOrdineByClientId(int id);
}
