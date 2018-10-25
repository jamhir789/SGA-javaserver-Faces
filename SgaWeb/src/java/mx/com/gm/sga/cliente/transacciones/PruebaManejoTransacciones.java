/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.cliente.transacciones;




import javax.naming.Context;
import javax.naming.InitialContext;
import mx.com.gm.sga.domain.Persona;
import mx.com.gm.sga.servicio.PersonaserviceRemote;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PruebaManejoTransacciones {

    static Logger log = LogManager.getRootLogger();

    public static void main(String[] args) throws Exception {
        Context jndi = new InitialContext();
        PersonaserviceRemote personaService = (PersonaserviceRemote) jndi.lookup("java:global/sga-jee/PersonaServiceImpl!mx.com.gm.sga.servicio.PersonaserviceRemote");

        log.debug("Iniciando prueba Manejo Transaccional PersonaService");

        //Buscamos un objeto persona
        Persona persona1 = personaService.encontrarPersonaPorId(new Persona(1));

        //Cambiamos la persona
        //persona1.setApellidoMaterno("Cambio con error....................................................................");
        persona1.setApellidoMaterno("Cambio sin errror");

        personaService.modificarPersona(persona1);

        log.debug("Objeto modificado:" + persona1);
        log.debug("Fin prueba EJB PersonaService");

    }
}













/**
 *
 * @author erick.medina
 
 * 
 * Causamos un rollback de esta forma obtenedemos error que resulta en una transaccion abortada

import javax.naming.Context;
import javax.naming.InitialContext;
import mx.com.gm.sga.domain.Persona;
import mx.com.gm.sga.servicio.PersonaserviceRemote;
public class PruebaManejoTransacciones {
    
    public static void main(String[] args) throws Exception {
        Context jndi = new InitialContext();
        PersonaserviceRemote personaService = (PersonaserviceRemote) jndi.lookup("java:global/sga-jee/PersonaServiceImpl!mx.com.gm.sga.servicio.PersonaserviceRemote");
        System.out.println("Iniciando prueba Manejo Transaccional PersonaService");

        //Buscamos un objeto persona
        Persona persona1 = personaService.encontrarPersonaPorId(new Persona(1));

        //Cambiamos la persona
        persona1.setApellidoMaterno("Cambio con error....................................................................");
        //persona1.setApellidoMaterno("Cambio sin errror");

        personaService.modificarPersona(persona1);
        System.out.println("Objeto modificado:" + persona1);
        System.out.println("Fin prueba EJB PersonaService");
    }
}
*/