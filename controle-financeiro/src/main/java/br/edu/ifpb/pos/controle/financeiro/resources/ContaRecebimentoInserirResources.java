/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pos.controle.financeiro.resources;

import br.edu.ifpb.pos.controle.financeiro.entidades.ContaRecebimento;
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
public class ContaRecebimentoInserirResources extends ServerResource{

    private final Repository<ContaRecebimento> repository;
    
    public ContaRecebimentoInserirResources() {
        this.repository=RepositoryFactory.getRepositoryContaRecebimento();
    }
    
    @Post
    public void inserir(ContaRecebimento contaRecebimento){
          try {
            contaRecebimento.setCodigo(null);
            ValidadorPOJO.validar(contaRecebimento,Insercao.class);
            repository.salvar(contaRecebimento);
        } catch (ValidationException ex) {
            throw new ResourceException(Status.CLIENT_ERROR_UNPROCESSABLE_ENTITY, ex.getMessage());
        } catch (Exception ex) {
            Logger.getLogger(ContasPagamentoResources.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
}
