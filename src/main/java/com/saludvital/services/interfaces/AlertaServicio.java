package com.saludvital.services.interfaces;

import com.saludvital.model.Alerta;
import java.util.List;

public interface AlertaServicio {
    Alerta crearAlerta(Alerta alerta);
    Alerta obtenerAlertaPorId(int id);
    List<Alerta> listarAlertas();
    Alerta actualizarAlerta(Alerta alerta);
    void eliminarAlerta(int id);
}