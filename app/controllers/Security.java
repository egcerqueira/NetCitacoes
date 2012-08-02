package controllers;

import models.Usuario;

public class Security extends Secure.Security{
	
	static boolean authenticate(String email, String senha) {
        Usuario usuario = Usuario.find("byEmail", email).first();
        return usuario != null && usuario.senha.equals(senha);
    }
	
	 static boolean check(String perfil) {
        Usuario usuario = Usuario.find("byEmail", connected()).first();
        if ("admin".equals(perfil)) {
            return usuario.isAdmin;
        }
        else {
            return false;
        }
    }    

}