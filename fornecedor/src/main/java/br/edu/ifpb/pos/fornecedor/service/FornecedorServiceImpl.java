/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pos.fornecedor.service;

import br.edu.ifpb.pos.fornecedor.entidade.Fornecedor;
import br.edu.ifpb.pos.fornecedor.repository.Repository;
import br.edu.ifpb.pos.fornecedor.repository.RepositoryFactory;
import java.rmi.RemoteException;
import java.util.List;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 *
 * @author Emanuel Batista da Silva Filho - https://github.com/emanuelbatista
 */
@WebService(name = "FornecedorService",serviceName = "FornecedorService",targetNamespace = "http://service.fornecedor.pos.ifpb.edu.br/")
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
public class FornecedorServiceImpl implements FornecedorService {

    private final Repository<Fornecedor> repository;

    public FornecedorServiceImpl() {
        this.repository = RepositoryFactory.createRepositoryFornecedor();
    }

    @Override
    public void inserir(Fornecedor fornecedor) throws RemoteException {
        try {
            repository.salvar(fornecedor);
        } catch (Exception ex) {
            throw new RemoteException(ex.getMessage());
        }
    }

    @Override
    public void remover(Long id) throws RemoteException {
        Fornecedor fornecedor = recuperar(id);
        if (fornecedor != null) {
            try {
                repository.excluir(fornecedor);
            } catch (Exception ex) {
                throw new RemoteException(ex.getMessage());
            }
        }else{
            throw new RemoteException("Fornecedor não existe, impossivel remover");
        }
    }

    @Override
    public void atualizar(Fornecedor fornecedor) throws RemoteException {
        try {
            repository.atualizar(fornecedor);
        } catch (Exception ex) {
            throw new RemoteException(ex.getMessage());
        }
    }

    @Override
    public Fornecedor recuperar(Long id) throws RemoteException {
        return repository.buscar(id, Fornecedor.class);
    }

    @Override
    public Fornecedor[] listar() throws RemoteException {
        List<Fornecedor> fornecedores=repository.consultaLista("list",null);
        return fornecedores.toArray(new Fornecedor[0]);
    }

}
