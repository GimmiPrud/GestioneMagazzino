package com.example.gestionemagazzino.Repository;


import com.example.gestionemagazzino.Entity.Movimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimentoRepo extends JpaRepository<Movimento, Integer> {

}
