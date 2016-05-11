/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pos.relatorio.service;

import br.edu.ifpb.pos.relatorio.entidades.Cliente;
import br.edu.ifpb.pos.relatorio.entidades.ContaPagamento;
import br.edu.ifpb.pos.relatorio.entidades.ContaRecebimento;
import br.edu.ifpb.pos.relatorio.entidades.Fornecedor;
import br.edu.ifpb.pos.relatorio.entidades.OrdemServico;
import br.edu.ifpb.pos.relatorio.entidades.StatusOrdemServico;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import br.edu.ifpb.pos.relatorio.entidades.VeiculoOrdemServicoTO;
import br.edu.ifpb.pos.service.autos.status.utils.JsonUtils;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;

/**
 *
 * @author Emanuel Batista da Silva Filho - https://github.com/emanuelbatista
 */
public class RelatorioService {

    public Fornecedor getFornecedor(Long idFornecedor) throws MalformedURLException, RemoteException {
        URL url = new URL("https://pos-webservice.herokuapp.com/fornecedores?wsdl");
        QName qName = new QName("http://service.fornecedor.pos.ifpb.edu.br/", "FornecedorService");
        Service service = Service.create(url, qName);
        FornecedorService fornecedorService = service.getPort(FornecedorService.class);
        return fornecedorService.recuperar(idFornecedor);
    }

    public List<ContaPagamento> getContasPagamentoFornecedor(Long idFornecedor) {
        ClientResource clientResource
                = new ClientResource("https://controle-financeiro-automovel.herokuapp.com/fornecedor/1/contas-pagamento");
        ContaPagamento[] pagamentos = clientResource.get(ContaPagamento[].class);
        return Arrays.asList(pagamentos);
    }

    public List<ContaRecebimento> getContasRecebimentoData(Date data) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String dataTexto = dateFormat.format(data);
        ClientResource clientResource
                = new ClientResource("https://controle-financeiro-automovel.herokuapp.com/contas-recebimento/data/{data}");
        clientResource.getRequest().getAttributes().put("data", dataTexto);
        ContaRecebimento[] contaRecebimentos = clientResource.get(ContaRecebimento[].class);
        return Arrays.asList(contaRecebimentos);
    }

    public Cliente getCliente(Long idCliente) throws MalformedURLException {
        URL wsdl = new URL("https://oficina-clientes.herokuapp.com/clientes?wsdl");
        QName qname = new QName("http://services.web.core.basicos.oficina.pos.joaomarccos.github.io/", "ClienteService");
        Service ws = Service.create(wsdl, qname);
        ClientService clientService = ws.getPort(ClientService.class);
        return clientService.searchClienteById(idCliente);
    }

    public List<OrdemServico> getOrensServicosCliente(Long idCliente) throws IOException {
        ClientResource clientResource = new ClientResource("https://oficina-os-orca.herokuapp.com/cliente/{idCliente}/os");
        clientResource.getRequest().getAttributes().put("idCliente", idCliente);
        Representation representation = clientResource.get();
        OrdemServico[] oss = new ObjectMapper().readValue(representation.getText(), OrdemServico[].class);
        return Arrays.asList(oss);
    }

    public List<StatusOrdemServico> getStatusOrdensServicoCliente(Long idCliente) throws IOException {
        ClientResource clientResource = new ClientResource("https://oficina-os-orca.herokuapp.com/cliente/{idCliente}/os");
        clientResource.getRequest().getAttributes().put("idCliente", idCliente);
        Representation representation = clientResource.get();
        StatusOrdemServico[] oss = new ObjectMapper().readValue(representation.getText(), StatusOrdemServico[].class);
        return Arrays.asList(oss);
    }

    public VeiculoOrdemServicoTO getRelatorioVeiculoOrdemServico(long idVeiculo) {
        ClientResource clientResource = new ClientResource("https://oficina-os-orca.herokuapp.com/os");
//        OrdemServico[] result = clientResource.get(OrdemServico[].class);
        try {
            List<OrdemServico> result = JsonUtils.converterJsonEmListaOrdemServico(
                    clientResource.get().getText());
            VeiculoOrdemServicoTO to = new VeiculoOrdemServicoTO();
            to.setIdVeiculo(idVeiculo);
            for (OrdemServico os : result) {
                if (os.getIdVeiculo() == to.getIdVeiculo()) {
                    to.getOrdens().add(os);
                }
            }
            return to;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
