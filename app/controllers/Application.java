package controllers;

import play.mvc.Controller;

public class Application extends Controller {

	public static void index() {

		 String user = Security.connected();

	     render(user);

	}

	public static void sair() throws Throwable {

		Secure.logout();

		index();

	}

}
