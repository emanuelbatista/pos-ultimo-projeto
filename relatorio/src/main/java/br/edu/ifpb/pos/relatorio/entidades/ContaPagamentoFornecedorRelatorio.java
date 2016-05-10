/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pos.relatorio.entidades;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Emanuel Batista da Silva Filho - https://github.com/emanuelbatista
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ContaPagamentoFornecedorRelatorio implements Serializable {

    private Fornecedor fornecedor;
    private List<ContaPagamento> contas;

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public List<ContaPagamento> getContas() {
        return contas;
    }

    public void setContas(List<ContaPagamento> contas) {
        this.contas = contas;
    }

    @JsonProperty("total")
    public Double getTotal() {
        Double total = 0D;
        if (contas !=null && !contas.isEmpty()) {
            for (ContaPagamento conta : getContas()) {
                total += conta.getValor();
            }
        }
        return total;
    }
}
