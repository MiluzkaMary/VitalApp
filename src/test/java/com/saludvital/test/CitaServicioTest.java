package com.saludvital.test;

import com.saludvital.model.Cita;
import com.saludvital.model.Doctor;
import com.saludvital.model.Paciente;
import com.saludvital.services.interfaces.CitaServicio;
import com.saludvital.services.interfaces.DoctorServicio;
import com.saludvital.services.interfaces.PacienteServicio;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
public class CitaServicioTest {

    @Autowired
    private CitaServicio citaServicio;

    @Autowired
    private DoctorServicio doctorServicio;

    @Autowired
    private PacienteServicio pacienteServicio;

    @Test
    public void crearCitaTest() {
        // Crear y guardar un doctor válido
        Doctor doctor = new Doctor();
        doctor.setNombre("Dr. Juan");
        doctor.setCorreo("juan@correo.com");
        doctor.setTelefono("123456789");
        doctor = doctorServicio.crearDoctor(doctor);

        // Crear y guardar un paciente válido
        Paciente paciente = new Paciente();
        paciente.setNombre("Camilo");
        paciente.setCorreo("camilo@email.com");
        paciente.setTelefono("987654321");
        paciente.setDireccion("Calle 456");
        paciente = pacienteServicio.crearPaciente(paciente);

        // Crear y guardar la cita
        Cita cita = new Cita();
        cita.setFechaHora(LocalDateTime.now());
        cita.setMotivo("Consulta general");
        cita.setDoctor(doctor); // Asignar el doctor creado
        cita.setPaciente(paciente); // Asignar el paciente creado

        Cita citaCreada = citaServicio.crearCita(cita);

        // Verificar que la cita fue creada correctamente
        assertNotNull(citaCreada);
        assertEquals("Consulta general", citaCreada.getMotivo());
    }

    @Test
    public void editarTest() {
        // Crear y guardar un doctor válido
        Doctor doctor = new Doctor();
        doctor.setNombre("Dr. Juan");
        doctor.setCorreo("juan@correo.com");
        doctor.setTelefono("123456789");
        doctor = doctorServicio.crearDoctor(doctor);

        // Crear y guardar un paciente válido
        Paciente paciente = new Paciente();
        paciente.setNombre("Camilo");
        paciente.setCorreo("camilo@email.com");
        paciente.setTelefono("987654321");
        paciente.setDireccion("Calle 456");
        paciente = pacienteServicio.crearPaciente(paciente);

        // Crear y guardar una cita
        Cita cita = new Cita();
        cita.setFechaHora(LocalDateTime.now());
        cita.setMotivo("Consulta inicial");
        cita.setDoctor(doctor);
        cita.setPaciente(paciente);
        cita = citaServicio.crearCita(cita);

        // Editar la cita
        cita.setMotivo("Consulta actualizada");
        cita.setFechaHora(LocalDateTime.now().plusDays(1));
        Cita citaEditada = citaServicio.actualizarCita(cita);

        // Verificar que los cambios se hayan aplicado
        assertNotNull(citaEditada);
        assertEquals("Consulta actualizada", citaEditada.getMotivo());
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