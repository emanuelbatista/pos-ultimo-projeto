package br.edu.ifpb.pos.relatorio.resources;

import br.edu.ifpb.pos.relatorio.entidades.Orcamento;
import br.edu.ifpb.pos.relatorio.service.RelatorioService;
import java.util.List;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

/**
 *
 * @author douglasgabriel
 * @version 0.1
 */
public class OrcamentoPorVeiculoResource extends ServerResource {

    private RelatorioService relatorioService = new RelatorioService();

    @Get("json")
    public List<Orcamento> getResources() {
        long idVeiculo = Long.parseLong(getAttribute("idVeiculo"));
        return relatorioService.getRelatorioOrcamentoPorVeiculoo(idVeiculo);
    }

}
