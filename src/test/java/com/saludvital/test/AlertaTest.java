package com.saludvital.test;

import com.saludvital.model.Alerta;
import com.saludvital.model.Doctor;
import com.saludvital.model.Paciente;
import com.saludvital.repositories.AlertaRepository;
import com.saludvital.repositories.DoctorRepository;
import com.saludvital.repositories.PacienteRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
public class AlertaTest {

    @Autowired
    private AlertaRepository alertaRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Test
    public void registrarTest() {
        // Crear y guardar un doctor válido
        Doctor doctor = new Doctor();
        doctor.setNombre("Dr. Juan");
        doctor.setCorreo("juan@correo.com");
        doctor.setTelefono("123456789");
        doctor = doctorRepository.save(doctor);

        // Crear y guardar un paciente válido
        Paciente paciente = new Paciente();
        paciente.setNombre("Camilo");
        paciente.setCorreo("camilo@email.com");
        paciente.setTelefono("987654321");
        paciente.setDireccion("Calle 456");
        paciente = pacienteRepository.save(paciente);

        // Crear y guardar la alerta
        Alerta alerta = new Alerta();
        alerta.setMensaje("Alerta de prueba");
        alerta.setTipoAlerta("Innecesario");
        alerta.setFechaHora(LocalDateTime.now());
        alerta.setDoctor(doctor); // Asignar el doctor creado
        alerta.setPaciente(paciente); // Asignar el paciente creado

        Alerta alertaCreada = alertaRepository.save(alerta);

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
        doctor = doctorRepository.save(doctor);

        // Crear y guardar un paciente válido
        Paciente paciente = new Paciente();
        paciente.setNombre("Camilo");
        paciente.setCorreo("camilo@email.com");
        paciente.setTelefono("987654321");
        paciente.setDireccion("Calle 456");
        paciente = pacienteRepository.save(paciente);

        // Crear y guardar una alerta
        Alerta alerta = new Alerta();
        alerta.setMensaje("Alerta inicial");
        alerta.setTipoAlerta("Normal");
        alerta.setFechaHora(LocalDateTime.now());
        alerta.setDoctor(doctor);
        alerta.setPaciente(paciente);
        alerta = alertaRepository.save(alerta);

        // Editar la alerta
        alerta.setMensaje("Alerta actualizada");
        alerta.setTipoAlerta("Urgente");
        Alerta alertaEditada = alertaRepository.save(alerta);

        // Verificar que los cambios se hayan aplicado
        assertNotNull(alertaEditada);
        assertEquals("Alerta actualizada", alertaEditada.getMensaje());
        assertEquals("Urgente", alertaEditada.getTipoAlerta());
    }

    //aqui arriba

    @Test
    public void listarTodosTest() {
        // Crear y guardar un doctor válido
        Doctor doctor = new Doctor();
        doctor.setNombre("Dr. Pedro");
        doctor.setCorreo("pedro@correo.com");
        doctor.setTelefono("123456789");
        doctor = doctorRepository.save(doctor);

        // Crear y guardar un paciente válido
        Paciente paciente = new Paciente();
        paciente.setNombre("Ana");
        paciente.setCorreo("ana@email.com");
        paciente.setTelefono("987654321");
        paciente.setDireccion("Calle 789");
        paciente = pacienteRepository.save(paciente);

        // Crear y guardar una alerta
        Alerta alerta = new Alerta();
        alerta.setMensaje("Alerta de prueba");
        alerta.setTipoAlerta("Informativa");
        alerta.setFechaHora(LocalDateTime.now());
        alerta.setDoctor(doctor);
        alerta.setPaciente(paciente);
        alertaRepository.save(alerta);

        // Consultar todas las alertas
        List<Alerta> lista = alertaRepository.findAll();

        // Verificar que la lista no esté vacía
        System.out.println("Tamaño de la lista: " + lista.size());
        assertFalse(lista.isEmpty());
    }

    @Test
    public void eliminarTest() {
        alertaRepository.deleteById(1);

        Alerta alertaEliminada = alertaRepository.findById(1).orElse(null);
        assertNull(alertaEliminada);
    }
}