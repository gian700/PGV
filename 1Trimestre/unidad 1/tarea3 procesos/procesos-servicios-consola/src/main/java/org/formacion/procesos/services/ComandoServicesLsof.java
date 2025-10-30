package org.formacion.procesos.services;

import org.formacion.procesos.domain.ProcessType;
import org.formacion.procesos.services.abstractas.ComandoServicesAbstractas;
import org.springframework.stereotype.Component;

@Component
public class ComandoServicesLsof extends ComandoServicesAbstractas{

    public ComandoServicesLsof(){
        setTipo(ProcessType.LSOF);
        setExpresionRegular("^((-(i))|\s*)$");
    }
}
