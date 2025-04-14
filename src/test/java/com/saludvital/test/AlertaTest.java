package com.saludvital.test;

import com.saludvital.model.Alerta;
import com.saludvital.model.Doctor;
import com.saludvital.model.Paciente;
import com.saludvital.repositories.AlertaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class AlertaTest {

    @Autowired
    private AlertaRepository alertaRepository;

    @Test
    public void registrarTest() {
        Alerta alerta = new Alerta();
        alerta.setMensaje("Alerta de prueba");
        alerta.setTipoAlerta("Urgente");
        alerta.setFechaHora(LocalDateTime.now());
        alerta.setDoctor(new Doctor()); // Asignar un doctor válido
        alerta.setPaciente(new Paciente()); // Asignar un paciente válido

        Alerta alertaCreada = alertaRepository.save(alerta);

        assertNotNull(alertaCreada);
        assertEquals("Alerta de prueba", alertaCreada.getMensaje());
    }

    @Test
    public void listarTodosTest() {
        List<Alerta> lista = alertaRepository.findAll();

        assertFalse(lista.isEmpty());
    }

    @Test
    public void eliminarTest() {
        alertaRepository.deleteById(1);

        Alerta alertaEliminada = alertaRepository.findById(1).orElse(null);
        assertNull(alertaEliminada);
    }
}