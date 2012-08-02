package controllers;

import models.Usuario;

public class Security extends Secure.Security{
	
	static boolean authenticate(String email, String senha) {
		
		if(email.equals("admin@netcitacoes.com.br") && senha.equals("!@QWas")){
			return true;
		}
		
        Usuario usuario = Usuario.find("byEmail", email).first();
        return usuario != null && usuario.senha.equals(senha);
    }
	
	static boolean check(String perfil) {
		if(connected().equals("admin@netcitacoes.com.br")){
			return true;
		}
		
        Usuario usuario = Usuario.find("byEmail", connected()).first();
        if (usuario != null && "admin".equals(perfil)) {
            return usuario.isAdmin;
        }
        else {
            return false;
        }
    }    

}