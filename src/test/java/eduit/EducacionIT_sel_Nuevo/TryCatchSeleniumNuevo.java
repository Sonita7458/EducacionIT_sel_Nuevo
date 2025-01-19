package eduit.EducacionIT_sel_Nuevo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TryCatchSeleniumNuevo {

	@Test
	public void testSeleniumExample() {
		WebDriver driver = null;
		String URL="http://www.automationpractice.pl/index.php?controller=authentication&back=my-account";
		//Para que de el error usar la url http://www.google.com

		//Para que de error se coloca Search1 pero es Search
		By searchqueryLocator=By.cssSelector("input[placeholder='Search1']");


		try {

			driver= new EdgeDriver();		
			driver.get(URL);
			driver.manage().window().maximize();

			WebElement txtBuscador=driver.findElement(searchqueryLocator);

			txtBuscador.clear();

			txtBuscador.sendKeys("Blouse");

			txtBuscador.sendKeys(Keys.ENTER);


		} catch (Exception e) {

			//e.printStackTrace();
			System.out.println("Error:"+ e.getMessage());

			//NO ENCUENTRA EL LOCALIZADOR
			Assert.fail("Error: No Locate Element");

		} 
		// Con el finally sigue la ejecución
		finally {

			if (driver != null) {
				driver.quit();
			}


		}

	}
}
