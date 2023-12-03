package com.example;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.sql.Date;

@Entity
@Table(name = "conta")
public class Conta {

    @Id
    private String contaid;

    private String clienteid;
    private String agenciaid;
    private Float saldo;

    private Date abertura;
    private int tipo;
    private Boolean ativa;

    public String getContaid() {
        return contaid;
    }

    public void setContaid(String contaid) {
        this.contaid = contaid;
    }

    public String getClienteid() {
        return clienteid;
    }

    public void setClienteid(String clienteid) {
        this.clienteid = clienteid;
    }

    public String getAgenciaid() {
        return agenciaid;
    }

    public void setAgenciaid(String agenciaid) {
        this.agenciaid = agenciaid;
    }

    public Float getSaldo() {
        return saldo;
    }

    public void setSaldo(Float saldo) {
        this.saldo = saldo;
    }

    public Date getAbertura() {
        return abertura;
    }

    public void setAbertura(Date abertura) {
        this.abertura = abertura;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public Boolean getAtiva() {
        return ativa;
    }

    public void setAtiva(Boolean ativa) {
        this.ativa = ativa;
    }

    @Override
    public String toString() {
        return "Conta{" +
                "contaid=" + contaid +
                ", clienteid='" + clienteid + '\'' +
                ", agenciaid='" + agenciaid + '\'' +
                ", saldo=" + saldo +
                ", abertura=" + abertura +
                ", tipo=" + tipo +
                ", ativa=" + ativa +
                '}';
    }
}