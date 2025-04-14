package com.saludvital.services.impl;

import com.saludvital.model.Resultados;
import com.saludvital.repositories.ResultadosRepository;
import com.saludvital.services.interfaces.ResultadosServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultadosServicioImpl implements ResultadosServicio {

    @Autowired
    private ResultadosRepository resultadosRepository;

    @Override
    public Resultados crearResultado(Resultados resultado) {
        return resultadosRepository.save(resultado);
    }

    @Override
    public Resultados obtenerResultadoPorId(int id) {
        return resultadosRepository.findById(id).orElse(null);
    }

    @Override
    public List<Resultados> listarResultados() {
        return resultadosRepository.findAll();
    }

    @Override
    public Resultados actualizarResultado(Resultados resultado) {
        return resultadosRepository.save(resultado);
    }

    @Override
    public void eliminarResultado(int id) {
        resultadosRepository.deleteById(id);
    }
}