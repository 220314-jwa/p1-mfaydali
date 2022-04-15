package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

// following the page object model design pattern,
// this class will represent what the pet app home page
// is like and what interactions we might want to do
public class AppHomePage {
	WebDriver driver;

	// PageFactory allows you to use annotations to have Selenium instantiate your
	// WebElement fields for you
	@FindBy(id="usernameLogin")
	WebElement usernameInput;
	@FindBy(id="passwordLogin")
	WebElement passwordInput;
	@FindBy(id="logInBtn")
	WebElement logInBtn;
	// TODO
	WebElement messageBox;

	public AppHomePage(WebDriver driver) {
		this.driver = driver;

		// tells Selenium to find the elements based on the annotations above
		PageFactory.initElements(driver, this);
	}

	public void navigateTo() {
		driver.get("C:\\Users\\mehme\\Desktop\\Revature\\Project1\\p1-mfaydali\\TRMS-FE\\index.html");
	}

	public void inputUsername(String username) {
		usernameInput.sendKeys(username);
	}

	public void inputPassword(String password) {
		passwordInput.sendKeys(password);
	}

	public void submitLogin() {
		logInBtn.click();
	}

	public void logOut() {
		if (logInBtn.getText().equals("Log Out")) {
			logInBtn.click();
		}
	}

	public String getMessageBoxText() {
		Wait<WebDriver> fluentWait = new FluentWait<>(driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(500));
		fluentWait.until(ExpectedConditions
				.textToBePresentInElement(messageBox, "i"));

		return messageBox.getText();
	}

	public String getNavText() {
		Wait<WebDriver> fluentWait = new FluentWait<>(driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(500));
		fluentWait.until(ExpectedConditions
				.numberOfElementsToBe(By.id("nameDisplay"), 1));

		return driver.findElement(By.id("nameDisplay")).getText();
	}
}
