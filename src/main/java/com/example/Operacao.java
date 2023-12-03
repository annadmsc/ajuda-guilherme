package com.example;

import java.sql.Date;

public class Operacao {
    private  String operacaoid;
    private String contaid;
    private Date data_op;
    private String tipo_operacao;
    private Float decimal;

    public Operacao(String operacaoid, String contaid, Date data_op, String tipo_operacao, Float decimal) {
        this.operacaoid = operacaoid;
        this.contaid = contaid;
        this.data_op = data_op;
        this.tipo_operacao = tipo_operacao;
        this.decimal = decimal;
    }

    public Operacao(){}

    public String getOperacaoid() {
        return operacaoid;
    }

    public void setOperacaoid(String operacaoid) {
        this.operacaoid = operacaoid;
    }

    public String getContaid() {
        return contaid;
    }

    public void setContaid(String contaid) {
        this.contaid = contaid;
    }

    public Date getData_op() {
        return data_op;
    }

    public void setData_op(Date data_op) {
        this.data_op = data_op;
    }

    public String getTipo_operacao() {
        return tipo_operacao;
    }

    public void setTipo_operacao(String tipo_operacao) {
        this.tipo_operacao = tipo_operacao;
    }

    public Float getDecimal() {
        return decimal;
    }

    public void setDecimal(Float decimal) {
        this.decimal = decimal;
    }

    @Override
    public String toString() {
        return "Operacao{" +
                "operacaoid='" + operacaoid + '\'' +
                ", contaid='" + contaid + '\'' +
                ", data_op=" + data_op +
                ", tipo_operacao='" + tipo_operacao + '\'' +
                ", decimal=" + decimal +
                '}';
    }
}