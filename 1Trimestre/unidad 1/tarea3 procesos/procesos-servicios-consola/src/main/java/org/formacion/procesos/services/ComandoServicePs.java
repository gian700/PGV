package org.formacion.procesos.services;

import org.formacion.procesos.domain.ProcessType;
import org.formacion.procesos.services.abstractas.ComandoServicesAbstractas;
import org.springframework.stereotype.Component;

@Component
public class ComandoServicePs extends ComandoServicesAbstractas{

    public ComandoServicePs(){
        setTipo(ProcessType.PS);
        setExpresionRegular("^((-?(xa|x|a|aux|ef|l|))|\s*)$");
    }
}
