package br.edu.ifpb.pos.relatorio.resources;

import br.edu.ifpb.pos.relatorio.entidades.Peca;
import br.edu.ifpb.pos.relatorio.entidades.QtdPecas;
import br.edu.ifpb.pos.relatorio.service.RelatorioService;
import java.util.ArrayList;
import java.util.List;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

/**
 *
 * @author douglasgabriel
 * @version 0.1
 */
public class PecaPorNomeRelatorio extends ServerResource{

    private RelatorioService relatorioService = new RelatorioService();
    
    @Get("json")
    public QtdPecas getRelatorio (){
        String nome = getAttribute("nome");
        return relatorioService.getRelatorioPecaPorNome(nome);
    }
    
}
