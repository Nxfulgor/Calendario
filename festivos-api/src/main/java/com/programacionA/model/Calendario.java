package com.programacionA.festivos_api.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Calendario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate fecha;

    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "id_tipo")
    private Tipo tipo;

    public Calendario() {}

    public Calendario(LocalDate fecha, String descripcion, Tipo tipo) {
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.tipo = tipo;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Tipo getTipo() {
        return tipo;
    }
}