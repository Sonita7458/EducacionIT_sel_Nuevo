package eduit.EducacionIT_sel_Nuevo;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class PracticaM3TestNuevo {
	
	WebDriver driver;
	String url="http://www.automationpractice.pl/";
	String urlAuthentication="http://www.automationpractice.pl/index.php?controller=my-account";
	
	
	@BeforeMethod
	public void setUP() {
		
		driver = new EdgeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}

	@Test(priority=1)
	public void registrarUsuario() {
		//(3) Hacer clic en 'Sign in'	
		WebElement lnkSign=driver.findElement(By.partialLinkText("Sign"));
		lnkSign.click();	

		//(4) Escribir el correo electronico
		WebElement txtEmail=driver.findElement(By.id("email_create"));
		txtEmail.sendKeys("correo05dic"+Math.random()+"@gmail.com");

		//(5) Hacer clic en 'Create an account'
		WebElement btnCreate=driver.findElement(By.name("SubmitCreate"));
		btnCreate.click();

		//Necesitamos agregar una espera de X tiempo o hasta que el radio button se cargue
		WebDriverWait espera=new WebDriverWait(driver,Duration.ofSeconds(30));
		espera.until(ExpectedConditions.elementToBeClickable(By.id("id_gender1")));

		//(6)Seleccionar Sr. o Sra
		WebElement radTitulo=driver.findElement(By.id("id_gender1"));
		radTitulo.click();


		//(7) Escribir el nombre
		WebElement txtNombre=driver.findElement(By.id("customer_firstname"));
		txtNombre.sendKeys("Bruno");

		//(8) Escribir el apellido
		WebElement txtApellido=driver.findElement(By.cssSelector("#customer_lastname"));
		txtApellido.sendKeys("Cura");

		//(9) Limpiar el valor del correo electronico
		WebElement txtEmailForm=driver.findElement(By.id("email"));
		txtEmailForm.clear();

		//(10) Escribir un nuevo valor de correo electronico
		txtEmailForm.sendKeys("correoModificado05dic"+Math.random()+"@gmail.com");

		//(11) Escribir la contraseña
		WebElement txtPasswordForm=driver.findElement(By.name("passwd"));
		txtPasswordForm.clear();
		txtPasswordForm.sendKeys("123456");

		//(12) Seleccionar la fecha de nacimiento(día-mes-año)

		Select drpDaysForm=new Select(driver.findElement(By.id("days")));

		drpDaysForm.selectByValue("19");

		Select drpMonthsForm=new Select(driver.findElement(By.id("months")));

		drpMonthsForm.selectByValue("7");

		Select drpYearForm=new Select(driver.findElement(By.id("years")));

		drpYearForm.selectByValue("2012"); 

		//(13) Hacer clic en checkbox

		WebElement chkNewsletter=driver.findElement(By.name("newsletter"));
		chkNewsletter.click();

		//(14) Hacer clic en boton 'Register'
		WebElement btnRegister=driver.findElement(By.id("submitAccount"));
		btnRegister.click();

		//Ver por Console el contenido de la variable
		System.out.println(urlAuthentication);
		System.out.println(driver.getCurrentUrl());

		//(18) Confirmacion de la cuenta
		Assert.assertEquals(urlAuthentication,driver.getCurrentUrl());

	}
	
	@Test(priority=2)
	public void registrarOtroUsuario() {
		//(3) Hacer clic en 'Sign in'	
		WebElement lnkSign=driver.findElement(By.partialLinkText("Sign"));
		lnkSign.click();	

		//(4) Escribir el correo electronico
		WebElement txtEmail=driver.findElement(By.id("email_create"));
		txtEmail.sendKeys("correo05dic"+Math.random()+"@gmail.com");

		//(5) Hacer clic en 'Create an account'
		WebElement btnCreate=driver.findElement(By.name("SubmitCreate"));
		btnCreate.click();

		//Necesitamos agregar una espera de X tiempo o hasta que el radio button se cargue
		WebDriverWait espera=new WebDriverWait(driver,Duration.ofSeconds(30));
		espera.until(ExpectedConditions.elementToBeClickable(By.id("id_gender2")));

		//(6)Seleccionar Sr. o Sra
		WebElement radTitulo=driver.findElement(By.id("id_gender2"));
		radTitulo.click();


		//(7) Escribir el nombre
		WebElement txtNombre=driver.findElement(By.id("customer_firstname"));
		txtNombre.sendKeys("Sonia");

		//(8) Escribir el apellido
		WebElement txtApellido=driver.findElement(By.cssSelector("#customer_lastname"));
		txtApellido.sendKeys("Grimau");

		//(9) Limpiar el valor del correo electronico
		WebElement txtEmailForm=driver.findElement(By.id("email"));
		txtEmailForm.clear();

		//(10) Escribir un nuevo valor de correo electronico
		txtEmailForm.sendKeys("correoModificado05dic"+Math.random()+"@gmail.com");

		//(11) Escribir la contraseña
		WebElement txtPasswordForm=driver.findElement(By.name("passwd"));
		txtPasswordForm.clear();
		txtPasswordForm.sendKeys("123456");

		//(12) Seleccionar la fecha de nacimiento(día-mes-año)

		Select drpDaysForm=new Select(driver.findElement(By.id("days")));

		drpDaysForm.selectByValue("8");

		Select drpMonthsForm=new Select(driver.findElement(By.id("months")));

		drpMonthsForm.selectByValue("9");

		Select drpYearForm=new Select(driver.findElement(By.id("years")));

		drpYearForm.selectByValue("1978"); 

		//(13) Hacer clic en checkbox

		WebElement chkNewsletter=driver.findElement(By.name("newsletter"));
		chkNewsletter.click();

		//(14) Hacer clic en boton 'Register'
		WebElement btnRegister=driver.findElement(By.id("submitAccount"));
		btnRegister.click();

		//Ver por Console el contenido de la variable
		System.out.println(urlAuthentication);
		System.out.println(driver.getCurrentUrl());

		//(18) Confirmacion de la cuenta
		Assert.assertEquals(urlAuthentication,driver.getCurrentUrl());

	}
	
	@AfterMethod 
	public void CapturaPantalla() throws IOException { 
		//(19) Captura de Pantalla 
		File Screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
		FileUtils.copyFile(Screen,new File("..\\EducacionIT_sel_Nuevo\\Evidencias\\pantalla"+System.currentTimeMillis()+".png")); 
	}
	
	@AfterMethod
	public void cierreNavegador() {
		if (driver!=null) {
		driver.quit();
		}
	}

}
