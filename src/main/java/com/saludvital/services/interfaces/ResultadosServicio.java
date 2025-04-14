package com.saludvital.services.interfaces;

import com.saludvital.model.Resultados;
import java.util.List;

public interface ResultadosServicio {
    Resultados crearResultado(Resultados resultado);
    Resultados obtenerResultadoPorId(int id);
    List<Resultados> listarResultados();
    Resultados actualizarResultado(Resultados resultado);
    void eliminarResultado(int id);
}