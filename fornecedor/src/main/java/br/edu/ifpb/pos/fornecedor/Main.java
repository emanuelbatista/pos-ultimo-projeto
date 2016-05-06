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
        System.out.println("Iniciando Servidor");
        String port=System.getProperty("server.port");
        if(port!=null){
          System.out.println("Porta: "+port);
        }else{
            port="8080";
        }
        Endpoint.publish("http://0.0.0.0:"+port+"/fornecedor", new FornecedorServiceImpl());
    }
}
