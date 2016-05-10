/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pos.relatorio.service;

import br.edu.ifpb.pos.relatorio.entidades.Fornecedor;
import java.rmi.Remote;
import java.rmi.RemoteException;
import javax.jws.WebService;

/**
 *
 * @author Emanuel Batista da Silva Filho - https://github.com/emanuelbatista
 */
@WebService(name = "FornecedorService",targetNamespace = "http://service.fornecedor.pos.ifpb.edu.br/")
public interface FornecedorService extends Remote{

    public void inserir(Fornecedor fornecedor) throws RemoteException;
    
    public void remover(Long id) throws RemoteException;
    
    public void atualizar(Fornecedor fornecedor) throws RemoteException;
    
    public Fornecedor recuperar(Long id) throws RemoteException;
    
    public Fornecedor[] listar() throws RemoteException;
   
    
}
