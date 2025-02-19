package saucedemo.automation.runner;

import org.junit.runner.RunWith;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;
import saucedemo.automation.drivers.Drivers;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features = "src/test/resources/features",
		tags = "@login",
		glue = "saucedemo.automation.steps",
		dryRun = true,
		monochrome = true,
		plugin = {"pretty","html:target/cucumber-report.html"},
		snippets = SnippetType.CAMELCASE
		
		)


public class Executa extends Drivers{
	
	public void iniciaraTest() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		
		
	}

}
