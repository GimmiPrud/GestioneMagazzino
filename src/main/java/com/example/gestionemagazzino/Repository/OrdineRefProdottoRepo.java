package com.example.gestionemagazzino.Repository;


import com.example.gestionemagazzino.Entity.OrdineRefProdotto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdineRefProdottoRepo extends JpaRepository<OrdineRefProdotto, Integer> {

}
