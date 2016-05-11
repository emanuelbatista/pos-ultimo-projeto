package br.edu.ifpb.pos.relatorio.resources;

import br.edu.ifpb.pos.relatorio.entidades.VeiculoOrdemServicoTO;
import br.edu.ifpb.pos.relatorio.service.RelatorioService;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

/**
 *
 * @author douglasgabriel
 * @version 0.1
 */
public class VeiculoOrdemServicoResource extends ServerResource{

    private RelatorioService relatorioService = new RelatorioService();
    
    @Get("json")
    public VeiculoOrdemServicoTO getRelatorioVeiculoOrdemServico(){
        long idVeiculo = Long.parseLong(getAttribute("idVeiculo"));
        return relatorioService.getRelatorioVeiculoOrdemServico(idVeiculo);
    }
    
}
