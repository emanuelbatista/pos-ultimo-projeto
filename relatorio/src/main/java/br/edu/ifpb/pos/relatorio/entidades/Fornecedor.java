/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pos.relatorio.entidades;

import java.io.Serializable;

/**
 *
 * @author Emanuel Batista da Silva Filho - https://github.com/emanuelbatista
 */
public class Fornecedor implements Serializable {

    private String name;
    private String CNJP;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCNJP() {
        return CNJP;
    }

    public void setCNJP(String CNJP) {
        this.CNJP = CNJP;
    }
    
    
    
}
