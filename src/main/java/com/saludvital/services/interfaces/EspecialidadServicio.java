package com.saludvital.services.interfaces;

import com.saludvital.model.Especialidad;
import java.util.List;

public interface EspecialidadServicio {
    Especialidad crearEspecialidad(Especialidad especialidad);
    Especialidad obtenerEspecialidadPorId(int id);
    List<Especialidad> listarEspecialidades();
    Especialidad actualizarEspecialidad(Especialidad especialidad);
    void eliminarEspecialidad(int id);
}