/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.beans;

/**
 *
 * @author erick.medina
 */
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.primefaces.event.RowEditEvent;
import mx.com.gm.sga.domain.Persona;
import mx.com.gm.sga.servicio.PersonaService;

@ManagedBean(name = "personaBean")
@RequestScoped
public class PersonaBEan {
    
       @EJB
    private PersonaService personaService;

    private Persona personaSeleccionada;

    List<Persona> personas;

    public PersonaBEan() {
    }

    @PostConstruct
    public void inicializar() {
        //Iniciamos las variables
        personas = personaService.listarPersonas();
        personaSeleccionada = new Persona();
    }

    public void editListener(RowEditEvent event) {
        Persona persona = (Persona) event.getObject();
        personaService.modificarPersona(persona);
    }

    public List<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }

    public Persona getPersonaSeleccionada() {
        return personaSeleccionada;
    }

    public void setPersonaSeleccionada(Persona personaSeleccionada) {
        this.personaSeleccionada = personaSeleccionada;
    }
    
    public void reiniciarPersonaSeleccionada(){
        this.personaSeleccionada = new Persona();
    }

    public void agregarPersona() {
        personaService.registrarPersona(this.personaSeleccionada);
        this.personaSeleccionada = null;
    }

    public void eliminarPersona() {
        personaService.eliminarPersona(this.personaSeleccionada);
        this.personaSeleccionada = null;
    }

}
