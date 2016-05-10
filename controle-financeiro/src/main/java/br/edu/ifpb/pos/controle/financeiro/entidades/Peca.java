/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pos.controle.financeiro.entidades;

import java.io.Serializable;

/**
 *
 * @author Emanuel Batista da Silva Filho - https://github.com/emanuelbatista
 */
public class Peca implements Serializable {

    private Long codigo;
    private String setor;
    private String nome;
    private Double valor;
    private Integer qtdeEmEstoque;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Integer getQtdeEmEstoque() {
        return qtdeEmEstoque;
    }

    public void setQtdeEmEstoque(Integer qtdeEmEstoque) {
        this.qtdeEmEstoque = qtdeEmEstoque;
    }

    
}
