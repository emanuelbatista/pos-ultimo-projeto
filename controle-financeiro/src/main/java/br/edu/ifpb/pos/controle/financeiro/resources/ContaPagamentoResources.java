/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pos.controle.financeiro.resources;

import br.edu.ifpb.pos.controle.financeiro.entidades.ContaPagamento;
import br.edu.ifpb.pos.controle.financeiro.repositorys.Repository;
import br.edu.ifpb.pos.controle.financeiro.repositorys.RepositoryFactory;
import br.edu.ifpb.pos.controle.financeiro.util.ClassesModelUtil;
import br.edu.ifpb.pos.controle.financeiro.validacao.ValidadorBeans;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.validation.ValidationException;
import org.restlet.data.Status;
import org.restlet.resource.Delete;
import org.restlet.resource.Get;
import org.restlet.resource.Put;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;

/**
 *
 * @author Emanuel Batista da Silva Filho - https://github.com/emanuelbatista
 */
public class ContaPagamentoResources extends ServerResource {

    private final Repository<ContaPagamento> repository;

    public ContaPagamentoResources() {
        this.repository = RepositoryFactory.getRepositoryContaPagamento();
    }

    @Get
    public ContaPagamento recuperar() {
        Long id = Long.parseLong((String) getRequest().getAttributes().get("id"));
        return repository.buscar(id, ContaPagamento.class);
    }

    @Put
    public void atualizar(ContaPagamento contaPagamento) {
        try {
            Long codigo = Long.parseLong((String) getRequest().getAttributes().get("id"));
            ContaPagamento contaPagamentoModel = repository.buscar(codigo, ContaPagamento.class);
            if (contaPagamentoModel != null) {
                ValidadorBeans.validar(contaPagamento);
                ClassesModelUtil.preencherCamposNotNull(contaPagamento, contaPagamentoModel, ContaPagamento.class);
                contaPagamentoModel.setCodigo(codigo);
                repository.atualizar(contaPagamentoModel);
            }
        } catch(ValidationException ex){
            throw new ResourceException(Status.CLIENT_ERROR_UNPROCESSABLE_ENTITY, ex.getMessage());
        } catch (Exception ex) {
            Logger.getLogger(ContaPagamentoResources.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Delete
    public void remover() {
        try {
            Long codigo = Long.parseLong((String) getRequest().getAttributes().get("id"));
            ContaPagamento contaPagamento = repository.buscar(codigo, ContaPagamento.class);
            if (contaPagamento != null) {
                repository.excluir(contaPagamento);
            }
        } catch (Exception ex) {
            Logger.getLogger(ContaPagamentoResources.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
