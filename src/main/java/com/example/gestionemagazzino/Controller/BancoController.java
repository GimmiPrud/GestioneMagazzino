package com.example.gestionemagazzino.Controller;


import com.example.gestionemagazzino.Dto.ClienteDto;
import com.example.gestionemagazzino.Dto.MovimentoDto;
import com.example.gestionemagazzino.Dto.OrdineDto;
import com.example.gestionemagazzino.Dto.OrdineProdottoDto;
import com.example.gestionemagazzino.Service.BancoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping(path = "/banco")
public class BancoController {

    @Autowired private BancoService bancoService;

    // CLIENTI
    @PostMapping( path = "/clienti", consumes = "application/json")
    public ClienteDto saveCliente(@Valid @RequestBody ClienteDto cliente) {
        return bancoService.insertCliente(cliente);
    }

    @GetMapping(path = "/clienti/lista", produces = "application/json")
    public List<ClienteDto> listaClienti() {
        return bancoService.ListaClienti();
    }

    @GetMapping(path = "/cliente/{idCliente}", produces = "application/json")
    public ClienteDto findClienteById(@PathVariable("idCliente") Integer idCliente) {
        return bancoService.cercaClienteById(idCliente);
    }

    @GetMapping(path = "/ordiniCliente/{idC}", produces = "application/json")
    public List<OrdineDto> findOrdiniClienteById(@PathVariable("idC") Integer idC) {
        return bancoService.OrdiniDelCliente(idC);
    }

    @DeleteMapping(path = "/cancellaCliente/{id}", produces = "application/json")
    public ClienteDto cancellaCliente(@PathVariable Integer id){
        return bancoService.deleteCliente(id);
    }

    @PutMapping(path = "/modificaCliente/{idCli}", produces = "application/json")
    public ClienteDto modificaCliente(@PathVariable Integer idCli, @Valid @RequestBody ClienteDto cliente) {
        return bancoService.updateCliente( idCli, cliente);
    }



    // MOVIMENTI
    @PostMapping( path = "/movimenti", consumes = "application/json")
    public MovimentoDto saveMovimento(@Valid @RequestBody MovimentoDto mov) {
        return bancoService.insertMovimento(mov);
    }

    @GetMapping(path = "/movimenti/lista", produces = "application/json")
    public List<MovimentoDto> listaMovimenti() {
        return bancoService.ListaMovimenti();
    }

    @GetMapping(path = "/movimento/{id}", produces = "application/json")
    public MovimentoDto findMovimento(@PathVariable("id") Integer id) {
        return bancoService.cercaMovimentoById(id);
    }

    @DeleteMapping(path = "/cancellaMovimento/{id}", produces = "application/json")
    public MovimentoDto cancellaMovimento(@PathVariable("id") Integer id){
        return bancoService.deleteMovimento(id);
    }

    @PutMapping(path = "/modificaMovimento/{idM}", produces = "application/json")
    public MovimentoDto modificaMovimento(@PathVariable("idM") Integer idM, @Valid @RequestBody MovimentoDto mov) {
        return bancoService.updateMovimento(idM, mov);
    }


    // ORDINI
    @PostMapping( path = "/ordine", consumes = "application/json")
    public OrdineProdottoDto saveOrdine(@Valid @RequestBody OrdineProdottoDto ord) {
        return bancoService.insertOrdine(ord);
    }

    @GetMapping(path = "/ordini/lista", produces = "application/json")
    public List<OrdineDto> listaOrdini() {
        return bancoService.ListaOrdini();
    }

    @GetMapping(path = "/ordine/{id}", produces = "application/json")
    public OrdineDto findOrdine(@PathVariable("id") Integer id) {
        return bancoService.cercaOrdineById(id);
    }

    @DeleteMapping(path = "/cancellaOrdine/{id}", produces = "application/json")
    public OrdineDto cancellaOrdine(@PathVariable("id") Integer id){
        return bancoService.deleteOrdine(id);
    }

    @PutMapping(path = "/modificaOrdine/{idO}", produces = "application/json")
    public OrdineDto modificaOrdine(@PathVariable ("idO")  Integer idO, @Valid @RequestBody OrdineDto ord) {
        return bancoService.updateOrdine(idO, ord);
    }

    @PutMapping(path = "/ordineSospeso/{idOr}", produces = "application/json")
    public OrdineDto updateSospeso(@PathVariable("idOr") Integer idOr) {
        return bancoService.updateSospesoOrdine(idOr);
    }
}
