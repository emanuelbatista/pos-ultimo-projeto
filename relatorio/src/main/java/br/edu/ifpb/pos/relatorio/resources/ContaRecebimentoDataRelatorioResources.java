/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pos.relatorio.resources;

import br.edu.ifpb.pos.relatorio.entidades.ContaRecebimentoDataRelatorio;
import br.edu.ifpb.pos.relatorio.service.RelatorioService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.restlet.data.Status;
import org.restlet.resource.Get;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;

/**
 *
 * @author Emanuel Batista da Silva Filho - https://github.com/emanuelbatista
 */
public class ContaRecebimentoDataRelatorioResources extends ServerResource{
     
    private RelatorioService relatorioService;

    public ContaRecebimentoDataRelatorioResources() {
        relatorioService=new RelatorioService();
    }
 
    @Get("json")
    public ContaRecebimentoDataRelatorio getContaRecebimentoDataRelatorio(){
        try {
            String dateTexto=(String)getRequest().getAttributes().get("data");
            SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy");
            Date data=dateFormat.parse(dateTexto);
            ContaRecebimentoDataRelatorio relatorio=new ContaRecebimentoDataRelatorio();
            relatorio.setData(data);
            relatorio.setContas(relatorioService.getContasRecebimentoData(data));
            return relatorio;
        } catch (ParseException ex) {
            throw new ResourceException(Status.CLIENT_ERROR_UNPROCESSABLE_ENTITY,ex);
        }
    }
    
}
