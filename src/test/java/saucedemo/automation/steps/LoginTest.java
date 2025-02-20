package saucedemo.automation.steps;

import static org.junit.Assert.assertTrue;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import saucedemo.automation.drivers.Drivers;
import saucedemo.automation.metodos.Metodos;
import saucedemo.automation.pages.LoginPage;
import saucedemo.automation.runner.Executa;

public class LoginTest extends Drivers {

	LoginPage page = new LoginPage();
	Metodos metodos = new Metodos();

	@Before
	public void setUp() {
		Executa.iniciarTest();
	}

	@Given("que nao esteja logado")
	public void queNaoEstejaLogado() {
		driver.get("https://www.saucedemo.com/");
	}

	@When("preencher campo nome")
	public void preencherCampoNome() {
		metodos.preencher(page.nome, "standard_user");
	}

	@When("preencher senha")
	public void preencherSenha() {
		metodos.preencher(page.password, "secret_sauce");
	}

	@When("clicar no botao de login")
	public void clicarNoBotaoDeLogin() {
		metodos.clicar(page.btnLogin);
	}

	@Then("login realizado")
	public void loginRealizado() {
		assertTrue(driver.getCurrentUrl().contains("inventory"));
	}

	@When("preencher senha errada")
	public void preencherSenhaErrada() {
		metodos.preencher(page.password, "senhaErrada");
	}

	@Then("sistema exibe mensagem de erro")
	public void sistemaExibeMensagemDeErro() {
		String mensagemEsperada = "Epic sadface: Username and password do not match any user in this service";
		metodos.validarTexto(page.mensagemErro, mensagemEsperada);
	}

	@When("preencher campo user invalido")
	public void preencherCampoUserInvalido() {
		metodos.preencher(page.nome, "usuario_invalido");
	}

	@When("preencher senha valida")
	public void preencherSenhaValida() {
		metodos.preencher(page.password, "secret_sauce");
	}

	@When("preencher campo nome user bloqueado")
	public void preencherCampoNomeUserBloqueado() {
		metodos.preencher(page.nome, "locked_out_user");
	}

	@Then("sistema exibe mensagem de usuer bloqueado")
	public void sistemaExibeMensagemDeUsuerBloqueado() {
		String mensagemEsperada = "Epic sadface: Sorry, this user has been locked out.";
		metodos.validarTexto(page.mensagemErro, mensagemEsperada);
	}

	@After
	public void tearDown() {
		Executa.finalizarTest();
	}
}
