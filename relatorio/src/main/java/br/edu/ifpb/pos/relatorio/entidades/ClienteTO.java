package io.github.joaomarccos.testedouglasservice;

import java.io.Serializable;

/**
 *
 * @author João Marcos <joaomarccos.github.io>
 */
public class ClienteTO implements Serializable {

    private long id;
    private String nome;
    private String documento;
    private String email;
    private String tel;

    public ClienteTO(long id, String nome, String documento, String email, String tel) {
        this.id = id;
        this.nome = nome;
        this.documento = documento;
        this.email = email;
        this.tel = tel;
    }

    public ClienteTO(String nome, String documento, String email, String tel) {
        this.nome = nome;
        this.documento = documento;
        this.email = email;
        this.tel = tel;
    }

    public ClienteTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + (int) (this.id ^ (this.id >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ClienteTO other = (ClienteTO) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return "ClienteTO{" + "id=" + id + ", nome=" + nome + ", documento=" + documento + ", email=" + email + ", tel=" + tel + '}';
    }

}
