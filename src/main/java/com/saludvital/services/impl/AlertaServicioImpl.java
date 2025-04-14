package com.saludvital.services.impl;

import com.saludvital.model.Alerta;
import com.saludvital.repositories.AlertaRepository;
import com.saludvital.services.interfaces.AlertaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlertaServicioImpl implements AlertaServicio {

    @Autowired
    private AlertaRepository alertaRepository;

    @Override
    public Alerta crearAlerta(Alerta alerta) {
        return alertaRepository.save(alerta);
    }

    @Override
    public Alerta obtenerAlertaPorId(int id) {
        return alertaRepository.findById(id).orElse(null);
    }

    @Override
    public List<Alerta> listarAlertas() {
        return alertaRepository.findAll();
    }

    @Override
    public Alerta actualizarAlerta(Alerta alerta) {
        return alertaRepository.save(alerta);
    }

    @Override
    public void eliminarAlerta(int id) {
        alertaRepository.deleteById(id);
    }
}