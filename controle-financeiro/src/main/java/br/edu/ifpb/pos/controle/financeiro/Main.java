/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pos.controle.financeiro;

import br.edu.ifpb.pos.controle.financeiro.resources.ContaPagamentoInserirResources;
import br.edu.ifpb.pos.controle.financeiro.resources.ContaPagamentoResources;
import br.edu.ifpb.pos.controle.financeiro.resources.ContaPagamentoStatusResources;
import br.edu.ifpb.pos.controle.financeiro.resources.ContaRecebimentoInserirResources;
import br.edu.ifpb.pos.controle.financeiro.resources.ContaRecebimentoResources;
import br.edu.ifpb.pos.controle.financeiro.resources.ContaRecebimentoStatusResources;
import br.edu.ifpb.pos.controle.financeiro.resources.ContasPagamentoResources;
import br.edu.ifpb.pos.controle.financeiro.resources.ContasRecebimentoResources;
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
        component.getServers().add(Protocol.HTTP, 8080);
        //
        Router router = new Router();
        //
        //Rotas de Contas de Pagamento
        router.attach("/contas-pagamento", ContasPagamentoResources.class);
        router.attach("/conta-pagamento", ContaPagamentoInserirResources.class);
        router.attach("/conta-pagamento/{id}", ContaPagamentoResources.class);
        router.attach("/conta-pagamento/{id}/status", ContaPagamentoStatusResources.class);
        //
        //
        router.attach("/contas-recebimento", ContasRecebimentoResources.class);
        router.attach("/conta-recebimento", ContaRecebimentoInserirResources.class);
        router.attach("/conta-recebimento/{id}", ContaRecebimentoResources.class);
        router.attach("/conta-recebimento/{id}/status", ContaRecebimentoStatusResources.class);
        
        Application application = new Application();
        application.setInboundRoot(router);
        //
        component.getDefaultHost().attach(application);
        component.start();
    }
}
