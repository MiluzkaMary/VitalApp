package com.saludvital.test;

import com.saludvital.model.Paciente;
import com.saludvital.services.interfaces.PacienteServicio;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PacienteServicioTest {

    @Autowired
    private PacienteServicio pacienteServicio;

    @Test
    public void crearPacienteTest() {
        Paciente paciente = new Paciente();
        paciente.setNombre("Camilo");
        paciente.setCorreo("camilo@email.com");
        paciente.setTelefono("987654321");
        paciente.setDireccion("Calle 456");

        // Crear paciente
        Paciente pacienteCreado = pacienteServicio.crearPaciente(paciente);

        // Verificar que no sea null
        assertNotNull(pacienteCreado);
        assertEquals("Camilo", pacienteCreado.getNombre());
    }

    @Test
    public void obtenerPacientePorIdTest() {
        // Obtener paciente por ID
        Paciente paciente = pacienteServicio.obtenerPacientePorId(1);

        // Verificar que no sea null
        assertNotNull(paciente);
        assertEquals(1, paciente.getId());
    }

    @Test
    public void listarPacientesTest() {
        List<Paciente> lista = pacienteServicio.listarPacientes();

        // Verificar que la lista no esté vacía
        assertFalse(lista.isEmpty());
    }

    @Test
    public void actualizarPacienteTest() {
        // Obtener paciente por ID
        Paciente paciente = pacienteServicio.obtenerPacientePorId(1);
        paciente.setNombre("Luis");
        paciente.setCorreo("luis@email.com");

        // Actualizar paciente
        Paciente pacienteActualizado = pacienteServicio.actualizarPaciente(paciente);

        // Verificar actualización
        assertEquals("Luis", pacienteActualizado.getNombre());
        assertEquals("luis@email.com", pacienteActualizado.getCorreo());
    }

    @Test
    public void eliminarPacienteTest() {
        // Eliminar paciente por ID
        pacienteServicio.eliminarPaciente(1);

        // Verificar que el paciente fue eliminado
        Paciente pacienteEliminado = pacienteServicio.obtenerPacientePorId(1);
        assertNull(pacienteEliminado);
    }
}