package pruebas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
//Importamos paginas
import paginas.paginaLogin;


//MANEJO DE ALERTAS

public class PracticaM6Test2Nuevo {

	String url="https://demo.guru99.com/test/upload/";
	WebDriver driver;
	//Definimos una instancia de tipo login
	paginaLogin login;


	@BeforeMethod
	public void setUP() {
		
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}

	@Test()
	public void cargarArchivo() {

		WebElement rutaArchivo=driver.findElement(By.id("uploadfile_0"));
		rutaArchivo.sendKeys("C:\\Users\\Sonia\\eclipse-workspace\\EducacionIT_sel_Nuevo\\prueba.txt");
	}

	@AfterMethod
	public void tearDown() {
		//Se comenta para que se vea el mensaje
		driver.quit();
	}


}
