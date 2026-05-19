package com.programacionA.festivos_api.controller;

import com.programacionA.festivos_api.service.FestivoService;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import com.programacionA.festivos_api.dto.FestivoDTO;

@RestController
@RequestMapping("/api/festivos")
public class FestivoController {

    private final FestivoService festivoService;

    public FestivoController(FestivoService festivoService) {
        this.festivoService = festivoService;
    }

    @GetMapping("/verificar/{anio}/{mes}/{dia}")
    public boolean verificarFestivo(
            @PathVariable int anio,
            @PathVariable int mes,
            @PathVariable int dia) {

        return festivoService.esFestivo(anio, mes, dia);
    }

    @GetMapping("/obtener/{anio}")
        public List<FestivoDTO> obtenerFestivos(@PathVariable int anio) {
        return festivoService.obtenerFestivosConNombre(anio);
    }
}