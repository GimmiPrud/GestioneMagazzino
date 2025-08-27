package com.example.gestionemagazzino.Repository;


import com.example.gestionemagazzino.Entity.UnitaMisura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnitaMisuraRepo extends JpaRepository<UnitaMisura, Integer> {

}
