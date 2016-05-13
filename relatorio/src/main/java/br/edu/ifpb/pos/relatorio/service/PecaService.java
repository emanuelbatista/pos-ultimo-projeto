package br.edu.ifpb.pos.relatorio.service;

import br.edu.ifpb.pos.relatorio.entidades.ListaDePecas;
import br.edu.ifpb.pos.relatorio.entidades.Peca;
import java.rmi.RemoteException;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 *
 * @author douglasgabriel
 */
@WebService(targetNamespace = "http://services.basico.pecas.pos.ifpb.edu/")
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
public interface PecaService {

    @WebMethod
    public void addPeca(Peca p) throws RemoteException;

    @WebMethod
    public void editPeca(Peca p) throws RemoteException;

    @WebMethod
    public void removePeca(Long pecaId) throws RemoteException;

    @WebMethod
    public Peca getPeca(Long pecaId) throws RemoteException;

    @WebMethod
    public ListaDePecas listPecas() throws RemoteException;
}
