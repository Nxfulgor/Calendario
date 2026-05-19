package com.programacionA.festivos_api.model;

public class FestivoResponse {

    private String fecha;
    private String resultado;
    private String nombre;

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "FestivoResponse{" +
                "fecha='" + fecha + '\'' +
                ", resultado='" + resultado + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}