package org.formacion.procesosservicios.service;

import org.formacion.procesos.services.ComandoServicePs;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ComandoServicesPSTest {

    ComandoServicePs comandoServicesPs;

    @BeforeEach
    void before(){
        comandoServicesPs = new ComandoServicePs();
        comandoServicesPs.setComando("ps");
    }

    @Test
    void validarTest(){
        String[] arrayComando = {"ps", "a"};
        boolean estado = comandoServicesPs.validaComando(arrayComando);
        assertTrue(estado);
    }

    @Test
    void validarMenosTest(){
        String[] arrayComando = {"ps", "-aux"};
        boolean estado = comandoServicesPs.validaComando(arrayComando);
        assertTrue(estado);
    }

    @Test
    void validarFalseTest(){
        String[] arrayComando = {"ps", "geiohdoi"};
        boolean estado = comandoServicesPs.validaComando(arrayComando);
        assertFalse(estado);
    }
}
