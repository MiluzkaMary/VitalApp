package com.saludvital.repositories;

import com.saludvital.model.Alerta;
import com.saludvital.model.Doctor;
import com.saludvital.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlertaRepository extends JpaRepository<Alerta, Integer> {

    List<Alerta> findByPaciente(Paciente paciente);
    List<Alerta> findByDoctor(Doctor doctor);
    List<Alerta> findByTipoAlertaContainingIgnoreCase(String tipoAlerta);
}
