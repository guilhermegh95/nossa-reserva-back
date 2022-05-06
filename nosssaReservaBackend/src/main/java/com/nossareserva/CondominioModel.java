package com.nossareserva;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "CONDOMINIO")
public class CondominioModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idCondominio;
    private String nome;
    private String URL;


    public long getIdCondominio() {
        return idCondominio;
    }

    public void setIdCondominio(long idCondominio) {
        this.idCondominio = idCondominio;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }
}
