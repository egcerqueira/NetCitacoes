package models;

import javax.persistence.Entity;

import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
public class Comentario extends Model {
	
	@Required
	public String nome;
	
	@Required
	public String comentario;
	
	@Override
	public String toString() {
		return nome.concat(" - ").concat(comentario);
	}
}
