/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pos.relatorio.resources;

import br.edu.ifpb.pos.relatorio.entidades.ContaPagamento;
import br.edu.ifpb.pos.relatorio.entidades.ContaPagamentoFornecedorRelatorio;
import br.edu.ifpb.pos.relatorio.entidades.Fornecedor;
import br.edu.ifpb.pos.relatorio.service.RelatorioService;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.List;
import org.restlet.data.Status;
import org.restlet.resource.Get;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;

/**
 *
 * @author Emanuel Batista da Silva Filho - https://github.com/emanuelbatista
 */
public class ContaPagamentoFornecedorRelatorioResources extends ServerResource {

    private final RelatorioService relatorioService;

    public ContaPagamentoFornecedorRelatorioResources() {
        this.relatorioService = new RelatorioService();
    }

    @Get("json")
    public ContaPagamentoFornecedorRelatorio getContaPagamentoFornecedorRelatorio() {
        Long idFornecedor = Long.parseLong((String) getRequest().getAttributes().get("idFornecedor"));
        ContaPagamentoFornecedorRelatorio contaRelatorio = new ContaPagamentoFornecedorRelatorio();
        try {
            Fornecedor fornecedor = relatorioService.getFornecedor(idFornecedor);
            contaRelatorio.setFornecedor(fornecedor);
            List<ContaPagamento> contaPagamentos=relatorioService.getContasPagamentoFornecedor(idFornecedor);
            contaRelatorio.setContas(contaPagamentos);
            return contaRelatorio;
        } catch (MalformedURLException | RemoteException ex) {
            throw new ResourceException(Status.SERVER_ERROR_INTERNAL);
        }
    }

}
