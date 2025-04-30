package com.saludvital.test;

import com.saludvital.model.Alerta;
import com.saludvital.model.Doctor;
import com.saludvital.model.Paciente;
import com.saludvital.services.interfaces.AlertaServicio;
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
public class AlertaServicioTest {

    @Autowired
    private AlertaServicio alertaServicio;

    @Autowired
    private DoctorServicio doctorServicio;

    @Autowired
    private PacienteServicio pacienteServicio;

    @Test
    public void crearAlertaTest() {
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

        // Crear y guardar la alerta
        Alerta alerta = new Alerta();
        alerta.setMensaje("Alerta de prueba");
        alerta.setTipoAlerta("Urgente");
        alerta.setFechaHora(LocalDateTime.now());
        alerta.setDoctor(doctor); // Asignar el doctor creado
        alerta.setPaciente(paciente); // Asignar el paciente creado

        Alerta alertaCreada = alertaServicio.crearAlerta(alerta);

        // Verificar que la alerta fue creada correctamente
        assertNotNull(alertaCreada);
        assertEquals("Alerta de prueba", alertaCreada.getMensaje());
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

        // Crear y guardar una alerta
        Alerta alerta = new Alerta();
        alerta.setMensaje("Alerta inicial");
        alerta.setTipoAlerta("Normal");
        alerta.setFechaHora(LocalDateTime.now());
        alerta.setDoctor(doctor);
        alerta.setPaciente(paciente);
        alerta = alertaServicio.crearAlerta(alerta);

        // Editar la alerta
        alerta.setMensaje("Alerta actualizada");
        alerta.setTipoAlerta("Urgente");
        Alerta alertaEditada = alertaServicio.actualizarAlerta(alerta);

        // Verificar que los cambios se hayan aplicado
        assertNotNull(alertaEditada);
        assertEquals("Alerta actualizada", alertaEditada.getMensaje());
        assertEquals("Urgente", alertaEditada.getTipoAlerta());
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