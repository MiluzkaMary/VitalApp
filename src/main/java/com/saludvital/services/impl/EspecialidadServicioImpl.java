package com.saludvital.services.impl;

import com.saludvital.model.Especialidad;
import com.saludvital.repositories.EspecialidadRepository;
import com.saludvital.services.interfaces.EspecialidadServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EspecialidadServicioImpl implements EspecialidadServicio {

    @Autowired
    private EspecialidadRepository especialidadRepository;

    @Override
    public Especialidad crearEspecialidad(Especialidad especialidad) {
        return especialidadRepository.save(especialidad);
    }

    @Override
    public Especialidad obtenerEspecialidadPorId(int id) {
        return especialidadRepository.findById(id).orElse(null);
    }

    @Override
    public List<Especialidad> listarEspecialidades() {
        return especialidadRepository.findAll();
    }

    @Override
    public Especialidad actualizarEspecialidad(Especialidad especialidad) {
        return especialidadRepository.save(especialidad);
    }

    @Override
    public void eliminarEspecialidad(int id) {
        especialidadRepository.deleteById(id);
    }
}