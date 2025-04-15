package com.saludvital.test;

import com.saludvital.model.Paciente;
import com.saludvital.services.interfaces.PacienteServicio;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
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
        // Crear y guardar un paciente
        Paciente paciente = new Paciente();
        paciente.setNombre("Camilo");
        paciente.setCorreo("camilo@email.com");
        paciente.setTelefono("987654321");
        paciente.setDireccion("Calle 456");
        Paciente pacienteCreado = pacienteServicio.crearPaciente(paciente);

        // Obtener paciente por ID
        Paciente pacienteObtenido = pacienteServicio.obtenerPacientePorId(pacienteCreado.getId());

        // Verificar que no sea null
        assertNotNull(pacienteObtenido);
        assertEquals(pacienteCreado.getId(), pacienteObtenido.getId());
    }

    @Test
    public void listarPacientesTest() {
        List<Paciente> lista = pacienteServicio.listarPacientes();

        // Verificar que la lista no esté vacía
        assertFalse(lista.isEmpty());
    }

    @Test
    public void actualizarPacienteTest() {
        // Crear y guardar un paciente válido
        Paciente paciente = new Paciente();
        paciente.setNombre("Carlos");
        paciente.setCorreo("carlos@email.com");
        paciente.setTelefono("123456789");
        paciente.setDireccion("Calle 123");
        Paciente pacienteCreado = pacienteServicio.crearPaciente(paciente);

        // Editar el paciente
        pacienteCreado.setNombre("María");
        pacienteCreado.setCorreo("maria@email.com");
        Paciente pacienteActualizado = pacienteServicio.actualizarPaciente(pacienteCreado);

        // Verificar que los cambios se hayan aplicado
        assertNotNull(pacienteActualizado);
        assertEquals("María", pacienteActualizado.getNombre());
        assertEquals("maria@email.com", pacienteActualizado.getCorreo());
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