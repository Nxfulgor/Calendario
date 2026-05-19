package com.programacionA.festivos_api.service;

import com.programacionA.festivos_api.model.*;
import com.programacionA.festivos_api.repository.*;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;


@Service
public class CalendarioService {

    private final FestivoService festivoService;
    private final TipoRepository tipoRepository;
    private final CalendarioRepository calendarioRepository;

    public CalendarioService(FestivoService festivoService,
                             TipoRepository tipoRepository,
                             CalendarioRepository calendarioRepository) {
        this.festivoService = festivoService;
        this.tipoRepository = tipoRepository;
        this.calendarioRepository = calendarioRepository;
    }

    public boolean generarCalendario(int anio) {

        Tipo laboral = tipoRepository.findByTipo("Laboral")
                .orElseGet(() -> tipoRepository.save(new Tipo("Laboral")));

        Tipo finSemana = tipoRepository.findByTipo("Fin de semana")
                .orElseGet(() -> tipoRepository.save(new Tipo("Fin de semana")));

        Tipo festivo = tipoRepository.findByTipo("Festivo")
                .orElseGet(() -> tipoRepository.save(new Tipo("Festivo")));

        LocalDate fecha = LocalDate.of(anio, 1, 1);
        LocalDate fin = LocalDate.of(anio, 12, 31);

        while (!fecha.isAfter(fin)) {

            Tipo tipoDia;
            String descripcion = "";

            if (festivoService.esFestivo(fecha.getYear(), fecha.getMonthValue(), fecha.getDayOfMonth())) {
                tipoDia = festivo;
                descripcion = "Día festivo";
            } else if (fecha.getDayOfWeek() == DayOfWeek.SATURDAY ||
                       fecha.getDayOfWeek() == DayOfWeek.SUNDAY) {
                tipoDia = finSemana;
                descripcion = "Fin de semana";
            } else {
                tipoDia = laboral;
                descripcion = "Día laboral";
            }

            Calendario cal = new Calendario(fecha, descripcion, tipoDia);
            calendarioRepository.save(cal);

            fecha = fecha.plusDays(1);
        }

        return true;
    }

    public List<Calendario> obtenerCalendarioPorAnio(int anio) {
        LocalDate inicio = LocalDate.of(anio, 1, 1);
        LocalDate fin = LocalDate.of(anio, 12, 31);

        return calendarioRepository.findByFechaBetween(inicio, fin);
    }
}