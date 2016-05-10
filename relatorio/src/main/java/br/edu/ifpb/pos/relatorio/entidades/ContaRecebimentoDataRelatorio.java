/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pos.relatorio.entidades;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Emanuel Batista da Silva Filho - https://github.com/emanuelbatista
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ContaRecebimentoDataRelatorio {

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy")
    private Date data;
    private List<ContaRecebimento> contas;

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public List<ContaRecebimento> getContas() {
        return contas;
    }

    public void setContas(List<ContaRecebimento> contas) {
        this.contas = contas;
    }

    @JsonProperty("total")
    public Double getTotal() {
        Double total = 0D;
        if (contas != null && !contas.isEmpty()) {
            for (ContaRecebimento conta : getContas()) {
            total += conta.getValor();
            }
        }
        return total;
    }

}
