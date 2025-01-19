package pruebas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
//Importamos paginas
import paginas.paginaLogin;

//Aca se hacen los test con los locators definidos en paginaLogin
//Se hace todo aca para que no haya redundancia de código


//MODO INCOGNITO se usa una pagina que tenga https

public class PracticaM6TestAlertas {

	String url="https://practice.automationtesting.in/";
	WebDriver driver;
	//Definimos una instancia de tipo login
	paginaLogin login;


	@BeforeMethod
	public void setUP() {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		
		//IGNORAR LOS CERTIFICADOS
		options.addArguments("--ignore-certificate-errors");
		//MODO INCOGNITO
		options.addArguments("--incognito");
		
		
		driver= new ChromeDriver(options);
		
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}

	@Test()
	public void TestLogo() {
		WebElement linkTitulo=driver.findElement(By.linkText("Automation Practice Site"));
		linkTitulo.click();
	}


	@AfterMethod
	public void tearDown() {
		driver.quit();
	}


}
