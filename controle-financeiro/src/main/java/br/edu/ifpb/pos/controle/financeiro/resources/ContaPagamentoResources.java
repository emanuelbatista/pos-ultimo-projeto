/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pos.controle.financeiro.resources;

import br.edu.ifpb.pos.controle.financeiro.entidades.ContaPagamento;
import br.edu.ifpb.pos.controle.financeiro.entidades.ContaPagamentoCompleto;
import br.edu.ifpb.pos.controle.financeiro.entidades.Fornecedor;
import br.edu.ifpb.pos.controle.financeiro.repositorys.Repository;
import br.edu.ifpb.pos.controle.financeiro.repositorys.RepositoryFactory;
import br.edu.ifpb.pos.controle.financeiro.service.FornecedorService;
import br.edu.ifpb.pos.controle.financeiro.util.ClassesModelUtil;
import br.edu.ifpb.pos.controle.financeiro.validacao.ValidadorPOJO;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.validation.ValidationException;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
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
    private FornecedorService fornecedorService;

    public ContaPagamentoResources() {
        this.repository = RepositoryFactory.getRepositoryContaPagamento();
        URL url=null;
        try {
            url = new URL("https://pos-webservice.herokuapp.com/fornecedores?wsdl");
        } catch (MalformedURLException ex) {
            Logger.getLogger(ContaPagamentoResources.class.getName()).log(Level.SEVERE, null, ex);
        }
        QName qName = new QName("http://service.fornecedor.pos.ifpb.edu.br/", "FornecedorService");
        Service service = Service.create(url, qName);
        fornecedorService = service.getPort(FornecedorService.class);
    }

    @Get("json")
    public ContaPagamentoCompleto recuperar() {
        try {
            Long id = Long.parseLong((String) getRequest().getAttributes().get("id"));
            ContaPagamento contaPagamento=repository.buscar(id, ContaPagamento.class);
            ContaPagamentoCompleto pagamentoCompleto=new ContaPagamentoCompleto();
            pagamentoCompleto.setCodigo(contaPagamento.getCodigo());
            pagamentoCompleto.setDataVencimento(contaPagamento.getDataVencimento());
            pagamentoCompleto.setDescricao(contaPagamento.getDescricao());
            pagamentoCompleto.setStatusConta(contaPagamento.getStatusConta());
            pagamentoCompleto.setTipoPagamento(contaPagamento.getTipoPagamento());
            pagamentoCompleto.setValor(contaPagamento.getValor());
            pagamentoCompleto.setFornecedor(fornecedorService.recuperar(contaPagamento.getIdFornecedor()));
            return pagamentoCompleto;
        } catch (RemoteException ex) {
            throw new ResourceException(Status.SERVER_ERROR_INTERNAL,ex);
        }
    }
    
    

    @Put
    public void atualizar(ContaPagamento contaPagamento) {
        try {
            Long codigo = Long.parseLong((String) getRequest().getAttributes().get("id"));
            ContaPagamento contaPagamentoModel = repository.buscar(codigo, ContaPagamento.class);
            if (contaPagamentoModel != null) {
                ValidadorPOJO.validar(contaPagamento);
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
