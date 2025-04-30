package com.saludvital.test;

import com.saludvital.model.Doctor;
import com.saludvital.model.Paciente;
import com.saludvital.model.Resultados;
import com.saludvital.services.interfaces.DoctorServicio;
import com.saludvital.services.interfaces.PacienteServicio;
import com.saludvital.services.interfaces.ResultadosServicio;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
public class ResultadosServicioTest {

    @Autowired
    private ResultadosServicio resultadosServicio;


    @Autowired
    private PacienteServicio pacienteServicio;

    @Test
    public void crearResultadoTest() {
        // Crear y guardar un paciente válido
        Paciente paciente = new Paciente();
        paciente.setNombre("Carlos");
        paciente.setCorreo("carlos@email.com");
        paciente.setTelefono("123456789");
        paciente.setDireccion("Calle 123");
        paciente = pacienteServicio.crearPaciente(paciente);


        // Crear y guardar un resultado
        Resultados resultado = new Resultados();
        resultado.setDescripcion("Resultado de prueba");
        resultado.setFechaEntrega(LocalDate.now());
        resultado.setPaciente(paciente); // Asignar el paciente creado

        Resultados resultadoCreado = resultadosServicio.crearResultado(resultado);

        assertNotNull(resultadoCreado);
        assertEquals("Resultado de prueba", resultadoCreado.getDescripcion());
    }

    @Test
    public void listarResultadosTest() {
        List<Resultados> lista = resultadosServicio.listarResultados();

        assertNotNull(lista);
        assertFalse(lista.isEmpty());
    }

    @Test
    public void eliminarResultadoTest() {
        resultadosServicio.eliminarResultado(1);

        Resultados resultadoEliminado = resultadosServicio.obtenerResultadoPorId(1);
        assertNull(resultadoEliminado);
    }
}