package com.saludvital.repositories;

import com.saludvital.model.Doctor;
import com.saludvital.model.Especialidad;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {

    List<Doctor> findByEspecialidad(Especialidad especialidad);
    List<Doctor> findByNombreContainingIgnoreCase(String nombre);
}
