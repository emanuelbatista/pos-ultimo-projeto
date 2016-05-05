/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pos.fornecedor.repository;

import br.edu.ifpb.pos.fornecedor.entidade.Fornecedor;

/**
 *
 * @author Emanuel Batista da Silva Filho - https://github.com/emanuelbatista
 */
public class RepositoryFactory {

    public static Repository<Fornecedor> createRepositoryFornecedor() {
        String port = System.getProperty("server.port");
        if (port == null) {
            return new Repository<>("br.edu.ifpb.pos.fornecedor");

        }
        return new Repository<>("br.edu.ifpb.pos.fornecedor.remoto");
    }

}
