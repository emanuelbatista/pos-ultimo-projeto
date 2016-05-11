package br.edu.ifpb.pos.relatorio.entidades;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author douglasgabriel
 * @version 0.1
 */
public class VeiculoOrdemServicoTO {

    private long idVeiculo;
    private List<OrdemServico> ordens;

    public VeiculoOrdemServicoTO() {
        this.ordens=new ArrayList<>();
    }

    public long getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(long idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public List<OrdemServico> getOrdens() {
        return ordens;
    }

    public void setOrdens(List<OrdemServico> ordens) {
        this.ordens = ordens;
    }
    
}
