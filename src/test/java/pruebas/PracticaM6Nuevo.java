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


//MANEJO DE ALERTAS

public class PracticaM6Nuevo {

	String url="https://demoqa.com/alerts";
	WebDriver driver;
	//Definimos una instancia de tipo login
	paginaLogin login;


	@BeforeMethod
	public void setUP() {

		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();

		//Usamos un zoom al 80% para hacer click en el botón que queremos hacer click 
		double zoom = 0.8; 
		options.addArguments("--force-device-scale-factor="+zoom);
		driver= new ChromeDriver(options);
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
		//driver.quit();
	}


}
