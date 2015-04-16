package stepDefinition;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;


public class Test_Steps {
	private static WebDriver driver = null;
	@Given("^User is on Home Page$")
	public void user_is_on_Home_Page() throws Throwable {
		driver = new FirefoxDriver();
		 
        //Put a Implicit wait, this means that any search for elements on the page could take the time the implicit wait is set for before throwing exception
 
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 
        //Launch the Online Store Website
 
        driver.get("http://localhost:50000");
        
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
	}
	
	@When("^User enters Title and Content$")
	public void user_enters_title_and_content() throws Throwable {
		driver.findElement(By.id("titleInput")).sendKeys("Test title");
        
	     driver.findElement(By.id("contentInput")).sendKeys("Here is a test content");
	        
	     driver.findElement(By.id("saveButton")).click();
	     
	     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Then("^Title and Content show$")
	public void title_and_content_show() throws Throwable {
		
		String title = driver.findElement(By.id("titleShow")).getText();
		String content = driver.findElement(By.id("contentShow")).getText();
		Assert.assertEquals("Test title", title);
		Assert.assertEquals("Here is a test content", content); 
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Then("^Exit Browser$")
	public void exit_browser() throws Throwable {
		 driver.quit();
	}
	
}
