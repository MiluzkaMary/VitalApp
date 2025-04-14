package com.saludvital.services.impl;

import com.saludvital.model.Paciente;
import com.saludvital.repositories.PacienteRepository;
import com.saludvital.services.interfaces.PacienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteServicioImpl implements PacienteServicio {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Override
    public Paciente crearPaciente(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    @Override
    public Paciente obtenerPacientePorId(int id) {
        return pacienteRepository.findById(id).orElse(null);
    }

    @Override
    public List<Paciente> listarPacientes() {
        return pacienteRepository.findAll();
    }

    @Override
    public Paciente actualizarPaciente(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    @Override
    public void eliminarPaciente(int id) {
        pacienteRepository.deleteById(id);
    }
}