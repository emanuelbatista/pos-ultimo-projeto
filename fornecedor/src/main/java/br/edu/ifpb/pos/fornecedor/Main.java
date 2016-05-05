/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pos.fornecedor;

import br.edu.ifpb.pos.fornecedor.service.FornecedorServiceImpl;
import javax.xml.ws.Endpoint;

/**
 *
 * @author Emanuel Batista da Silva Filho - https://github.com/emanuelbatista
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Endpoint.publish("http://localhost:8000/fornecedor", new FornecedorServiceImpl());
    }
}
