package com.programacionA.festivos_api.service;

import com.programacionA.festivos_api.model.FestivoResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.programacionA.festivos_api.dto.FestivoDTO;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;

@Service
public class FestivoService {

    @Value("${festivos.api.url}")
    private String URL;

    public boolean esFestivo(int anio, int mes, int dia) {
        RestTemplate restTemplate = new RestTemplate();

        String urlCompleta = URL + anio + "/" + mes + "/" + dia;

        try {
            var response = restTemplate.getForObject(urlCompleta, FestivoResponse.class);

            System.out.println("Respuesta completa: " + response);
            System.out.println("Resultado: " + (response != null ? response.getResultado() : "null"));

            return response != null &&
                response.getResultado() != null &&
                response.getResultado().toLowerCase().startsWith("es festivo");

        } catch (Exception e) {
            System.out.println("Error consumiendo API: " + e.getMessage());
            return false;
        }
    }

    public List<LocalDate> obtenerFestivosPorAnio(int anio) {
    List<LocalDate> festivos = new ArrayList<>();

    LocalDate fecha = LocalDate.of(anio, 1, 1);
    LocalDate fin = LocalDate.of(anio, 12, 31);

    while (!fecha.isAfter(fin)) {
        if (esFestivo(fecha.getYear(), fecha.getMonthValue(), fecha.getDayOfMonth())) {
            festivos.add(fecha);
        }
        fecha = fecha.plusDays(1);
    }

        return festivos;
    }

    public List<FestivoDTO> obtenerFestivosConNombre(int anio) {
    List<FestivoDTO> festivos = new ArrayList<>();

    LocalDate fecha = LocalDate.of(anio, 1, 1);
    LocalDate fin = LocalDate.of(anio, 12, 31);

    while (!fecha.isAfter(fin)) {

        RestTemplate restTemplate = new RestTemplate();
        String urlCompleta = URL + fecha.getYear() + "/" + fecha.getMonthValue() + "/" + fecha.getDayOfMonth();

        try {
            var response = restTemplate.getForObject(urlCompleta, FestivoResponse.class);

            if (response != null &&
                response.getResultado() != null &&
                response.getResultado().toLowerCase().startsWith("es festivo")) {

                festivos.add(new FestivoDTO(
                        fecha.toString(),
                        response.getNombre()
                ));
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        fecha = fecha.plusDays(1);
    }

    return festivos;
}
}