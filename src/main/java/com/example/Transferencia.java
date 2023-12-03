package com.example;

import java.sql.Date;

public class Transferencia {
    private String transferenciaid;
    private String cliente_transfere;
    private String clienteT_nome;
    private String conta_transfere;
    private String cliente_recebe;
    private String clienteR_nome;

    private String conta_recebe;

    private Float valor;
    private Date data_transferencia;

    public Transferencia(String transferenciaid, String cliente_transfere, String clienteT_nome, String conta_transfere, String cliente_recebe, String clienteR_nome, String conta_recebe, Float valor, Date data_transferencia) {
        this.transferenciaid = transferenciaid;
        this.cliente_transfere = cliente_transfere;
        this.clienteT_nome = clienteT_nome;
        this.conta_transfere = conta_transfere;
        this.cliente_recebe = cliente_recebe;
        this.clienteR_nome = clienteR_nome;
        this.conta_recebe = conta_recebe;
        this.valor = valor;
        this.data_transferencia = data_transferencia;
    }
    public Transferencia(){}

    public String getTransferenciaid() {
        return transferenciaid;
    }

    public void setTransferenciaid(String transferenciaid) {
        this.transferenciaid = transferenciaid;
    }

    public String getCliente_transfere() {
        return cliente_transfere;
    }

    public void setCliente_transfere(String cliente_transfere) {
        this.cliente_transfere = cliente_transfere;
    }

    public String getClienteT_nome() {
        return clienteT_nome;
    }

    public void setClienteT_nome(String clienteT_nome) {
        this.clienteT_nome = clienteT_nome;
    }

    public String getConta_transfere() {
        return conta_transfere;
    }

    public void setConta_transfere(String conta_transfere) {
        this.conta_transfere = conta_transfere;
    }

    public String getCliente_recebe() {
        return cliente_recebe;
    }

    public void setCliente_recebe(String cliente_recebe) {
        this.cliente_recebe = cliente_recebe;
    }

    public String getClienteR_nome() {
        return clienteR_nome;
    }

    public void setClienteR_nome(String clienteR_nome) {
        this.clienteR_nome = clienteR_nome;
    }

    public String getConta_recebe() {
        return conta_recebe;
    }

    public void setConta_recebe(String conta_recebe) {
        this.conta_recebe = conta_recebe;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public Date getData_transferencia() {
        return data_transferencia;
    }

    public void setData_transferencia(Date data_transferencia) {
        this.data_transferencia = data_transferencia;
    }

    @Override
    public String toString() {
        return "Transferencia{" +
                "transferenciaid='" + transferenciaid + '\'' +
                ", cliente_transfere='" + cliente_transfere + '\'' +
                ", clienteT_nome='" + clienteT_nome + '\'' +
                ", conta_transfere='" + conta_transfere + '\'' +
                ", cliente_recebe='" + cliente_recebe + '\'' +
                ", clienteR_nome='" + clienteR_nome + '\'' +
                ", conta_recebe='" + conta_recebe + '\'' +
                ", valor=" + valor +
                ", data_transferencia=" + data_transferencia +
                '}';
    }
}