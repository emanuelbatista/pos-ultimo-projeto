/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pos.controle.financeiro.resources;

import br.edu.ifpb.pos.controle.financeiro.entidades.ContaRecebimento;
import br.edu.ifpb.pos.controle.financeiro.repositorys.Repository;
import br.edu.ifpb.pos.controle.financeiro.repositorys.RepositoryFactory;
import br.edu.ifpb.pos.controle.financeiro.util.ClassesModelUtil;
import br.edu.ifpb.pos.controle.financeiro.validacao.ValidadorPOJO;
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
public class ContaRecebimentoResources extends ServerResource{
     private final Repository<ContaRecebimento> repository;

    public ContaRecebimentoResources() {
        this.repository = RepositoryFactory.getRepositoryContaRecebimento();
    }

    @Get("json")
    public ContaRecebimento recuperar() {
        Long id = Long.parseLong((String) getRequest().getAttributes().get("id"));
        return repository.buscar(id, ContaRecebimento.class);
    }

    @Put
    public void atualizar(ContaRecebimento contaRecebimento) {
        try {
            Long codigo = Long.parseLong((String) getRequest().getAttributes().get("id"));
            ContaRecebimento contaRecebimentoModel = repository.buscar(codigo, ContaRecebimento.class);
            if (contaRecebimentoModel != null) {
                ValidadorPOJO.validar(contaRecebimento);
                ClassesModelUtil.preencherCamposNotNull(contaRecebimento, contaRecebimentoModel, ContaRecebimento.class);
                contaRecebimentoModel.setCodigo(codigo);
                repository.atualizar(contaRecebimento);
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
            ContaRecebimento contaRecebimento = repository.buscar(codigo, ContaRecebimento.class);
            if (contaRecebimento != null) {
                repository.excluir(contaRecebimento);
            }
        } catch (Exception ex) {
            Logger.getLogger(ContaPagamentoResources.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
