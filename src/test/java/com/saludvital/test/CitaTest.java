package com.saludvital.test;

import com.saludvital.model.Cita;
import com.saludvital.model.Doctor;
import com.saludvital.model.Paciente;
import com.saludvital.repositories.CitaRepository;
import com.saludvital.repositories.DoctorRepository;
import com.saludvital.repositories.PacienteRepository;
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

        // Crear y guardar la cita
        Cita cita = new Cita();
        cita.setFechaHora(LocalDateTime.now());
        cita.setMotivo("Consulta general");
        cita.setDoctor(doctor); // Asignar el doctor creado
        cita.setPaciente(paciente); // Asignar el paciente creado

        Cita citaCreada = citaRepository.save(cita);

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
        doctor = doctorRepository.save(doctor);

        // Crear y guardar un paciente válido
        Paciente paciente = new Paciente();
        paciente.setNombre("Camilo");
        paciente.setCorreo("camilo@email.com");
        paciente.setTelefono("987654321");
        paciente.setDireccion("Calle 456");
        paciente = pacienteRepository.save(paciente);

        // Crear y guardar una cita
        Cita cita = new Cita();
        cita.setFechaHora(LocalDateTime.now());
        cita.setMotivo("Consulta inicial");
        cita.setDoctor(doctor);
        cita.setPaciente(paciente);
        cita = citaRepository.save(cita);

        // Editar la cita
        cita.setMotivo("Consulta actualizada");
        cita.setFechaHora(LocalDateTime.now().plusDays(1));
        Cita citaEditada = citaRepository.save(cita);

        // Verificar que los cambios se hayan aplicado
        assertNotNull(citaEditada);
        assertEquals("Consulta actualizada", citaEditada.getMotivo());
    }

    @Test
    public void listarTodosTest() {
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

        // Crear y guardar una cita
        Cita cita = new Cita();
        cita.setFechaHora(LocalDateTime.now());
        cita.setMotivo("Consulta general");
        cita.setDoctor(doctor);
        cita.setPaciente(paciente);
        citaRepository.save(cita);

        // Consultar todas las citas
        List<Cita> lista = citaRepository.findAll();

        // Verificar que la lista no esté vacía
        System.out.println("Tamaño de la lista: " + lista.size());
        assertFalse(lista.isEmpty());
    }

    @Test
    public void eliminarTest() {
        citaRepository.deleteById(1);

        Cita citaEliminada = citaRepository.findById(1).orElse(null);
        assertNull(citaEliminada);
    }
}