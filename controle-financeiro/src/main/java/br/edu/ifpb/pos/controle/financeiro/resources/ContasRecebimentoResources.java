/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pos.controle.financeiro.resources;

import br.edu.ifpb.pos.controle.financeiro.entidades.ContaRecebimento;
import br.edu.ifpb.pos.controle.financeiro.repositorys.Repository;
import br.edu.ifpb.pos.controle.financeiro.repositorys.RepositoryFactory;
import java.util.List;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

/**
 *
 * @author Emanuel Batista da Silva Filho - https://github.com/emanuelbatista
 */
public class ContasRecebimentoResources extends ServerResource {

    private final Repository<ContaRecebimento> repository;

    public ContasRecebimentoResources() {
        this.repository = RepositoryFactory.getRepositoryContaRecebimento();
    }

    @Get("json")
    public List<ContaRecebimento> list() {
        return repository.consultaLista("contarecebimento.list", null);
    }

}
