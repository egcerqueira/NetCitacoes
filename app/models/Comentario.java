package models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
public class Comentario extends Model {
	
	@Required
	public String nome;
	
	@Required
	public String comentario;
	
	@ManyToOne
    public Citacao citacao;
	
	@Override
	public String toString() {
		return nome.concat(" - ").concat(comentario);
	}
}
