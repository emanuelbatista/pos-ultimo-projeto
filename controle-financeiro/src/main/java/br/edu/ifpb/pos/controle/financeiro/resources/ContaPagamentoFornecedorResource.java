/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pos.controle.financeiro.resources;

import br.edu.ifpb.pos.controle.financeiro.entidades.ContaPagamento;
import br.edu.ifpb.pos.controle.financeiro.repositorys.Repository;
import br.edu.ifpb.pos.controle.financeiro.repositorys.RepositoryFactory;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

/**
 *
 * @author Emanuel Batista da Silva Filho - https://github.com/emanuelbatista
 */
public class ContaPagamentoFornecedorResource extends ServerResource {

    private final Repository<ContaPagamento> repository;

    
    public ContaPagamentoFornecedorResource() {
        this.repository = RepositoryFactory.getRepositoryContaPagamento();
    }

    @Get("json")
    public List<ContaPagamento> getContaPagamento() {
        Long idFornecedor= Long.parseLong((String)getRequest().getAttributes().get("idFornecedor"));
        Map<String,Object> param=new HashMap<>();
        param.put("idFornecedor", idFornecedor);
        return repository.consultaLista("contapagamento.fornecedor", param);
    }

}
