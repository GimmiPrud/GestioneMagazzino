package com.example.gestionemagazzino.Service;

import com.example.gestionemagazzino.Dao.*;
import com.example.gestionemagazzino.Dto.*;
import com.example.gestionemagazzino.Entity.*;
import com.example.gestionemagazzino.Utility.Conversioni;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class BancoService implements BancoServiceInt{

    @Autowired
    private ClienteDao clienteDao;
    @Autowired
    private OrdineDao ordineDao;
    @Autowired
    private MovimentoDao movimentoDao;
    @Autowired
    private OrdineRefProdottoDao ordineRefProdotto;
    @Autowired
    private ProdottoDao prodottoDao;

    // CLIENTE
    @Override
    public ClienteDto insertCliente(ClienteDto clienteDto) {
        Cliente c = Conversioni.daClienteDTOACliente(clienteDto);
        Cliente insertC = clienteDao.insertCliente(c);
        return Conversioni.daClienteAClienteDTO(insertC);
    }

    @Override
    public ClienteDto cercaClienteById(int id) {
        Cliente c = clienteDao.findClienteById(id);
        return Conversioni.daClienteAClienteDTO(c);
    }

    @Override
    public List<ClienteDto> ListaClienti() {
        List<Cliente> LC = clienteDao.findAllClienti();
        List<ClienteDto> LD = new ArrayList<>();
        for (Cliente c : LC) {
            LD.add(Conversioni.daClienteAClienteDTO(c));
        }
        return LD;
    }

    @Override
    public ClienteDto updateCliente(int id, ClienteDto clienteDto) {
        Cliente c = clienteDao.findClienteById(id);
        if(c!=null){
            if(clienteDto.getNome()!=null){
                c.setNome(clienteDto.getNome());
            }
            if (clienteDto.getEmail()!= null) {
                c.setEmail(clienteDto.getEmail());
            }
            if (clienteDto.getIndirizzo() != null) {
                c.setIndirizzo(clienteDto.getIndirizzo());
            }
            Cliente CA = clienteDao.updateCliente(c);
            return Conversioni.daClienteAClienteDTO(CA);

        } else{
            throw new RuntimeException("Cliente non valido");
        }
    }

    @Override
    public ClienteDto deleteCliente(int id) {
        Cliente c = clienteDao.deleteCliente(id);
        return Conversioni.daClienteAClienteDTO(c);
    }

    // metodi ordini del cliente
    @Override
    public List<OrdineDto> OrdiniDelCliente(int Cliente_id) {
        List<Ordine> LO = ordineDao.findOrdineByClientId(Cliente_id);
        List<OrdineDto> LD = new ArrayList<>();
        for (Ordine o : LO) {
            LD.add(Conversioni.daOrdineAOrdineDTO(o));
        }
        return LD;
    }


    // MOVIMENTO
    @Override
    public MovimentoDto insertMovimento(MovimentoDto mov) {
        Ordine oR = ordineDao.findOrdineById(mov.getOrdine().getId());
        Movimento e = Conversioni.daMovimentoDTOAMovimento(mov);
        e.setOrdine(oR);
        return Conversioni.daMovimentoAMovimentoDTO(movimentoDao.insertMovimento(e));
    }

    @Override
    public MovimentoDto cercaMovimentoById(int id) {
        Movimento m = movimentoDao.findMovimentoById(id);
        return Conversioni.daMovimentoAMovimentoDTO(m);
    }

    @Override
    public List<MovimentoDto> ListaMovimenti() {
        List<Movimento> LM = movimentoDao.findAllMovimento();
        List<MovimentoDto> LD = new ArrayList<>();
        for (Movimento m : LM) {
            LD.add(Conversioni.daMovimentoAMovimentoDTO(m));
        }
        return LD;
    }

    @Override
    public MovimentoDto updateMovimento( int id, MovimentoDto movimentoDto) {
        Movimento m = movimentoDao.findMovimentoById(movimentoDto.getId());
        if(m!=null){
            if(movimentoDto.getTipo()!=null){
                m.setTipo(movimentoDto.getTipo());
            }
            if(movimentoDto.getDescrizione()!=null){
                m.setDescrizione(movimentoDto.getDescrizione());
            }
            if (movimentoDto.getDataOra() != null) {
                m.setDataOra(movimentoDto.getDataOra());
            }
            Movimento MO = movimentoDao.updateMovimento(m);
            return Conversioni.daMovimentoAMovimentoDTO(MO);
        } else{
            throw new RuntimeException("Movimento non valido");
        }
    }

    @Override
    public MovimentoDto deleteMovimento(int id) {
        Movimento m = movimentoDao.findMovimentoById(id);
        return Conversioni.daMovimentoAMovimentoDTO(m);
    }


    // ORDINE
    @Override
    public OrdineProdottoDto insertOrdine(OrdineProdottoDto dto) {
        Cliente cliente = clienteDao.findClienteById(dto.getOrdine().getCliente().getId());
        if(cliente==null){
            return null;
        }
        Ordine ordine = Conversioni.daOrdineDTOAOrdine(dto.getOrdine());
        ordine.setCliente(cliente);
        ordine.setSospeso(false);
        ordine.setDataOra(LocalDateTime.now());
        ordine = ordineDao.insertOrdine(ordine);
        List<Prodotto> prodotti = new ArrayList<>();
        for (ProdottoDto p : dto.getProdotti()) {
            Prodotto temp = prodottoDao.findProdottoById(p.getId());
            if (temp != null) {
                prodotti.add(temp);
            }
        }
        if (ordine != null && !prodotti.isEmpty()) {
            dto.setOrdine(Conversioni.daOrdineAOrdineDTO(ordine));
            dto.getProdotti().clear();
            for (Prodotto p : prodotti){
                ordineRefProdotto.insert(new OrdineRefProdotto(ordine, p));
                dto.getProdotti().add(Conversioni.daProdottoAProdottoDTO(p));
            }
            return dto;
        } else {
            return null;
        }
    }

    @Override
    public OrdineDto cercaOrdineById(int id) {
        Ordine o = ordineDao.findOrdineById(id);
        return Conversioni.daOrdineAOrdineDTO(o);
    }

    @Override
    public List<OrdineDto> ListaOrdini() {
        List<Ordine> LO = ordineDao.findAllOrdine();
        List<OrdineDto> LD = new ArrayList<>();
        for (Ordine o : LO) {
            LD.add(Conversioni.daOrdineAOrdineDTO(o));
        }
        return LD;
    }


    @Override
    public OrdineDto updateOrdine( int id, OrdineDto ordineDto) {
        Ordine o = ordineDao.findOrdineById(id);
        if(o!=null) {
            o.setQuantita(ordineDto.getQuantita());
            o.setPrezzoTotale(ordineDto.getPrezzoTotale());

            Ordine OO = ordineDao.updateOrdine(o);
            return Conversioni.daOrdineAOrdineDTO(OO);
        } else {
            throw new RuntimeException("Ordine non valido");
        }
    }

    @Override
    public OrdineDto deleteOrdine(int id) {
        Ordine o = ordineDao.deleteOrdine(id);
        return Conversioni.daOrdineAOrdineDTO(o);
    }

    @Override
    public OrdineDto updateSospesoOrdine(int id) {
        Ordine o = ordineDao.findOrdineById(id);
        if(o!=null){
            if(o.isSospeso()){
                Ordine e = ordineDao.updateSospeso(o.getId());
                return Conversioni.daOrdineAOrdineDTO(e);
            } else {
                o.setSospeso(true);
                return  Conversioni.daOrdineAOrdineDTO(o);
            }
        } else {
            throw new RuntimeException("Ordine non trovato");
        }
    }

}
