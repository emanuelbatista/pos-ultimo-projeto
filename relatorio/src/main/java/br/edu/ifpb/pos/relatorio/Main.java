/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pos.relatorio;

import br.edu.ifpb.pos.relatorio.resources.ContaPagamentoFornecedorRelatorioResources;
import br.edu.ifpb.pos.relatorio.resources.ContaRecebimentoDataRelatorioResources;
import br.edu.ifpb.pos.relatorio.resources.OrdemServicoClienteRelatorioResources;
import br.edu.ifpb.pos.relatorio.resources.StatusOrdemServicoClienteRelatorioResources;
import br.edu.ifpb.pos.relatorio.resources.VeiculoOrdemServicoResource;
import org.restlet.Application;
import org.restlet.Component;
import org.restlet.data.Protocol;
import org.restlet.routing.Router;

/**
 *
 * @author Emanuel Batista da Silva Filho - https://github.com/emanuelbatista
 */
public class Main {

    public static void main(String[] args) throws Exception {

        Component component = new Component();
        String port = System.getProperty("server.port");
        component.getServers().add(Protocol.HTTP
                , Integer.parseInt(port == null ? "8080" : port));
        //
        Router router = new Router();
        //
        router.attach("/relatorio/fornecedor/{idFornecedor}/contas-pagamento", ContaPagamentoFornecedorRelatorioResources.class);
        router.attach("/relatorio/contas-recebimento/{data}", ContaRecebimentoDataRelatorioResources.class);
        router.attach("/relatorio/cliente/{idCliente}/os", OrdemServicoClienteRelatorioResources.class);
        router.attach("/relatorio/cliente/{idCliente}/os/status", StatusOrdemServicoClienteRelatorioResources.class);
        router.attach("/relatorio/veiculo/{idVeiculo}/os", VeiculoOrdemServicoResource.class);
        //
        Application application = new Application();
        application.setInboundRoot(router);
        //
        component.getDefaultHost().attach(application);
        component.getClients().add(Protocol.HTTPS);
        component.start();
    }
}
