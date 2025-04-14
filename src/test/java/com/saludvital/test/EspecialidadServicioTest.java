package com.saludvital.test;

import com.saludvital.model.Especialidad;
import com.saludvital.services.interfaces.EspecialidadServicio;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class EspecialidadServicioTest {

    @Autowired
    private EspecialidadServicio especialidadServicio;

    @Test
    public void crearEspecialidadTest() {
        Especialidad especialidad = new Especialidad();
        especialidad.setNombre("Cardiología");
        especialidad.setDescripcion("Especialidad del corazón");

        Especialidad especialidadCreada = especialidadServicio.crearEspecialidad(especialidad);

        assertNotNull(especialidadCreada);
        assertEquals("Cardiología", especialidadCreada.getNombre());
    }

    @Test
    public void listarEspecialidadesTest() {
        List<Especialidad> lista = especialidadServicio.listarEspecialidades();

        assertNotNull(lista);
        assertFalse(lista.isEmpty());
    }

    @Test
    public void eliminarEspecialidadTest() {
        especialidadServicio.eliminarEspecialidad(1);

        Especialidad especialidadEliminada = especialidadServicio.obtenerEspecialidadPorId(1);
        assertNull(especialidadEliminada);
    }
}