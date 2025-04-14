package com.saludvital.services.interfaces;

import com.saludvital.model.Doctor;
import java.util.List;

public interface DoctorServicio {
    Doctor crearDoctor(Doctor doctor);
    Doctor obtenerDoctorPorId(int id);
    List<Doctor> listarDoctores();
    Doctor actualizarDoctor(Doctor doctor);
    void eliminarDoctor(int id);
}