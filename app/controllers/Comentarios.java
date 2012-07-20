package controllers;

import java.util.List;
import models.Comentario;
import play.mvc.Controller;
import play.i18n.Messages;
import play.data.validation.Validation;
import play.data.validation.Valid;


public class Comentarios extends Controller {
	public static void index() {
		List<Comentario> entities = models.Comentario.all().fetch();
		render(entities);
	}

	public static void create(Comentario entity) {
		render(entity);
	}

	public static void show(java.lang.Long id) {
    Comentario entity = Comentario.findById(id);
		render(entity);
	}

	public static void edit(java.lang.Long id) {
    Comentario entity = Comentario.findById(id);
		render(entity);
	}

	public static void delete(java.lang.Long id) {
    Comentario entity = Comentario.findById(id);
    entity.delete();
		index();
	}
	
	public static void save(@Valid Comentario entity) {
		if (validation.hasErrors()) {
			flash.error(Messages.get("scaffold.validation"));
			render("@create", entity);
		}
    entity.save();
		flash.success(Messages.get("scaffold.created", "Comentario"));
		index();
	}

	public static void update(@Valid Comentario entity) {
		if (validation.hasErrors()) {
			flash.error(Messages.get("scaffold.validation"));
			render("@edit", entity);
		}
		
      		entity = entity.merge();
		
		entity.save();
		flash.success(Messages.get("scaffold.updated", "Comentario"));
		index();
	}

}
