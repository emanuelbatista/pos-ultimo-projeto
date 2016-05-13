package br.edu.ifpb.pos.relatorio.entidades;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Rafael
 */
public class Peca implements Serializable {
    private Long codigo;
    private String nome;
    private String setor;
    private Double valor;
    private List<Long> veiculos;
    private List<Long> fornecedores;
    private Integer qtdeEmEstoque;
    
    
    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public List<Long> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(List<Long> veiculos) {
        this.veiculos = veiculos;
    }

    public List<Long> getFornecedores() {
        return fornecedores;
    }

    public void setFornecedores(List<Long> fornecedores) {
        this.fornecedores = fornecedores;
    }

    public Integer getQtdeEmEstoque() {
        return qtdeEmEstoque;
    }

    public void setQtdeEmEstoque(Integer qtdeEmEstoque) {
        this.qtdeEmEstoque = qtdeEmEstoque;
    }
    
}