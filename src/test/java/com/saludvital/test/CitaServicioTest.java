package com.saludvital.test;

import com.saludvital.model.Cita;
import com.saludvital.model.Doctor;
import com.saludvital.model.Paciente;
import com.saludvital.services.interfaces.CitaServicio;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CitaServicioTest {

    @Autowired
    private CitaServicio citaServicio;

    @Test
    public void crearCitaTest() {
        Cita cita = new Cita();
        cita.setFechaHora(LocalDateTime.now());
        cita.setMotivo("Consulta general");
        cita.setDoctor(new Doctor()); // Asignar un doctor válido
        cita.setPaciente(new Paciente()); // Asignar un paciente válido

        Cita citaCreada = citaServicio.crearCita(cita);

        assertNotNull(citaCreada);
        assertEquals("Consulta general", citaCreada.getMotivo());
    }

    @Test
    public void listarCitasTest() {
        List<Cita> lista = citaServicio.listarCitas();

        assertNotNull(lista);
        assertFalse(lista.isEmpty());
    }

    @Test
    public void eliminarCitaTest() {
        citaServicio.eliminarCita(1);

        Cita citaEliminada = citaServicio.obtenerCitaPorId(1);
        assertNull(citaEliminada);
    }
}