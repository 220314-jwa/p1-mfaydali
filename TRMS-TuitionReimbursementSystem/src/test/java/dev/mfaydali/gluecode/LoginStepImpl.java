package dev.mfaydali.gluecode;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.AppHomePage;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepImpl {
	static WebDriver driver;
	static AppHomePage appHome;

	@BeforeAll
	public static void setUp() {
		File file = new File("src/test/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());

		driver = new ChromeDriver();
		appHome = new AppHomePage(driver);
	}

	@AfterAll
	public static void closeDriver() {
		driver.quit();
	}

	@Given("the user is on the homepage")
	public void the_user_is_on_the_homepage() {
		appHome.navigateTo();
	}

	@When("the user enters the correct username")
	public void the_user_enters_the_correct_username() {
		appHome.inputUsername("username");
	}

	@When("the user enters the correct password")
	public void the_user_enters_the_correct_password() {
		appHome.inputPassword("password");
	}

	@When("the user clicks the login button")
	public void the_user_clicks_the_login_button() {
		appHome.submitLogin();
	}

	@Then("the nav will show the user's first name")
	public void the_nav_will_show_the_user_s_first_name() {
		assertTrue(appHome.getNavText().contains("mehmet"));
		appHome.logOut();
	}

	@When("the user enters an incorrect username")
	public void the_user_enters_an_incorrect_username() {
		appHome.inputUsername("12345");
	}

	@Then("an incorrect credentials message will be displayed")
	public void an_incorrect_credentials_message_will_be_displayed() {
		String message = appHome.getMessageBoxText().toLowerCase();
		assertTrue(message.contains("incorrect credentials"));
	}

	@When("the user enters the incorrect password")
	public void the_user_enters_the_incorrect_password() {
		appHome.inputPassword("12345678987654321");
	}

	@When("the user enters the username {string}")
	public void the_user_enters_the_username(String username) {
		appHome.inputUsername(username);
	}

	@When("the user enters the password {string}")
	public void the_user_enters_the_password(String password) {
		appHome.inputPassword(password);
	}

	@Then("an invalid input message will be displayed")
	public void an_invalid_input_message_will_be_displayed() {
		String message = appHome.getMessageBoxText().toLowerCase();
		assertTrue(message.contains("invalid input"));
	}
}

