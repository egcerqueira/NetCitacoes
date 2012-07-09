package controllers;

import java.util.List;

import play.db.jpa.JPABase;
import models.Citacao;
import models.Comentario;

public class Citacaos extends CRUD {

	public static void listarComentarios(Long id) {
		Citacao citacao = Citacao.findById(id);
		List<Comentario> comentarios = citacao.comentarios;
		render(citacao, comentarios);
	}
}
