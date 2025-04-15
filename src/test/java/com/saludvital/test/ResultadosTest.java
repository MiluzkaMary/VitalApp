package com.saludvital.test;

import com.saludvital.model.Doctor;
import com.saludvital.model.Paciente;
import com.saludvital.model.Resultados;
import com.saludvital.repositories.DoctorRepository;
import com.saludvital.repositories.PacienteRepository;
import com.saludvital.repositories.ResultadosRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ResultadosTest {

    @Autowired
    private ResultadosRepository resultadosRepository;


    @Autowired
    private PacienteRepository pacienteRepository;

    @Test
    public void registrarTest() {
        // Crear y guardar un paciente válido
        Paciente paciente = new Paciente();
        paciente.setNombre("Carlos");
        paciente.setCorreo("carlos@email.com");
        paciente.setTelefono("123456789");
        paciente.setDireccion("Calle 123");
        paciente = pacienteRepository.save(paciente);


        // Crear y guardar un resultado
        Resultados resultado = new Resultados();
        resultado.setDescripcion("Resultado de prueba");
        resultado.setFechaEntrega(LocalDate.now());
        resultado.setPaciente(paciente); // Asignar el paciente creado


        Resultados resultadoCreado = resultadosRepository.save(resultado);

        assertNotNull(resultadoCreado);
        assertEquals("Resultado de prueba", resultadoCreado.getDescripcion());
    }

    @Test
    public void listarTodosTest() {
        // Crear y guardar un paciente válido
        Paciente paciente = new Paciente();
        paciente.setNombre("Carlos");
        paciente.setCorreo("carlos@email.com");
        paciente.setTelefono("123456789");
        paciente.setDireccion("Calle 123");
        paciente = pacienteRepository.save(paciente);

        // Crear y guardar un resultado
        Resultados resultado = new Resultados();
        resultado.setDescripcion("Resultado de prueba");
        resultado.setFechaEntrega(LocalDate.now());
        resultado.setPaciente(paciente);
        resultadosRepository.save(resultado);

        // Consultar todos los resultados
        List<Resultados> lista = resultadosRepository.findAll();

        // Verificar que la lista no esté vacía
        System.out.println("Tamaño de la lista: " + lista.size());
        assertFalse(lista.isEmpty());
    }

    @Test
    public void eliminarTest() {
        resultadosRepository.deleteById(1);

        Resultados resultadoEliminado = resultadosRepository.findById(1).orElse(null);
        assertNull(resultadoEliminado);
    }
}