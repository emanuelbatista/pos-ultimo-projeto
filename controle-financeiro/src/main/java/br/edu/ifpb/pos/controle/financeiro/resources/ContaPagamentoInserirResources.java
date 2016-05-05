/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pos.controle.financeiro.resources;

import br.edu.ifpb.pos.controle.financeiro.entidades.ContaPagamento;
import br.edu.ifpb.pos.controle.financeiro.repositorys.Repository;
import br.edu.ifpb.pos.controle.financeiro.repositorys.RepositoryFactory;
import br.edu.ifpb.pos.controle.financeiro.validacao.ValidadorPOJO;
import br.edu.ifpb.pos.controle.financeiro.validacao.grupos.Insercao;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.validation.ValidationException;
import org.restlet.data.Status;
import org.restlet.resource.Post;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;

/**
 *
 * @author Emanuel Batista da Silva Filho - https://github.com/emanuelbatista
 */
public class ContaPagamentoInserirResources extends ServerResource {

    private final Repository<ContaPagamento> repository;

    public ContaPagamentoInserirResources() {
        this.repository = RepositoryFactory.getRepositoryContaPagamento();
    }

    @Post
    public void inserir(ContaPagamento contaPagamento) {
        try {
            contaPagamento.setCodigo(null);
            ValidadorPOJO.validar(contaPagamento,Insercao.class);
            repository.salvar(contaPagamento);
        } catch (ValidationException ex) {
            throw new ResourceException(Status.CLIENT_ERROR_UNPROCESSABLE_ENTITY, ex.getMessage());
        } catch (Exception ex) {
            Logger.getLogger(ContasPagamentoResources.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
