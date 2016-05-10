/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pos.controle.financeiro.repositorys;

import br.edu.ifpb.pos.controle.financeiro.entidades.ContaPagamento;
import br.edu.ifpb.pos.controle.financeiro.entidades.ContaRecebimento;



/**
 *
 * @author Emanuel Batista da Silva Filho - https://github.com/emanuelbatista
 */
public class RepositoryFactory {
    
    private static final Repository REPOSITORY=createRepository();
            
    public static Repository createRepository(){
         String port = System.getProperty("server.port");
        if (port == null) {
            return new Repository<>("br.edu.ifpb.pos");

        }
        return new Repository<>("br.edu.ifpb.pos.remoto");
    }        
    
    public static Repository<ContaPagamento> getRepositoryContaPagamento(){
        return REPOSITORY;
    }
    
    public static Repository<ContaRecebimento> getRepositoryContaRecebimento(){
        return REPOSITORY;
    }
    
}
