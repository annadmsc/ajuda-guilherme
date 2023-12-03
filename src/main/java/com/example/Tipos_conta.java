package com.example;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tipos_conta")
public class Tipos_conta {
    @Id
    private int tipoid;

    private String tiponome;

    public int getTipoid() {
        return tipoid;
    }

    public void setTipoid(int tipoid) {
        this.tipoid = tipoid;
    }

    public String getTiponome() {
        return tiponome;
    }

    public void setTiponome(String tiponome) {
        this.tiponome = tiponome;
    }

    @Override
    public String toString() {
        return "Tipos_conta{" +
                "tipoid=" + tipoid +
                ", tiponome='" + tiponome + '\'' +
                '}';
    }
}