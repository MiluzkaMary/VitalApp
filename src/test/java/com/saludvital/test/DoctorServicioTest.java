package com.saludvital.test;

import com.saludvital.model.Doctor;
import com.saludvital.model.Especialidad;
import com.saludvital.services.interfaces.DoctorServicio;
import com.saludvital.services.interfaces.EspecialidadServicio;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class DoctorServicioTest {

    @Autowired
    private DoctorServicio doctorServicio;

    @Autowired
    private EspecialidadServicio especialidadServicio;

    @Test
    public void crearDoctorTest() {
        // Crear y guardar una especialidad válida
        Especialidad especialidad = new Especialidad();
        especialidad.setNombre("Cardiología");
        especialidad.setDescripcion("Especialidad del corazón");
        especialidad = especialidadServicio.crearEspecialidad(especialidad);

        // Crear y guardar un doctor válido
        Doctor doctor = new Doctor();
        doctor.setNombre("Dr. Juan");
        doctor.setCorreo("juan@correo.com");
        doctor.setTelefono("123456789");
        doctor.setEspecialidad(especialidad); // Asignar la especialidad creada

        Doctor doctorCreado = doctorServicio.crearDoctor(doctor);

        assertNotNull(doctorCreado);
        assertEquals("Dr. Juan", doctorCreado.getNombre());
    }

    @Test
    public void editarTest() {
        // Crear y guardar una especialidad válida
        Especialidad especialidad = new Especialidad();
        especialidad.setNombre("Cardiología");
        especialidad.setDescripcion("Especialidad del corazón");
        especialidad = especialidadServicio.crearEspecialidad(especialidad);

        // Crear y guardar un doctor válido
        Doctor doctor = new Doctor();
        doctor.setNombre("Dr. Juan");
        doctor.setCorreo("juan@correo.com");
        doctor.setTelefono("123456789");
        doctor.setEspecialidad(especialidad);
        doctor = doctorServicio.crearDoctor(doctor);

        // Editar el doctor
        doctor.setNombre("Dr. Pedro");
        doctor.setCorreo("pedro@correo.com");
        doctor.setTelefono("987654321");
        Doctor doctorEditado = doctorServicio.actualizarDoctor(doctor);

        assertNotNull(doctorEditado);
        assertEquals("Dr. Pedro", doctorEditado.getNombre());
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