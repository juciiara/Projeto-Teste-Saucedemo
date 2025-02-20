package saucedemo.automation.pages;

import org.openqa.selenium.By;

import saucedemo.automation.drivers.Drivers;
import saucedemo.automation.metodos.Metodos;

public class LoginPage extends Drivers {

	public By nome = By.id("user-name");
	public By password = By.id("password");
	public By btnLogin = By.id("login-button");
	public By mensagemErro = By.cssSelector(".error-message-container");

	Metodos mt = new Metodos();


	public void LoginComSucesso(String usuario, String senha) {
		mt.preencher(nome, usuario);
	    mt.preencher(password, senha);
	    mt.clicar(btnLogin);
	}

	public void LoginSenhaInvalida(String usuario, String senha) {
		mt.preencher(nome, usuario);
	    mt.preencher(password, senha);
	    mt.clicar(btnLogin);
	}

	public void LoginComUsuárioInválido(String usuario, String senha) {
		mt.preencher(nome, usuario);
	    mt.preencher(password, senha);
	    mt.clicar(btnLogin);
	}

	public void LoginComUsuárioBloqueado(String usuario, String senha) {
		mt.preencher(nome, usuario);
	    mt.preencher(password, senha);
	    mt.clicar(btnLogin);
	}

	public boolean loginFoiRealizado() {
	    return false;
	}


}
