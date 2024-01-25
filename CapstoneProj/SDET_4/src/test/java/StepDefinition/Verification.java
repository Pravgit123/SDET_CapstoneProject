package StepDefinition;

import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import Base.LoginPageUtil;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;

public class Verification {

    WebDriver driver;

    @Given("^User is on the login page$")
    public void userIsOnTheLoginPage() {
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\swayam\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");  
	    ChromeOptions o=new ChromeOptions();
	    o.addArguments("force-device-scale-factor=0.88");
		driver=new ChromeDriver(o);  
	      
	    driver.navigate().to("https://www.saucedemo.com/");  
	    driver.manage().window().maximize();
//        driver.get("https://www.saucedemo.com/");
    }

    @When("^User enters valid credentials$")
    public void userEntersValidCredentials() throws Exception {
    	String expected="https://www.saucedemo.com/";
    	String actual=driver.getCurrentUrl();
    	Object[][] testData = LoginPageUtil.getTestData("C:\\Users\\swayam\\OneDrive\\Desktop\\credentials.xlsx", "Sheet1");
        String validUsername = testData[0][0].toString();
        String validPassword = testData[0][1].toString();      
        Assert.assertEquals(expected,actual);

        LoginPageUtil.login(driver, validUsername, validPassword);
    }

    @And("^User clicks on the login button$")
    public void userClicksOnTheLoginButton() {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("^User should be logged in successfully$")
    public void userShouldBeLoggedInSuccessfully() {
        String expectedTitle = "Swag Labs";
        Assert.assertEquals(expectedTitle, driver.getTitle());
        driver.quit();
    }

    @When("^User enters invalid credentials$")
    public void userEntersInvalidCredentials() throws InvalidFormatException, Exception {
    	Object[][] testData = LoginPageUtil.getTestData("C:\\Users\\swayam\\OneDrive\\Desktop\\java_credentials.xlsx", "Sheet1");
        String validUsername = testData[1][0].toString();
        String validPassword = testData[1][1].toString();

        LoginPageUtil.login(driver, validUsername, validPassword);
    }

    @Then("^User should see an error message$")
    public void userShouldSeeAnErrorMessage() {
        String expectedError = "Epic sadface: Username and password do not match any user in this service";
        Assert.assertEquals(expectedError, driver.findElement(By.xpath("//h3[@data-test=\"error\"]")).getText());
        driver.quit();
    }
}
