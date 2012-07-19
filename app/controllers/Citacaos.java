package controllers;

import java.util.List;
import play.data.validation.Required;
import play.data.validation.Valid;
import play.db.jpa.JPABase;
import models.Citacao;
import models.Comentario;
import models.Usuario;

public class Citacaos extends CRUD {

	public static void listarComentarios(Long id) {
		Citacao citacao = Citacao.findById(id);
		if(citacao != null){
			List<Comentario> comentarios = citacao.comentarios;
			render(citacao, comentarios);
		}
		Application.index();
	}
	
	public static void criar(Citacao citacao) {
		List<Usuario> usuarios = Usuario.findAll();
		render(citacao,usuarios);
	}
	
	public static void salvar(@Valid Citacao citacao) {
		citacao.save();
		Application.index();
	}
}
