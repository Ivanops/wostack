package stepDefinition;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;


public class Test_Steps_Add_Answer {
	private static WebDriver driver = null;
	
	@When("^User create question: \"(.*?)\", with content: \"(.*?)\"$")
	public void user_create_question_with_content(String question, String content) throws Throwable {
		driver = new FirefoxDriver();
		
		driver.get("http://localhost:50000");
		
		driver.findElement(By.id("create-button")).click();
		driver.findElement(By.id("titleInput")).sendKeys(question);
		driver.findElement(By.id("contentInput")).sendKeys(content);
	    driver.findElement(By.id("saveButton")).click();
	    
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Then("^User select question \"(.*?)\"$")
	public void user_selects_question(String question) throws Throwable {
		driver.manage().timeouts().implicitlyWait(22, TimeUnit.SECONDS);
		driver.findElement(By.linkText(question)).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Then("^User \"(.*?)\" add the answer: \"(.*?)\"$")
	public void user_add_the_answer(String person, String answer) throws Throwable {
		driver.findElement(By.id("personId")).clear();
		driver.findElement(By.id("personId")).sendKeys(person);
		driver.findElement(By.id("newAnswerId")).sendKeys(answer);
		driver.findElement(By.id("addButton")).click();
		
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Then("^The answer \"(.*?)\" of \"(.*?)\" is shown in the page$")
	public void the_answer_of_is_shown_in_the_page(String answer, String person) throws Throwable {
		WebElement actualPerson = driver.findElement(By.className("right-container")).findElement(By.className("person"));
		WebElement actualAnswer = driver.findElement(By.className("right-container")).findElement(By.className("answer_content"));
		Assert.assertEquals("Person: "+ person, actualPerson.getText().toString());
		Assert.assertEquals("Answer: " + answer, actualAnswer.getText());
	}
	
	@Then("^User try to add an empty answer$")
	public void user_try_to_add_an_empty_answer() throws Throwable {
	    driver.findElement(By.id("personId")).clear();
		driver.findElement(By.id("newAnswerId")).clear();
		driver.findElement(By.id("addButton")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	}

	@Then("^No answer is shown in the page$")
	public void no_answer_is_shown_in_the_page() throws Throwable {
	    java.util.List<WebElement> elements = driver.findElement(By.tagName("ul")).findElements(By.tagName("li"));
		Assert.assertEquals(0, elements.size());	
	}
	
	@Then("^Close Browser$")
	public void exit_browser() throws Throwable {
		 driver.quit();
	}
}