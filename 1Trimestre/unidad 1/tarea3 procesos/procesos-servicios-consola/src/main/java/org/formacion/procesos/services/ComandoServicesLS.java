package org.formacion.procesos.services;

import org.formacion.procesos.domain.ProcessType;
import org.formacion.procesos.services.abstractas.ComandoServicesAbstractas;
import org.springframework.stereotype.Component;

@Component
public class ComandoServicesLS extends ComandoServicesAbstractas{

    public ComandoServicesLS(){
        setTipo(ProcessType.LS);
        setExpresionRegular("^((-(la|l|a))|\s*)$");
    }
}
