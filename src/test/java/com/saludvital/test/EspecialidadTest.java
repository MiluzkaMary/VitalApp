package com.saludvital.test;

import com.saludvital.model.Especialidad;
import com.saludvital.repositories.EspecialidadRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class EspecialidadTest {

    @Autowired
    private EspecialidadRepository especialidadRepository;

    @Test
    public void registrarTest() {
        Especialidad especialidad = new Especialidad();
        especialidad.setNombre("Cardiología");
        especialidad.setDescripcion("Especialidad del corazón");

        Especialidad especialidadCreada = especialidadRepository.save(especialidad);

        assertNotNull(especialidadCreada);
        assertEquals("Cardiología", especialidadCreada.getNombre());
    }

    @Test
    public void listarTodosTest() {
        List<Especialidad> lista = especialidadRepository.findAll();

        assertFalse(lista.isEmpty());
    }

    @Test
    public void eliminarTest() {
        especialidadRepository.deleteById(1);

        Especialidad especialidadEliminada = especialidadRepository.findById(1).orElse(null);
        assertNull(especialidadEliminada);
    }
}