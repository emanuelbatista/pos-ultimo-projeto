/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pos.controle.financeiro.entidades;

import br.edu.ifpb.pos.controle.financeiro.validacao.grupos.Insercao;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Emanuel Batista da Silva Filho - https://github.com/emanuelbatista
 */
@Entity
@NamedQueries({@NamedQuery(name = "contapagamento.list",query = "SELECT cp FROM ContaPagamento cp")
        , @NamedQuery(name= "contapagamento.status", query = "SELECT new br.edu.ifpb.pos.controle.financeiro.entidades.ContaStatus(cp.codigo,cp.statusConta) FROM ContaPagamento cp WHERE cp.codigo=:codigo")
        , @NamedQuery(name = "contapagamento.fornecedor",query = "SELECT cp FROM ContaPagamento cp WHERE cp.idFornecedor=:idFornecedor")
        , @NamedQuery(name = "contapagamento.data",query = "SELECT cp FROM ContaPagamento cp WHERE cp.dataVencimento=:data")
})
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ContaPagamento extends Conta{
    
    @Column(nullable = false)
    @NotNull(groups = Insercao.class)
    @JsonProperty(value = "id_fornecedor")
    private Long idFornecedor;
    
    @Column(nullable = false)
    @NotNull(groups = Insercao.class)
    @JsonProperty(value = "id_peca")
    private Long idPeca;

    public Long getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(Long idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public Long getIdPeca() {
        return idPeca;
    }

    public void setIdPeca(Long idPeca) {
        this.idPeca = idPeca;
    }
    
    
    
    
    
}
