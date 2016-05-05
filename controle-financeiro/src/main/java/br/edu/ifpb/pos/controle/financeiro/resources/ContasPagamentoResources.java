/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pos.controle.financeiro.resources;

import br.edu.ifpb.pos.controle.financeiro.entidades.ContaPagamento;
import br.edu.ifpb.pos.controle.financeiro.repositorys.Repository;
import br.edu.ifpb.pos.controle.financeiro.repositorys.RepositoryFactory;
import java.util.List;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

/**
 *
 * @author Emanuel Batista da Silva Filho - https://github.com/emanuelbatista
 */
public class ContasPagamentoResources extends ServerResource {

    private final Repository<ContaPagamento> repository;

    public ContasPagamentoResources() {
        this.repository = RepositoryFactory.getRepositoryContaPagamento();
    }

    @Get
    public List<ContaPagamento> list(){
        return repository.consultaLista("list", null);
    }

   
}
