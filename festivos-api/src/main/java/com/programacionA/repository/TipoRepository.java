package com.programacionA.festivos_api.repository;

import com.programacionA.festivos_api.model.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TipoRepository extends JpaRepository<Tipo, Long> {
    Optional<Tipo> findByTipo(String tipo);
}