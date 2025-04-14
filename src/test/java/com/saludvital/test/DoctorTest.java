package com.saludvital.test;

import com.saludvital.model.Doctor;
import com.saludvital.model.Especialidad;
import com.saludvital.repositories.DoctorRepository;
import com.saludvital.repositories.EspecialidadRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class DoctorTest {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private EspecialidadRepository especialidadRepository;

    @Test
    public void registrarTest() {
        // Crear y guardar una especialidad válida
        Especialidad especialidad = new Especialidad();
        especialidad.setNombre("Cardiología");
        especialidad.setDescripcion("Especialidad del corazón");
        especialidad = especialidadRepository.save(especialidad);

        // Crear y guardar un doctor válido
        Doctor doctor = new Doctor();
        doctor.setNombre("Dr. Juan");
        doctor.setCorreo("juan@correo.com");
        doctor.setTelefono("123456789");
        doctor.setEspecialidad(especialidad); // Asignar la especialidad creada

        Doctor doctorCreado = doctorRepository.save(doctor);

        assertNotNull(doctorCreado);
        assertEquals("Dr. Juan", doctorCreado.getNombre());
    }

    @Test
    public void editarTest() {
        // Crear y guardar una especialidad válida
        Especialidad especialidad = new Especialidad();
        especialidad.setNombre("Cardiología");
        especialidad.setDescripcion("Especialidad del corazón");
        especialidad = especialidadRepository.save(especialidad);

        // Crear y guardar un doctor válido
        Doctor doctor = new Doctor();
        doctor.setNombre("Dr. Juan");
        doctor.setCorreo("juan@correo.com");
        doctor.setTelefono("123456789");
        doctor.setEspecialidad(especialidad);
        doctor = doctorRepository.save(doctor);

        // Editar el doctor
        doctor.setNombre("Dr. Pedro");
        doctor.setCorreo("pedro@correo.com");
        doctor.setTelefono("987654321");
        Doctor doctorEditado = doctorRepository.save(doctor);

        assertNotNull(doctorEditado);
        assertEquals("Dr. Pedro", doctorEditado.getNombre());
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