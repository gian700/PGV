package org.formacion.procesosservicios.service;

import org.formacion.procesos.services.ComandoServicesLsof;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class comandoServiceLSofTest {

    ComandoServicesLsof comandoServicesLsof;

    @BeforeEach
    void before(){
        comandoServicesLsof = new ComandoServicesLsof();
        comandoServicesLsof.setComando("lsof");
    }

    @Test
    void validarTest(){
        String[] arrayComando = {"lsof", "-"};
        boolean estado = comandoServicesLsof.validaComando(arrayComando);
        assertTrue(estado);
    }

    @Test
    void validarFalseTest(){
        String[] arrayComando = {"ls", "-laala"};
        boolean estado = comandoServicesLsof.validaComando(arrayComando);
        assertFalse(estado);
    }
}
