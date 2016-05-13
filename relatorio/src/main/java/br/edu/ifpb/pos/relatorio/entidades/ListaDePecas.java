package br.edu.ifpb.pos.relatorio.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rafael
 */
public class ListaDePecas implements Serializable{
    private List<Peca> lista;
    public ListaDePecas() {
        this.lista = new ArrayList<>();
    }

    public List<Peca> getLista() {
        return lista;
    }

    public void setLista(List<Peca> lista) {
        this.lista = lista;
    }
}