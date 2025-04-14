package com.saludvital.services.impl;

import com.saludvital.model.Cita;
import com.saludvital.repositories.CitaRepository;
import com.saludvital.services.interfaces.CitaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitaServicioImpl implements CitaServicio {

    @Autowired
    private CitaRepository citaRepository;

    @Override
    public Cita crearCita(Cita cita) {
        return citaRepository.save(cita);
    }

    @Override
    public Cita obtenerCitaPorId(int id) {
        return citaRepository.findById(id).orElse(null);
    }

    @Override
    public List<Cita> listarCitas() {
        return citaRepository.findAll();
    }

    @Override
    public Cita actualizarCita(Cita cita) {
        return citaRepository.save(cita);
    }

    @Override
    public void eliminarCita(int id) {
        citaRepository.deleteById(id);
    }
}