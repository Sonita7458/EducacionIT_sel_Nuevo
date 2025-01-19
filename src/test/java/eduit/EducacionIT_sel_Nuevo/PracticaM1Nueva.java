package eduit.EducacionIT_sel_Nuevo;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PracticaM1Nueva {

	String url = "http://www.automationpractice.pl/";

	@Test @Disabled
	public void primerTest() {

		System.out.println("Hola Mundo de Automatización!!!");

	}

	@Test @Disabled
	public void buscarProductoEdge() {

		//Instanciar el navegador
		WebDriver navegador = new EdgeDriver();
		navegador.manage().deleteAllCookies();
		navegador.manage().window().maximize();

		navegador.get(url);

		WebElement txtBusqueda = navegador.findElement(By.id("search_query_top"));
		txtBusqueda.sendKeys("Blouse");

		//Simular usar el Enter
		txtBusqueda.sendKeys(Keys.ENTER);

		//Cierra el navegador
		//close: cierra la ultima pestaña que estoy trabajando
		//quit: cierra todas las pestañas y libera los recursos.

		navegador.quit();
	}
	
	@Test
	public void buscarProductoFirefox() {

		//Instanciar el navegador
		WebDriver navegador = new FirefoxDriver();
		navegador.manage().deleteAllCookies();
		navegador.manage().window().maximize();

		navegador.get(url);

		WebElement txtBusqueda = navegador.findElement(By.id("search_query_top"));
		txtBusqueda.sendKeys("Blouse");

		//Simular usar el Enter
		txtBusqueda.sendKeys(Keys.ENTER);

		//Cierra el navegador
		//close: cierra la ultima pestaña que estoy trabajando
		//quit: cierra todas las pestañas y libera los recursos.

		navegador.quit();
	}
}
