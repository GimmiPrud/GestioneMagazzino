package com.example.gestionemagazzino.Dao;


import com.example.gestionemagazzino.Entity.Cliente;
import com.example.gestionemagazzino.Repository.ClienteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClienteDao {

    @Autowired
    private ClienteRepo clienteRepo;

    public Cliente insertCliente(Cliente cliente){
        try {
            return clienteRepo.save(cliente);
        } catch (Exception e) {
            throw new RuntimeException("Errore nell'inserimento del cliente",e);
        }
    }

    public Cliente findClienteById(int id){
        if(clienteRepo.findById(id).isPresent()){
            return clienteRepo.findById(id).get();
        } else{
            throw new RuntimeException("Cliente non trovato");
        }
    }

    public List<Cliente> findAllClienti(){
        return clienteRepo.findAll();
    }

    public Cliente updateCliente(Cliente cliente){
        try {
            if(clienteRepo.existsById(cliente.getId())){
                return clienteRepo.save(cliente);
            } else {
                throw new RuntimeException("Cliente non trovato");
            }
        } catch (Exception e) {
            throw new RuntimeException("Errore nella modifica del cliente",e);
        }
    }

    public Cliente deleteCliente(int id){
        try {
            if (clienteRepo.findById(id).isPresent()) {
                Cliente c =  clienteRepo.findById(id).get();
                clienteRepo.delete(c);
                return c;
            } else  {
                throw new RuntimeException("Cliente non trovato");
            }
        } catch (Exception e) {
            throw new RuntimeException("Errore nell'eliminazione del cliente",e);
        }
    }
}
