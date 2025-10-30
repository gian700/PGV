package org.formacion.procesos.services;

import org.formacion.procesos.domain.ProcessType;
import org.formacion.procesos.services.abstractas.ComandoServicesAbstractas;
import org.springframework.stereotype.Component;

@Component
public class ComandoServicesTop extends ComandoServicesAbstractas{

    public ComandoServicesTop(){
        setTipo(ProcessType.TOP);
        setExpresionRegular("^((-(bn1))|\s*)$");
    }
}
