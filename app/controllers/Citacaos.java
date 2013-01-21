package controllers;

import java.util.List;
import models.Citacao;
import play.mvc.Before;
import play.mvc.Controller;
import play.i18n.Messages;
import play.data.validation.Validation;
import play.data.validation.Valid;

public class Citacaos extends Controller {

	@Before
	static void user() {
	}

	public static void index() {
		List<Citacao> entities = models.Citacao.all().fetch();
		render(entities);
	}

	public static void create(Citacao entity) {
		render(entity);
	}

	public static void show(java.lang.Long id) {
    Citacao entity = Citacao.findById(id);
		render(entity);
	}

	public static void edit(java.lang.Long id) {
    Citacao entity = Citacao.findById(id);
		render(entity);
	}

	public static void delete(java.lang.Long id) {
    Citacao entity = Citacao.findById(id);
    entity.delete();
		index();
	}

	public static void save(@Valid Citacao entity) {
		if (validation.hasErrors()) {
			flash.error(Messages.get("scaffold.validation"));
			render("@create", entity);
		}
    entity.save();
		flash.success(Messages.get("scaffold.created", "Citacao"));
		index();
	}

	public static void update(@Valid Citacao entity) {
		if (validation.hasErrors()) {
			flash.error(Messages.get("scaffold.validation"));
			render("@edit", entity);
		}

      		entity = entity.merge();

		entity.save();
		flash.success(Messages.get("scaffold.updated", "Citacao"));
		index();
	}

}
