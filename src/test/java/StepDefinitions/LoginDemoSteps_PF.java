package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageFactory.HomePage_PF;
import PageFactory.LoginPage_PF;
import io.cucumber.java.en.*;

public class LoginDemoSteps_PF {

	WebDriver driver = null;
	LoginPage_PF login;
	HomePage_PF homepage;
	
	@Given("browser is open")
	public void browser_is_open() {
		
		System.out.println("===Inside LoginDemoSteps_PF class===");
		
		System.out.println("Inside step - browser is open");
		
		String projectPath = System.getProperty("user.dir");
		System.out.println("Project path is :"+projectPath);
		
		System.setProperty("webdriver.chrome.driver", projectPath+"/src/test/resources/drivers/chromedriver.exe");
		
		driver = new ChromeDriver();      
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		
		//driver.manage().window().maximize();
	}

	@And("user is on login page")
	public void user_is_on_login_page() {
	    driver.navigate().to("https://example.testproject.io/web/");
	}

	@When("^user enters (.*) and (.*)$")
	public void user_enters_username_and_password(String username, String password) throws InterruptedException {
//	    driver.findElement(By.id("name")).sendKeys(username);
//	    driver.findElement(By.id("password")).sendKeys(password);
		login = new LoginPage_PF(driver);
		
		login.enterUsername(username);
		login.enterPassword(password);
	    
	    Thread.sleep(2000);
	}
	
	@And("user clicks on login")
	public void user_clicks_on_login() {
	    //driver.findElement(By.id("login")).click();
		
		login.clickOnLogin();
	}

	@Then("user is navigated to the home page")
	public void user_is_navigated_to_the_home_page() throws InterruptedException {
	    //driver.findElement(By.id("logout")).isDisplayed();
		
		homepage = new HomePage_PF(driver);
		
		homepage.checkLogOutIsDisplayed();
	    
	    Thread.sleep(2000);
	    
	    driver.close();
	    driver.quit();
	}
}
