/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pos.relatorio.resources;

import br.edu.ifpb.pos.relatorio.entidades.Cliente;
import br.edu.ifpb.pos.relatorio.entidades.StatusOrdemServico;
import br.edu.ifpb.pos.relatorio.entidades.StatusOrdemServicoClienteRelatorio;
import br.edu.ifpb.pos.relatorio.service.RelatorioService;
import java.io.IOException;
import java.util.List;
import org.restlet.data.Status;
import org.restlet.resource.Get;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;

/**
 *
 * @author Emanuel Batista da Silva Filho - https://github.com/emanuelbatista
 */
public class StatusOrdemServicoClienteRelatorioResources extends ServerResource{
    
    private final RelatorioService relatorioService;

    public StatusOrdemServicoClienteRelatorioResources() {
        this.relatorioService=new RelatorioService();
    }
    
    
    
    @Get("json")
    public StatusOrdemServicoClienteRelatorio getStatusOrdemServicoClienteRelatorio(){
        try {
            Long idCliente=Long.parseLong((String)getRequest().getAttributes().get("idCliente"));
            StatusOrdemServicoClienteRelatorio relatorio=new StatusOrdemServicoClienteRelatorio();
            Cliente cliente=relatorioService.getCliente(idCliente);
            if(cliente==null){
                return null;
            }
            List<StatusOrdemServico> statusOrdemServicos = relatorioService.getStatusOrdensServicoCliente(idCliente);
            relatorio.setCliente(cliente);
            relatorio.setStatusOrdensServico(statusOrdemServicos);
            return relatorio;
        } catch (IOException ex) {
            throw new ResourceException(Status.SERVER_ERROR_INTERNAL,ex);
        }
    }
    
    
}
