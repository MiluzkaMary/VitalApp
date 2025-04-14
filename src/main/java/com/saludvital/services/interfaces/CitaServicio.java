package com.saludvital.services.interfaces;

import com.saludvital.model.Cita;
import java.util.List;

public interface CitaServicio {
    Cita crearCita(Cita cita);
    Cita obtenerCitaPorId(int id);
    List<Cita> listarCitas();
    Cita actualizarCita(Cita cita);
    void eliminarCita(int id);
}