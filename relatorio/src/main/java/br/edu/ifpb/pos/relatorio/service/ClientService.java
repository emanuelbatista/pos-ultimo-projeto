package br.edu.ifpb.pos.relatorio.service;

import br.edu.ifpb.pos.relatorio.entidades.Cliente;
import java.rmi.Remote;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 *
 * @author João Marcos <joaomarccos.github.io>
 */
@WebService(targetNamespace = "http://services.web.core.basicos.oficina.pos.joaomarccos.github.io/")
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
public interface ClientService extends Remote{

    @WebMethod
    public List<Cliente> getAllClients();

    @WebMethod
    public Cliente saveClient(Cliente client);

    @WebMethod
    public Cliente updateClient(Cliente client);

    @WebMethod
    public Cliente searchClienteById(long id);

    @WebMethod
    public void deleteCliente(Cliente client);
}
