package com.example;

import java.sql.Date;

public class Cartao {
    private int cardnum;
    private  int limite ;
    private Date validade;
    private String clienteid;

    public Cartao(int cardnum, int limite, Date validade, String clienteid) {
        this.cardnum = cardnum;
        this.limite = limite;
        this.validade = validade;
        this.clienteid = clienteid;
    }

    public Cartao(){}

    public int getCardnum() {
        return cardnum;
    }

    public void setCardnum(int cardnum) {
        this.cardnum = cardnum;
    }

    public int getLimite() {
        return limite;
    }

    public void setLimite(int limite) {
        this.limite = limite;
    }

    public Date getValidade() {
        return validade;
    }

    public void setValidade(Date validade) {
        this.validade = validade;
    }

    public String getClienteid() {
        return clienteid;
    }

    public void setClienteid(String clienteid) {
        this.clienteid = clienteid;
    }

    @Override
    public String toString() {
        return "Cartao{" +
                "cardnum=" + cardnum +
                ", limite=" + limite +
                ", validade=" + validade +
                ", clienteid='" + clienteid + '\'' +
                '}';
    }
}