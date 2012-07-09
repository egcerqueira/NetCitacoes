package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import net.sf.oval.constraint.MaxLength;

import play.data.validation.MaxSize;
import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
public class Citacao extends Model {
	
	@Required
	@MaxSize(1000)
	public String citacao;
	
	@Required
	public String autor;
	
	@OneToMany
	public List<Comentario> comentarios;
	
	public String toString(){
		return citacao;
	}
}
