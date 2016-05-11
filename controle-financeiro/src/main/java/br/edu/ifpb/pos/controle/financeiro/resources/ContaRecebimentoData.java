/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pos.controle.financeiro.resources;

import br.edu.ifpb.pos.controle.financeiro.entidades.ContaRecebimento;
import br.edu.ifpb.pos.controle.financeiro.repositorys.Repository;
import br.edu.ifpb.pos.controle.financeiro.repositorys.RepositoryFactory;
import br.edu.ifpb.pos.controle.financeiro.util.DataUtil;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.restlet.data.Status;
import org.restlet.resource.Get;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;

/**
 *
 * @author Emanuel Batista da Silva Filho - https://github.com/emanuelbatista
 */
public class ContaRecebimentoData extends ServerResource{
    
    private final Repository<ContaRecebimento> repository;

    public ContaRecebimentoData() {
        this.repository = RepositoryFactory.getRepositoryContaRecebimento();
    }
    
    @Get("json")
    public List<ContaRecebimento> getContaRecebimentoData(){
        try {
            String dataTexto=(String)getRequest().getAttributes().get("data");
            Date data=DataUtil.convertData(dataTexto);
            Map<String,Object> param=new HashMap<>();
            param.put("data", data);
            return repository.consultaLista("contarecebimento.data", param);
        } catch (ParseException ex) {
            throw new ResourceException(Status.CLIENT_ERROR_PRECONDITION_FAILED, "data formato incorreto");
        }
        
    }
}
