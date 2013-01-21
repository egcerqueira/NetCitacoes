package controllers;

import java.util.List;

import models.Usuario;
import play.data.validation.Valid;
import play.i18n.Messages;
import play.mvc.Before;
import play.mvc.Controller;
import play.mvc.With;
import controllers.securesocial.SecureSocial;

@With(SecureSocial.class)
public class Usuarios extends Controller {

	@Before
	static void user() {
	}

	public static void index() {
		List<Usuario> entities = models.Usuario.all().fetch();
		render(entities);
	}

	public static void create(Usuario entity) {
		render(entity);
	}

	public static void show(java.lang.Long id) {
    Usuario entity = Usuario.findById(id);
		render(entity);
	}

	public static void edit(java.lang.Long id) {
    Usuario entity = Usuario.findById(id);
		render(entity);
	}

	public static void delete(java.lang.Long id) {
    Usuario entity = Usuario.findById(id);
    entity.delete();
		index();
	}

	public static void save(@Valid Usuario entity) {
		if (validation.hasErrors()) {
			flash.error(Messages.get("scaffold.validation"));
			render("@create", entity);
		}
    entity.save();
		flash.success(Messages.get("scaffold.created", "Usuario"));
		index();
	}

	public static void update(@Valid Usuario entity) {
		if (validation.hasErrors()) {
			flash.error(Messages.get("scaffold.validation"));
			render("@edit", entity);
		}

      		entity = entity.merge();

		entity.save();
		flash.success(Messages.get("scaffold.updated", "Usuario"));
		index();
	}

}
