/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pos.relatorio.entidades;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * @author Emanuel Batista da Silva Filho - https://github.com/emanuelbatista
 */
@JsonIgnoreProperties(ignoreUnknown = true,value = {"status","pecas"})
public class Servico {
    
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    
}
