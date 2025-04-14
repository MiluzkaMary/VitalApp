package com.saludvital.test;

import com.saludvital.model.Doctor;
import com.saludvital.repositories.DoctorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class DoctorTest {

    @Autowired
    private DoctorRepository doctorRepository;

    @Test
    public void registrarTest() {
        Doctor doctor = new Doctor();
        doctor.setNombre("Dr. Juan");
        doctor.setCorreo("juan@correo.com");
        doctor.setTelefono("123456789");

        Doctor doctorCreado = doctorRepository.save(doctor);

        assertNotNull(doctorCreado);
        assertEquals("Dr. Juan", doctorCreado.getNombre());
    }

    @Test
    public void listarTodosTest() {
        List<Doctor> lista = doctorRepository.findAll();

        assertFalse(lista.isEmpty());
    }

    @Test
    public void eliminarTest() {
        doctorRepository.deleteById(1);

        Doctor doctorEliminado = doctorRepository.findById(1).orElse(null);
        assertNull(doctorEliminado);
    }
}