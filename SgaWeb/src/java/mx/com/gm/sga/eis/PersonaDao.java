
package mx.com.gm.sga.eis;

import java.util.List;
import mx.com.gm.sga.domain.Persona;

public interface PersonaDao {
                        //implementamos este metodo
    public List<Persona> findAllPersonas();

	public Persona findPersonaById(Persona persona);

	public Persona findPersonaByEmail(Persona persona);

        //crud
	public void insertPersona(Persona persona);

	public void updatePersona(Persona persona);

	public void deletePersona(Persona persona);
}
