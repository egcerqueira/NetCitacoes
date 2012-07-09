package controllers;

import java.util.List;

import play.db.jpa.JPABase;

import models.Citacao;
import models.Usuario;

public class Application extends CRUD {

    public static void index() {
    	List<Usuario> usuarios = Usuario.findAll();
        render(usuarios);
    }
    
    public static void salvar(Citacao citacao) {
    	citacao.save();
    	index();
    }

}