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
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
	
	@When("^User click on question title$")
	public void user_click_on_question_title() throws Throwable {
		driver.findElement(By.className("questionTitle")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@When("^User add Answer$")
	public void user_add_Answer() throws Throwable {
		driver.findElement(By.id("newAnswerId")).sendKeys("New Answer test");
		driver.findElement(By.id("addButton")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@When("^User add Point to Answer$")
	public void user_add_Point_to_Answer() throws Throwable {
		driver.findElement(By.className("points-button")).click();
		String value = driver.findElement(By.className("points-container")).getText();
		Assert.assertEquals("1", value);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
}
