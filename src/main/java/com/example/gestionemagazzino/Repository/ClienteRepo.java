package com.example.gestionemagazzino.Repository;


import com.example.gestionemagazzino.Entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepo extends JpaRepository<Cliente, Integer> {

}
