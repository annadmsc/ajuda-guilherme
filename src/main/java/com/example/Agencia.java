package com.example;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "agencia")
public class Agencia {
    @Id
    private String agenciaid;

    private String nome;
    private String cidade;

    public String getAgenciaid() {
        return agenciaid;
    }

    public void setAgenciaid(String agenciaid) {
        this.agenciaid = agenciaid;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @Override
    public String toString() {
        return "Agencia{" +
                "agenciaid=" + agenciaid +
                ", nome='" + nome + '\'' +
                ", cidade='" + cidade + '\'' +
                '}';
    }
}