package com.saludvital.test;

import com.saludvital.model.Cita;
import com.saludvital.model.Doctor;
import com.saludvital.model.Paciente;
import com.saludvital.repositories.CitaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CitaTest {

    @Autowired
    private CitaRepository citaRepository;

    @Test
    public void registrarTest() {
        Cita cita = new Cita();
        cita.setFechaHora(LocalDateTime.now());
        cita.setMotivo("Consulta general");
        cita.setDoctor(new Doctor()); // Asignar un doctor válido
        cita.setPaciente(new Paciente()); // Asignar un paciente válido

        Cita citaCreada = citaRepository.save(cita);

        assertNotNull(citaCreada);
        assertEquals("Consulta general", citaCreada.getMotivo());
    }

    @Test
    public void listarTodosTest() {
        List<Cita> lista = citaRepository.findAll();

        assertFalse(lista.isEmpty());
    }

    @Test
    public void eliminarTest() {
        citaRepository.deleteById(1);

        Cita citaEliminada = citaRepository.findById(1).orElse(null);
        assertNull(citaEliminada);
    }
}