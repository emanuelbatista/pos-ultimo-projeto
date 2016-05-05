/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pos.controle.financeiro.entidades;

import br.edu.ifpb.pos.controle.financeiro.validacao.grupos.Insercao;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Emanuel Batista da Silva Filho - https://github.com/emanuelbatista
 */
@Entity
public class ContaRecebimento extends Conta{
    
    @JsonProperty(value = "id_cliente")
    @NotNull(groups = Insercao.class)
    private String idCliente;
    @JsonProperty(value = "numero_os")
    @NotNull(groups = Insercao.class)
    private Long numeroOs;
    @NotNull(groups = Insercao.class)
    private ChequeSimples cheque;

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public ChequeSimples getCheque() {
        return cheque;
    }

    public void setCheque(ChequeSimples cheque) {
        this.cheque = cheque;
    }

    public Long getNumeroOs() {
        return numeroOs;
    }

    public void setNumeroOs(Long numeroOs) {
        this.numeroOs = numeroOs;
    }
    
    
    
    
    
    
}
