package com.saludvital.repositories;

import com.saludvital.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface PacienteRepository extends JpaRepository<Paciente, Integer> {

    Optional<Paciente> findByCorreo(String correo);
    Optional<Paciente> findByNombre(String nombre);
    boolean existsByCorreo(String correo);
}
