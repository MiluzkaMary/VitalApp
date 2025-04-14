package com.saludvital.test;

import com.saludvital.model.Resultados;
import com.saludvital.services.interfaces.ResultadosServicio;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ResultadosServicioTest {

    @Autowired
    private ResultadosServicio resultadosServicio;

    @Test
    public void crearResultadoTest() {
        Resultados resultado = new Resultados();
        resultado.setDescripcion("Resultado de prueba");
        resultado.setFechaEntrega(LocalDate.now());

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