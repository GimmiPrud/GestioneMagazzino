package com.example.gestionemagazzino.Controller;


import com.example.gestionemagazzino.Dto.CategoriaDto;
import com.example.gestionemagazzino.Dto.ProdottoDto;
import com.example.gestionemagazzino.Dto.SottoCategoriaDto;
import com.example.gestionemagazzino.Dto.UnitaMisuraDto;
import com.example.gestionemagazzino.Service.DepositoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping(path = "/deposito")
public class DepositoController {

    @Autowired
    private DepositoService depositoService;
    

    // PRODOTTI
    @PostMapping(path = "/prodotti", consumes = "application/json" )
    public ProdottoDto saveProdotto(@Valid @RequestBody ProdottoDto prodotto) {
        return depositoService.insertProdotto(prodotto);
    }

    @GetMapping(path = "/prodotti/lista", produces = "application/json")
    public List<ProdottoDto> listaProdotto() {
        return depositoService.listaProdotti();
    }

    @GetMapping(path = "prodotti/{idProd}", produces = "application/json")
    public ProdottoDto getProdotto(@PathVariable("idProd") int idProd) {
        return depositoService.cercaProdottoPerId(idProd);
    }

    @GetMapping(path = "/categoriaProdotti/{idCat}", produces = "application/json")
    public List<ProdottoDto> prodottiPerCategoria(@PathVariable("idCat") int idCat) {
        return depositoService.cercaProdottoPerCategoria(idCat);
    }

    @GetMapping(path = "/ProdCatESotto/{idCat}/{idSotto}", produces = "application/json")
    public List<ProdottoDto> ProdPerCatESotto(@PathVariable("idCat") int idCat, @PathVariable("idSotto") int idSotto) {
        return depositoService.findByCategoriaAndSotto(idCat, idSotto);
    }

    @DeleteMapping(path = "/cancellaProdotto/{idProd}", produces = "application/json")
    public ProdottoDto cancelaProdotto(@PathVariable("idProd") int idProd) {
        return depositoService.deleteProdotto(idProd);
    }

    @PutMapping(path = "/modificaProdotto/{idProd}", produces = "application/json")
    public ProdottoDto updateProdotto(@PathVariable("idProd") int idProd, @Valid @RequestBody ProdottoDto prodotto) {
        return depositoService.updateProdotto(idProd, prodotto);
    }

    @PutMapping(path = "/modDisponibilita/{idP}", produces = "application/json")
    public ProdottoDto updateDisponibilita(@PathVariable("idP") int idP) {
        return depositoService.updateDisponibilita(idP);
    }


    // CATEGORIE
    @PostMapping(path = "/categoria", consumes = "application/json" )
    public CategoriaDto saveCategoria(@Valid @RequestBody CategoriaDto cat) {
        return depositoService.insertCategoria(cat);
    }

    @GetMapping(path = "/categorie/lista", produces = "application/json")
    public List<CategoriaDto> listaCategorie() {
        return depositoService.listaCategorie();
    }

    @GetMapping(path = "categorie/{idCat}", produces = "application/json")
    public CategoriaDto getCategoria(@PathVariable("idCat") int idCat) {
        return depositoService.cercaCategoriaPerId(idCat);
    }

    @DeleteMapping(path = "/cancellaCategoria/{idCat}", produces = "application/json")
    public CategoriaDto cancelaCategoria(@PathVariable("idCat") int idCat) {
        return depositoService.deleteCategoria(idCat);
    }

    @PutMapping(path = "/modificaCategoria/{idCat}", produces = "application/json")
    public CategoriaDto updateCategoria(@PathVariable("idCat") int idCat, @Valid @RequestBody CategoriaDto cat) {
        return depositoService.updateCategoria(idCat, cat);
    }


    // SOTTOCATEGORIE
    @PostMapping(path = "/sottoCategorie", consumes = "application/json" )
    public SottoCategoriaDto saveSottoCategoria(@Valid @RequestBody SottoCategoriaDto sCat) {
        return depositoService.insertSottoCategoria(sCat);
    }

    @GetMapping(path = "/sottoCategorie/lista", produces = "application/json")
    public List<SottoCategoriaDto> listaSottoCategorie() {
        return depositoService.listaSottoCategorie();
    }

    @GetMapping(path = "sottoCategorie/{idSCat}", produces = "application/json")
    public SottoCategoriaDto getSottoCategoria(@PathVariable("idSCat") int idSCat) {
        return depositoService.cercaSottoCategoriaPerId(idSCat);
    }

    @DeleteMapping(path = "/cancellaSottoCategoria/{idSCat}", produces = "application/json")
    public SottoCategoriaDto cancellaSottoCategoria(@PathVariable("idSCat") int idSCat) {
        return depositoService.deleteSottoCategoria(idSCat);
    }

    @PutMapping(path = "/modificaSottoCategoria/{idSo}", produces = "application/json")
    public SottoCategoriaDto updateSottoCategoria(@PathVariable("idSo") int idSo, @Valid @RequestBody SottoCategoriaDto S ){
        return depositoService.updateSottoCategoria(idSo, S);
    }

    // UNITAMISURA
    @PostMapping(path = "/misura", consumes = "application/json" )
    public UnitaMisuraDto saveUnitaMisura(@Valid @RequestBody UnitaMisuraDto um) {
        return depositoService.insertMisura(um);
    }

    @GetMapping(path = "/misure/lista", produces = "application/json")
    public List<UnitaMisuraDto> listaMisure() {
        return depositoService.listaMisure();
    }

    @GetMapping(path = "misure/{idMis}", produces = "application/json")
    public UnitaMisuraDto getMisuraById(@PathVariable("idMis") int idMis) {
        return depositoService.cercaMisuraPerId(idMis);
    }

    @DeleteMapping(path = "/cancellaMisura/{idMis}", produces = "application/json")
    public UnitaMisuraDto cancellaMisura(@PathVariable("idMis") int idMis) {
        return depositoService.deleteMisura(idMis);
    }

    @PutMapping(value = "/modificaMisura/{idU}", produces = "application/json")
    public UnitaMisuraDto updateMisura(@PathVariable("idU") int idU, @Valid @RequestBody UnitaMisuraDto U) {
        return depositoService.updateMisura(idU, U);
    }
}
