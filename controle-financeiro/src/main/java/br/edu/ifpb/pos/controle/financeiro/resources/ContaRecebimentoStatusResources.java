/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pos.controle.financeiro.resources;

import br.edu.ifpb.pos.controle.financeiro.entidades.ContaRecebimento;
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
public class ContaRecebimentoStatusResources extends ServerResource {

    private final Repository<ContaRecebimento> repository;

    public ContaRecebimentoStatusResources() {
        this.repository = RepositoryFactory.getRepositoryContaRecebimento();
    }

    @Get("json")
    public ContaStatus buscarContaStatus() {
        Long codigo = Long.parseLong((String) getRequest().getAttributes().get("id"));
        Map<String, Object> map = new HashMap<>();
        map.put("codigo", codigo);
        return repository.consultaSimples("contarecebimento.status", map, ContaStatus.class);
    }
}
