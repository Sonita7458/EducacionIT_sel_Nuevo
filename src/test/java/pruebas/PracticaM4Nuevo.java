package pruebas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
//Importamos paginas
import paginas.paginaLogin;

//Aca se hacen los test con los locators definidos en paginaLogin
//Se hace todo aca para que no haya redundancia de código

public class PracticaM4Nuevo {

	String url="http://www.automationpractice.pl/index.php?controller=authentication&back=my-account";
	WebDriver driver;
	//Definimos una instancia de tipo login
	paginaLogin login;


	@BeforeSuite
	public void setUP() {
		driver= new EdgeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}

	@Test
	public void loginUser() {
		//Instaciamos la paginaLogin y le pasamos el driver, este crea la instancia y nos permite trabajar con los objetos.
		login= new paginaLogin(driver);
		//Llama al método Ingresar datos
		login.ingresarDatos("sonia2552@gmail.com","123456");
		//Agregamos la aserción para corroborar que estamos en la página de Authentication
		//Llamamos al método que nos devolvía el texto y lo comparamos con el texto que necesitamos
		//AUTHENTICATION DEBE SER SI O SI EN MAYUSCULAS? PORQUE EN EL INSPECT SALE EN MINUSCULAS
		Assert.assertEquals(login.getTittleForm(),"AUTHENTICATION");

	}

	@AfterSuite
	public void tearDown() {
		driver.quit();
	}


}
