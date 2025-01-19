package pruebas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
//Importamos paginas
import paginas.paginaLogin;

//Aca se hacen los test con los locators definidos en paginaLogin
//Se hace todo aca para que no haya redundancia de código

public class PracticaM5TestNuevo {

	String url="http://www.automationpractice.pl/index.php?controller=authentication&back=my-account";
	WebDriver driver;
	//Definimos una instancia de tipo login
	paginaLogin login;


	@BeforeMethod
	public void setUP() {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		//Argumento del navegador sin cabeza, se corre en segundo plano la automatización.Va a correr mas rapido la automatizacion con ese options
		options.addArguments("--headless");
		driver= new ChromeDriver(options);
		
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}

	@Test(dataProvider="Datos Login")
	public void loginUser(String email, String password) {
		//Instaciamos la paginaLogin y le pasamos el driver, este crea la instancia y nos permite trabajar con los objetos.
		login= new paginaLogin(driver);
		//Llama al método Ingresar datos
		
		login.ingresarDatos(email,password);
		
		//Agregamos la aserción para corroborar que estamos en la página de Authentication
		//Llamamos al método que nos devolvía el texto y lo comparamos con el texto que necesitamos
		//AUTHENTICATION DEBE SER SI O SI EN MAYUSCULAS? PORQUE EN EL INSPECT SALE EN MINUSCULAS
		Assert.assertEquals(login.getTittleForm(),"AUTHENTICATION");

	}

	@DataProvider(name="Datos Login")
	public Object[][]getData(){

		//Fila y Columna

		Object [][]data=new Object [3][2];
		data[0][0] ="sonia1@gmail.com"; data[0][1] ="1230";
		data[1][0] ="sonia2@gmail.com"; data[1][1] ="4556";
		data[2][0] ="sonia3@gmail.com"; data[2][1] ="5265";

		return data;
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}


}
