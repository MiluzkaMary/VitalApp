package com.saludvital.test;

import com.saludvital.model.Resultados;
import com.saludvital.model.Paciente;
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

    @Test
    public void registrarTest() {
        Resultados resultado = new Resultados();
        resultado.setDescripcion("Resultado de prueba");
        resultado.setFechaEntrega(LocalDate.now());
        resultado.setPaciente(new Paciente()); // Asignar un paciente válido

        Resultados resultadoCreado = resultadosRepository.save(resultado);

        assertNotNull(resultadoCreado);
        assertEquals("Resultado de prueba", resultadoCreado.getDescripcion());
    }

    @Test
    public void listarTodosTest() {
        List<Resultados> lista = resultadosRepository.findAll();

        assertFalse(lista.isEmpty());
    }

    @Test
    public void eliminarTest() {
        resultadosRepository.deleteById(1);

        Resultados resultadoEliminado = resultadosRepository.findById(1).orElse(null);
        assertNull(resultadoEliminado);
    }
}