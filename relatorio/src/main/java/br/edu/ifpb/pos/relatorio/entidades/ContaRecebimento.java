/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pos.relatorio.entidades;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author Emanuel Batista da Silva Filho - https://github.com/emanuelbatista
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ContaRecebimento extends Conta{
    
    @JsonProperty("id_cliente")
    private Long idCliente;
    @JsonProperty("numero_os")
    private Long numeroOs;
    private Cheque cheque;
    

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public Long getNumeroOs() {
        return numeroOs;
    }

    public void setNumeroOs(Long numeroOs) {
        this.numeroOs = numeroOs;
    }

    public Cheque getCheque() {
        return cheque;
    }

    public void setCheque(Cheque cheque) {
        this.cheque = cheque;
    }

    
    
    
    
    
    
}
