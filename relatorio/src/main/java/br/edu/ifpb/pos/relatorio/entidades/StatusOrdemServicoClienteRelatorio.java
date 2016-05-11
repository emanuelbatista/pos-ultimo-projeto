/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pos.relatorio.entidades;

import java.util.List;

/**
 *
 * @author Emanuel Batista da Silva Filho - https://github.com/emanuelbatista
 */
public class StatusOrdemServicoClienteRelatorio {
    
    private Cliente cliente;
    private List<StatusOrdemServico> statusOrdensServico;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<StatusOrdemServico> getStatusOrdensServico() {
        return statusOrdensServico;
    }

    public void setStatusOrdensServico(List<StatusOrdemServico> statusOrdensServico) {
        this.statusOrdensServico = statusOrdensServico;
    }
    
}
