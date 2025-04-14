package com.saludvital.repositories;

import com.saludvital.model.Cita;
import com.saludvital.model.Doctor;
import com.saludvital.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface CitaRepository extends JpaRepository<Cita, Integer> {

    List<Cita> findByPaciente(Paciente paciente);
    List<Cita> findByDoctor(Doctor doctor);
    List<Cita> findByFechaHoraBetween(LocalDateTime inicio, LocalDateTime fin);
    boolean existsByDoctorAndFechaHora(Doctor doctor, LocalDateTime fechaHora);
}

