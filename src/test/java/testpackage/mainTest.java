package testpackage;
import java.io.IOException;
import org.testng.annotations.Test;
import ManageWebDriver.CustomDriver;
import org.junit.Assert;

public class mainTest extends CustomDriver {
	
	@Test	
	public void sampleRunToFail() throws IOException{
		navigateTo("https://es.wikipedia.org/wiki/Wikipedia:Portada");
		sendText("//*[@name='search']","test");
		click("//*[@id='searchButton']");
		String text = getText("//*[@id='mw-content-text']/ul[1]/li/b/a[contains(.,'examen')]");
		Assert.assertEquals("test string is displayed properly", text, "bad input");
	}
	
	@Test	
	public void sampleRunToPass() throws IOException{
		navigateTo("https://es.wikipedia.org/wiki/Wikipedia:Portada");
		sendText("//*[@name='search']","test");
		click("//*[@id='searchButton']");
		String text = getText("//*[@id='mw-content-text']/ul[1]/li/b/a[contains(.,'examen')]");
		Assert.assertEquals("test string is displayed properly", text, "examen");
	}
	
}
