package com.saludvital.repositories;

import com.saludvital.model.Resultados;
import com.saludvital.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ResultadosRepository extends JpaRepository<Resultados, Integer> {

    List<Resultados> findByPaciente(Paciente paciente);
    List<Resultados> findByFechaEntregaBetween(LocalDate desde, LocalDate hasta);
}
