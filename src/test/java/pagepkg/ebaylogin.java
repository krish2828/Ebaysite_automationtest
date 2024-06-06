package pagepkg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ebaylogin {
	WebDriver driver;

	@FindBy(xpath = "//*[@id=\"gh-ug\"]/a")
	WebElement signin;

	@FindBy(id = "pass")
	WebElement passwordval;

	@FindBy(id = "sgnBt")
	WebElement siginbutton;

	// constructor
	public ebaylogin(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void signinclick() {
		signin.click();

	}

	public void setData(String password) {
		passwordval.clear();
		passwordval.sendKeys(password);

	}

	public void passwrdsignin() {
		siginbutton.click();

	}
}
