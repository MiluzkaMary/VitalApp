package com.saludvital.test;

import com.saludvital.model.Doctor;
import com.saludvital.services.interfaces.DoctorServicio;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class DoctorServicioTest {

    @Autowired
    private DoctorServicio doctorServicio;

    @Test
    public void crearDoctorTest() {
        Doctor doctor = new Doctor();
        doctor.setNombre("Dr. Juan");
        doctor.setCorreo("juan@correo.com");
        doctor.setTelefono("123456789");

        Doctor doctorCreado = doctorServicio.crearDoctor(doctor);

        assertNotNull(doctorCreado);
        assertEquals("Dr. Juan", doctorCreado.getNombre());
    }

    @Test
    public void listarDoctoresTest() {
        List<Doctor> lista = doctorServicio.listarDoctores();

        assertNotNull(lista);
        assertFalse(lista.isEmpty());
    }

    @Test
    public void eliminarDoctorTest() {
        doctorServicio.eliminarDoctor(1);

        Doctor doctorEliminado = doctorServicio.obtenerDoctorPorId(1);
        assertNull(doctorEliminado);
    }
}