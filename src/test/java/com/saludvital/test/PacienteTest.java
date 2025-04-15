package com.saludvital.test;

import com.saludvital.model.Paciente;
import com.saludvital.repositories.PacienteRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
public class PacienteTest {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Test
    public void registrarTest() {
        Paciente paciente = new Paciente();
        paciente.setNombre("Carlos");
        paciente.setCorreo("carlos@email.com");
        paciente.setTelefono("123456789");
        paciente.setDireccion("Calle 123");

        // Guardar
        Paciente pacienteCreado = pacienteRepository.save(paciente);

        // Verificar que no sea null
        assertNotNull(pacienteCreado);
        assertEquals("Carlos", pacienteCreado.getNombre());

        // Mensaje de éxito
        System.out.println("Test registro paciente exitoso");
    }

    @Test
    public void actualizarTest() {
        // Crear y guardar un paciente válido
        Paciente paciente = new Paciente();
        paciente.setNombre("Carlos");
        paciente.setCorreo("carlos@email.com");
        paciente.setTelefono("123456789");
        paciente.setDireccion("Calle 123");
        paciente = pacienteRepository.save(paciente);

        // Editar el paciente
        paciente.setNombre("María");
        paciente.setCorreo("maria@email.com");
        Paciente pacienteActualizado = pacienteRepository.save(paciente);

        // Verificar que los cambios se hayan aplicado
        assertNotNull(pacienteActualizado);
        assertEquals("María", pacienteActualizado.getNombre());
        assertEquals("maria@email.com", pacienteActualizado.getCorreo());

        // Mensaje de éxito
        System.out.println("Test actualización paciente exitoso");
    }

    @Test
    public void listarTodosTest() {
        // Crear y guardar un paciente válido
        Paciente paciente = new Paciente();
        paciente.setNombre("Carlos");
        paciente.setCorreo("carlos@email.com");
        paciente.setTelefono("123456789");
        paciente.setDireccion("Calle 123");
        pacienteRepository.save(paciente);

        // Consultar todos los pacientes
        List<Paciente> lista = pacienteRepository.findAll();

        // Verificar que la lista no esté vacía
        System.out.println("Tamaño de la lista: " + lista.size());
        assertFalse(lista.isEmpty());
    }

    @Test
    public void eliminarTest() {
        // Eliminar paciente por ID
        pacienteRepository.deleteById(1);

        // Verificar que el paciente fue eliminado
        Paciente pacienteEliminado = pacienteRepository.findById(1).orElse(null);
        assertNull(pacienteEliminado);

        // Mensaje de éxito
        System.out.println("Test eliminación paciente exitoso");
    }
}