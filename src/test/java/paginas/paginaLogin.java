package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


//Clase a donde van los objetos y los métodos y en PracticaM4Nuevo se hacen los tests
//Este es el patrón de diseño

public class paginaLogin {

	WebDriver driver;

	//Locators
	By emailField=By.id("email");
	By passwordField=By.id("passwd");
	By loginButton=By.id("SubmitLogin");
	By titleForm=By.xpath("//h1[contains(text(),'Authentication')]");

	//Constructor que iniciliza el Web driver
	public paginaLogin(WebDriver driver) {
		this.driver=driver;

	}

	//Método para ingresar los datos
	public void ingresarDatos(String email,String password) {

		driver.findElement(emailField).sendKeys(email);
		driver.findElement(passwordField).sendKeys(password);
		driver.findElement(loginButton).click();
	}

	//Método para obtener Titulo

	public String getTittleForm() {

		return driver.findElement(titleForm).getText();
	}
}
