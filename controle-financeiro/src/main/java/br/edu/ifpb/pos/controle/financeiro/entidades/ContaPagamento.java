/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pos.controle.financeiro.entidades;

import br.edu.ifpb.pos.controle.financeiro.validacao.grupos.Insercao;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Emanuel Batista da Silva Filho - https://github.com/emanuelbatista
 */
@Entity
@NamedQueries({@NamedQuery(name = "contapagamento.list",query = "SELECT cp FROM ContaPagamento cp")
              , @NamedQuery(name= "contapagamento.status", query = "SELECT new br.edu.ifpb.pos.controle.financeiro.entidades.ContaStatus(cp.codigo,cp.statusConta) FROM ContaPagamento cp WHERE cp.codigo=:codigo")})
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ContaPagamento extends Conta{
    
    @Embedded
    @Valid
    @NotNull(groups = Insercao.class)
    private Fornecimento fornecimento;

    public Fornecimento getFornecimento() {
        return fornecimento;
    }

    public void setFornecimento(Fornecimento fornecimento) {
        this.fornecimento = fornecimento;
    }
    
    
    
}
