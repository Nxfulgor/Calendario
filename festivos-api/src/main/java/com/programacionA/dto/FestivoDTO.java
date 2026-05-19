package com.programacionA.festivos_api.dto;

public class FestivoDTO {

    private String fecha;
    private String festivo;

    public FestivoDTO(String fecha, String festivo) {
        this.fecha = fecha;
        this.festivo = festivo;
    }

    public String getFecha() {
        return fecha;
    }

    public String getFestivo() {
        return festivo;
    }
}