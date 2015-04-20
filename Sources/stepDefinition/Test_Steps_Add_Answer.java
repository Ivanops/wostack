package stepDefinition;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;


public class Test_Steps_Add_Answer {
	private static WebDriver driver = null;
	
	@When("^User create question one$")
	public void user_enters_question_one() throws Throwable {
		driver = new FirefoxDriver();
		driver.get("http://localhost:50000");
		driver.findElement(By.id("titleInput")).sendKeys("Question one");

		driver.findElement(By.id("contentInput")).sendKeys("Content for question One");

	    driver.findElement(By.id("saveButton")).click();

	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Then("^User select question one$")
	public void user_selects_question_one() throws Throwable {
		//driver.findElement(By.id("saveButton")).click();
		driver.manage().timeouts().implicitlyWait(22, TimeUnit.SECONDS);
		String text = "Question one";
		driver.findElement(By.linkText(text)).click();
		
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Then("^User add an answer$")
	public void user_adds_an_answer() throws Throwable {
		//driver.findElement(By.id("saveButton")).click();
		
		driver.findElement(By.id("personId")).clear();
		driver.findElement(By.id("personId")).sendKeys("person 0001");
		driver.findElement(By.id("newAnswerId")).sendKeys("the new answer....");
		driver.findElement(By.id("addButton")).click();
		
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Then("^The answer is shown in the page$")
	public void the_answer_is_shown_in_the_page() throws Throwable {
		WebElement person = driver.findElement(By.className("right-container")).findElement(By.className("person"));
		WebElement answer = driver.findElement(By.className("right-container")).findElement(By.className("answer_content"));
		Assert.assertEquals("Person: person 0001", person.getText().toString());
		Assert.assertEquals("Answer: the new answer....", answer.getText());
	}
	
	@Then("^Close Browser$")
	public void exit_browser() throws Throwable {
		 driver.quit();
	}
}