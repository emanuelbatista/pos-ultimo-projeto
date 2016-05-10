/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pos.controle.financeiro.entidades;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 *
 * @author Emanuel Batista da Silva Filho - https://github.com/emanuelbatista
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ContaPagamentoCompleto extends Conta{
     
    private Peca peca;
    private Fornecedor fornecedor;

    public Peca getPeca() {
        return peca;
    }

    public void setPeca(Peca peca) {
        this.peca = peca;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }
    
    
    
       
}

