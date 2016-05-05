/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pos.controle.financeiro.resources;

import br.edu.ifpb.pos.controle.financeiro.entidades.ContaPagamento;
import br.edu.ifpb.pos.controle.financeiro.entidades.ContaStatus;
import br.edu.ifpb.pos.controle.financeiro.repositorys.Repository;
import br.edu.ifpb.pos.controle.financeiro.repositorys.RepositoryFactory;
import java.util.HashMap;
import java.util.Map;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

/**
 *
 * @author Emanuel Batista da Silva Filho - https://github.com/emanuelbatista
 */
public class ContaPagamentoStatusResources extends ServerResource{
    
      private final Repository<ContaPagamento> repository;

    public ContaPagamentoStatusResources() {
        this.repository=RepositoryFactory.getRepositoryContaPagamento();
    }
    
    @Get
    public ContaStatus buscarContaStatus(){
        Long codigo=Long.parseLong((String)getRequest().getAttributes().get("id"));
        Map<String,Object> map=new HashMap<>();
        map.put("codigo", codigo);
        return  repository.consultaSimples("conta.status", map,ContaStatus.class);
    }
}
