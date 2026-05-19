package com.programacionA.festivos_api.model;

import jakarta.persistence.*;

@Entity
public class Tipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipo;

    public Tipo() {}

    public Tipo(String tipo) {
        this.tipo = tipo;
    }

    public Long getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}