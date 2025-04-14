package com.saludvital.test;

import com.saludvital.model.Alerta;
import com.saludvital.services.interfaces.AlertaServicio;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class AlertaServicioTest {

    @Autowired
    private AlertaServicio alertaServicio;

    @Test
    public void crearAlertaTest() {
        Alerta alerta = new Alerta();
        alerta.setMensaje("Alerta de prueba");
        alerta.setTipoAlerta("Urgente");
        alerta.setFechaHora(LocalDateTime.now());

        Alerta alertaCreada = alertaServicio.crearAlerta(alerta);

        assertNotNull(alertaCreada);
        assertEquals("Alerta de prueba", alertaCreada.getMensaje());
    }

    @Test
    public void listarAlertasTest() {
        List<Alerta> lista = alertaServicio.listarAlertas();

        assertNotNull(lista);
        assertFalse(lista.isEmpty());
    }

    @Test
    public void eliminarAlertaTest() {
        alertaServicio.eliminarAlerta(1);

        Alerta alertaEliminada = alertaServicio.obtenerAlertaPorId(1);
        assertNull(alertaEliminada);
    }
}