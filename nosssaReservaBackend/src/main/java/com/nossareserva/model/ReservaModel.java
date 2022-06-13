package com.nossareserva.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;

@Entity
@Table(name = "RESERVA")
public class ReservaModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idReserva;
    private int carvao;
    private int gelo;
    private String data ;
    private String horas;
    private String morador;

    public long getIdReserva() {
        return this.idReserva;
    }

    public void setIdReserva(long idReserva) {
        this.idReserva = idReserva;
    }

    public int getCarvao() {
        return carvao;
    }

    public void setCarvao(int carvao) {
        this.carvao = carvao;
    }

    public int getGelo() {
        return gelo;
    }

    public void setGelo(int gelo) {
        this.gelo = gelo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHoras() {
        return horas;
    }

    public void setHoras(String horas) {
        this.horas = horas;
    }

    public String getMorador() {
        return morador;
    }

    public void setMorador(String morador) {
        this.morador = morador;
    }
}
