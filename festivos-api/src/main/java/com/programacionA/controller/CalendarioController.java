package com.programacionA.festivos_api.controller;

import com.programacionA.festivos_api.service.CalendarioService;
import org.springframework.web.bind.annotation.*;
import com.programacionA.festivos_api.model.Calendario;
import java.util.List;

@RestController
@RequestMapping("/api/calendario")
public class CalendarioController {

    private final CalendarioService calendarioService;

    public CalendarioController(CalendarioService calendarioService) {
        this.calendarioService = calendarioService;
    }

    @GetMapping("/generar/{anio}")
    public boolean generar(@PathVariable int anio) {
        return calendarioService.generarCalendario(anio);
    }

    @GetMapping("/{anio}")
    public List<Calendario> obtener(@PathVariable int anio) {
    return calendarioService.obtenerCalendarioPorAnio(anio);
}
}