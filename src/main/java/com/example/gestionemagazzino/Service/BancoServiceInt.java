package com.example.gestionemagazzino.Service;


import com.example.gestionemagazzino.Dto.ClienteDto;
import com.example.gestionemagazzino.Dto.MovimentoDto;
import com.example.gestionemagazzino.Dto.OrdineDto;
import com.example.gestionemagazzino.Dto.OrdineProdottoDto;

import java.util.List;

public interface BancoServiceInt {

    // METODI PER CLIENTE
    public ClienteDto insertCliente(ClienteDto clienteDto);
    public ClienteDto cercaClienteById(int id);
    public List<ClienteDto> ListaClienti();
    public ClienteDto updateCliente(int id,ClienteDto clienteDto);
    public ClienteDto deleteCliente(int id);
    public List<OrdineDto> OrdiniDelCliente(int Cliente_id);

    // METODI PER MOVIMENTO
    public MovimentoDto insertMovimento(MovimentoDto movimentoDto);
    public MovimentoDto cercaMovimentoById(int id);
    public List<MovimentoDto> ListaMovimenti();
    public MovimentoDto updateMovimento(int id,MovimentoDto movimentoDto);
    public MovimentoDto deleteMovimento(int id);


    // METODI PER ORDINE
    public OrdineProdottoDto insertOrdine(OrdineProdottoDto dto);
    public OrdineDto cercaOrdineById(int id);
    public List<OrdineDto> ListaOrdini();
    public OrdineDto updateOrdine(int id, OrdineDto ordineDto);
    public OrdineDto deleteOrdine(int id);
    public  OrdineDto updateSospesoOrdine(int id);
}
