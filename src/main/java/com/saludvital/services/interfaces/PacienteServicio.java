package com.saludvital.services.interfaces;

import com.saludvital.model.Paciente;
import java.util.List;

public interface PacienteServicio {
    Paciente crearPaciente(Paciente paciente);
    Paciente obtenerPacientePorId(int id);
    List<Paciente> listarPacientes();
    Paciente actualizarPaciente(Paciente paciente);
    void eliminarPaciente(int id);
}