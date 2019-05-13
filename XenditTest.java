package Stepdefinitions;

import java.awt.Desktop.Action;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.runtime.junit.Assertions;




public class XenditTest {
public static WebDriver driver;
	
	
	@Given("^User Home Page Online Calculator$")
    public void user_home_page_online_calculator() throws Throwable {
		driver = createNewDriverInstance();
		driver.get("https://www.online-calculator.com/full-screen-calculator/");
    }
	
	public static WebDriver createNewDriverInstance() throws MalformedURLException {
		System.setProperty("webdriver.chrome.driver", new File("drivers/geckodriver-v0.19.0-win64.exe").getAbsolutePath() );
		final DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setJavascriptEnabled(true);
		capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		capabilities.setCapability("acceptInsecureCerts", true);
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("start-maximized");
		final URL remoteAddress = new URL("http://localhost:4444/wd/hub");
		RemoteWebDriver driver = new RemoteWebDriver(remoteAddress, capabilities);	
		driver.setFileDetector(new LocalFileDetector());
		   // driver = new ChromeDriver(capabilities);
		driver.manage().timeouts().pageLoadTimeout(450, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		return driver;	
	}
	
	
	@When("^user Have Number (.*)$")
    public void user_have_number(String numb) throws Throwable {
      char[] stringToCharArray = numb.toCharArray();
      
      for (char output : stringToCharArray) {
    	  FuncNumpad(output);
			System.out.println(output);
			Thread.sleep(1000);
		}
      
    }
	
	
	public static void FuncNumpad(char output){
		Actions act = new Actions(driver);
		switch (output) {
		case '0':
			 act.sendKeys(Keys.NUMPAD0).build().perform();
			break;	
		case '1':
			act.sendKeys(Keys.NUMPAD1).build().perform();
			break;
		case '2':
			 act.sendKeys(Keys.NUMPAD2).build().perform();
			break;	
		case '3':
			 act.sendKeys(Keys.NUMPAD3).build().perform();
			break;	
		case '4':
			 act.sendKeys(Keys.NUMPAD4).build().perform();
			break;	
		case '5':
			 act.sendKeys(Keys.NUMPAD5).build().perform();
			break;	
		case '6':
			 act.sendKeys(Keys.NUMPAD6).build().perform();
			break;	
		case '7':
			 act.sendKeys(Keys.NUMPAD7).build().perform();
			break;	
		case '8':
			 act.sendKeys(Keys.NUMPAD8).build().perform();
			break;	
		case '9':
			 act.sendKeys(Keys.NUMPAD9).build().perform();
			break;	
		}
		
		
	}
	
	@And("^Want To subtraction$")
    public void want_to_subtraction() throws Throwable {
		Actions act = new Actions(driver);
		act.sendKeys(Keys.SUBTRACT).build().perform();
    }
	
	@And("^Want To Division$")
	public void want_to_division() throws Throwable {
		Actions act = new Actions(driver);
		act.sendKeys(Keys.DIVIDE).build().perform();
	}

	 @Then("^User Should be have (.*), Numb (.*) subtraction (.*)$")
	 public void user_should_be_have(Integer Result, Integer Numb1, Integer Numb2) throws Throwable {
		Actions act = new Actions(driver);
		act.sendKeys(Keys.EQUALS).build().perform();
		 Integer Total = Numb1 - Numb2;
		 assertEquals("Result", Result, Total);
		 driver.close(); 
    }
	 
	  @Then("^Result is (.*), division between (.*) and (.*)$")
	  public void result_is(Integer Result, Integer Numb1, Integer Numb2) throws Throwable {
		  Actions act = new Actions(driver);
			act.sendKeys(Keys.EQUALS).build().perform();
			 Integer Total = Numb1 / Numb2;
			 assertEquals("Result", Result, Total);
			 driver.close(); 
	    }
	 
	  
	  @And("^user clear it$")
	  public void user_clear_it() throws Throwable {
		Actions act = new Actions(driver);
		act.sendKeys(Keys.DELETE).build().perform(); 
		driver.close(); 
	  }

	  public static void assertEquals(String message, Object expectedValue, Object actualValue) {
	       Assert.assertEquals(message, expectedValue, actualValue);
	   }
	 
}
