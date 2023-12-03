package com.example;

public class Emprestimo {
    private String emprestimoid;
    private String contaid;
    private String agenciaid;
    private Float valor;

    public Emprestimo(String emprestimoid, String contaid, String agenciaid, Float valor) {
        this.emprestimoid = emprestimoid;
        this.contaid = contaid;
        this.agenciaid = agenciaid;
        this.valor = valor;
    }

    public Emprestimo(){}



    public String getEmprestimoid() {
        return emprestimoid;
    }

    public void setEmprestimoid(String emprestimoid) {
        this.emprestimoid = emprestimoid;
    }

    public String getContaid() {
        return contaid;
    }

    public void setContaid(String contaid) {
        this.contaid = contaid;
    }

    public String getAgenciaid() {
        return agenciaid;
    }

    public void setAgenciaid(String agenciaid) {
        this.agenciaid = agenciaid;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Emprestimo{" +
                "emprestimoid='" + emprestimoid + '\'' +
                ", contaid='" + contaid + '\'' +
                ", agenciaid='" + agenciaid + '\'' +
                ", valor=" + valor +
                '}';
    }
}