package testpackage;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.junit.Assert;

public class mainTest {

	public static WebDriver driver;
	
	
	@Test	
	public void sampleRun() throws IOException{
		driver.get("https://es.wikipedia.org/wiki/Wikipedia:Portada");
		driver.findElement(By.id("searchInput")).sendKeys("test");
		driver.findElement(By.id("searchButton")).click();
		String text  = driver.findElement(By.xpath("//*[@id='mw-content-text']/ul[1]/li/b/a[contains(.,'examen')]")).getText();
		Assert.assertEquals("test string is displayed properly", text, "exame");
	}

	@BeforeTest
	public static void initializeWebDriver() throws IOException
	{
	    System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("ignore-certifcate-errors");
        chromeOptions.addArguments("test-type");
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        driver = new ChromeDriver(chromeOptions);
	}
	
	@AfterTest
	public static void closeDriver(){
		driver.quit();
	}
	
}
