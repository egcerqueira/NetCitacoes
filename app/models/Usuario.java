package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import play.data.validation.Email;
import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
public class Usuario extends Model {

	@Required
	public String nome;
	
	@Required
	@Email
	public String email;
	
	@OneToMany
	public List<Citacao> citacoes;
	
	@Override
	public String toString() {
		return nome;
	}

}