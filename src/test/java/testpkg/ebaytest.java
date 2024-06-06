package testpkg;

import java.time.Duration;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import basepkg.baseclass;
import pagepkg.ebaylogin;
import utilities.Excelutils;

public class ebaytest extends baseclass {
	@Test(priority = 1)
	public void verifytest() throws Exception {
		ebaylogin ob = new ebaylogin(driver);
		ob.signinclick();
		driver.findElement(By.id("userid")).sendKeys("krish_25");
		Thread.sleep(7000);
		driver.findElement(By.id("signin-continue-btn")).click();
		String xl = "E:\\ebay.xlsx";
		String Sheet = "Sheet1";
		int rowcount = Excelutils.getRowCount(xl, Sheet);
		for (int i = 1; i <= rowcount; i++) {

			String password = Excelutils.getCellValue(xl, Sheet, i, 0);
			System.out.println("passworddata = " + password);
			ob.setData(password);

			ob.passwrdsignin();
			Thread.sleep(10000);

		}

		driver.findElement(By.xpath("//*[@id=\"vl-flyout-nav\"]/ul/li[2]/a")).click();// electronics

		driver.findElement(By.xpath("//*[@id=\"s0-17-12-0-1[0]-0-0\"]/ul/li[1]/a")).click();// cameras and photos

		driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[2]/div[2]/span[1]/a/div[1]/img")).click();// dslr

	}

	@Test(priority = 2)
	public void addItems() throws Exception {
	    // Get the handle of the original tab
	    String originalTabHandle = driver.getWindowHandle();

	    // Perform actions in the original tab
	    driver.findElement(By.xpath("//*[@id=\"s0-28-9-0-1[0]-0-1[0]-0-4-list\"]/li[2]/a/p")).click(); // nikon
	    driver.findElement(By.xpath("//*[@id=\"s0-28-9-0-1[0]-0-0-4-list\"]/li[1]/a/p")).click(); // nikon d850
	    driver.findElement(By.xpath("//*[@id=\"s0-1-31-12-35[3]-12[2]-6-0-1-4-list\"]/li[1]/div/div/div[2]/div[1]/div/span/a/h3")).click(); // nikon camera one
	    driver.findElement(By.xpath("//*[@id=\"mainContent\"]/main/section[2]/ul/li[3]/div/a")).click(); // add to cart
	    Thread.sleep(7000);

	    // Now call the method to switch to the new tab
	    switchToNewTab(driver);
	}

	@Test(priority = 3)
	public void selectCategory() throws Exception {
	    // Click on the "shop by category" button
	    WebElement shopByCategoryButton = driver.findElement(By.xpath("/html/body/div[2]/header/table/tbody/tr/td[2]/div/button"));
	    shopByCategoryButton.click();

	    // Wait for the menu to open and click on the "fashion" category
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
	    WebElement fashionCategoryLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"gh-sbc\"]/tbody/tr/td[1]/h3[3]/a")));
	    fashionCategoryLink.click();

	    // Now call the method to switch to the new tab
	    switchToNewTab(driver);
	}

	private void switchToNewTab(WebDriver driver) {
	    // Wait for the new tab to open
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
	    wait.until(ExpectedConditions.numberOfWindowsToBe(2));

	    // Get all window handles
	    Set<String> windowHandles = driver.getWindowHandles();

	    // Switch to the new tab
	    for (String windowHandle : windowHandles) {
	        driver.switchTo().window(windowHandle);
	        break;
	    }
	}


	@Test(priority = 4)
	public void fashion() throws Exception {
		String actualTabHandle = driver.getWindowHandle();
		driver.findElement(By.xpath("//*[@id=\"s0-28_1-9-0-1[1]-1-2-0-bModCarousel-4-list\"]/li[1]/div/a/div/div/img")).click();	//men cloth
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"s0-17-12_2-0-1[0]-0-0\"]/ul/li[7]/a")).click();//shirt
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"s0-28-9-0-1[0]-0-1[0]-0-4-list\"]/li[3]/a/div/img")).click();//polo
		Thread.sleep(5000);
		driver.findElement(By.xpath("/html/body/div[3]/div[3]/div[3]/div[1]/section[1]/div[2]/div/div/ul/li[2]/a/p")).click();//medium
		Thread.sleep(5000);
		driver.findElement(By.xpath("/html/body/div[3]/div[3]/div[3]/div[1]/section[1]/div[2]/div/div/ul/li[3]/a/p")).click();//black
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"s0-28-9-0-1[0]-0-0-4-list\"]/li[3]/a")).click();//Adidas
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[3]/div[3]/div[3]/section[1]/ul/li[1]/div[1]/div[2]/a/h3")).click();//dres selected
		Thread.sleep(7000);
		switchToTab(driver);

	}
	@Test(priority = 5)
	public void dailydeals() throws Exception {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		 WebElement deals = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"gh-p-1\"]/a")));//daily deals

		 deals.click();
		 switchToTab(driver);
	}
	private void switchToTab(WebDriver driver) {
	    // Wait for the new tab to open
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
	    wait.until(ExpectedConditions.numberOfWindowsToBe(3));

	    // Get all window handles
	    Set<String> windowHandles = driver.getWindowHandles();

	    // Switch to the new tab
	    for (String windowHandle : windowHandles) {
	        driver.switchTo().window(windowHandle);
	        break;
	    }
	}
	@Test(priority = 6)
	public void home() throws Exception {
		driver.findElement(By.xpath("/html/body/main/div[1]/div[1]/nav/ul/li[4]/a/span")).click();//home
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement myebay=driver.findElement(By.xpath("/html/body/header/div/header/div[1]/ul[2]/li[4]/div/a[1]"));//my ebay 
		Actions act=new Actions(driver);
		act.moveToElement(myebay).perform();
	    driver.findElement(By.xpath("/html/body/header/div/header/div[1]/ul[2]/li[4]/div/div/ul/li[1]/a")).click();//summary
		
		
	}
	//first login time this contanct info popup appears,then user can do the below test
	@Test(priority = 7)
	public void contanctinfo() {
		WebElement countryname = driver.findElement(By.xpath("//*[@id=\"countryId\"]"));// country
		Select country = new Select(countryname);
		country.selectByVisibleText("India");

		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[5]/form/div[3]/div[2]/div[1]/div/div/input")).sendKeys("chemmath house");// address
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[5]/form/div[3]/div[3]/span/div/div/input")).sendKeys("Kochi");
		WebElement statename = driver.findElement(By.xpath("//*[@id=\"state\"]"));// state
		Select state = new Select(statename);
		state.selectByVisibleText("Kerala");

		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[5]/form/div[3]/div[4]/span[2]/div/div/input")).sendKeys("683575");// pincode

		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[5]/form/div[4]/div/div/div[1]/div/div[1]/div")).click();// country code
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[5]/form/div[4]/div/div/div[1]/div/ul/li[94]/div/div")).click();// india

		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[5]/form/div[4]/div/div/div[1]/div/input[1]")).sendKeys("8301056167");// mobile number
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[5]/form/div[6]/input")).click();// continue
	}
	//After filling details in contanct info,user lands in summary page and from there can sign out
	//If user login with same id for second time no need to run contanctinfo test,they can directly run signout test below
	@Test(priority = 7)
	public void signout() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement signoutt=driver.findElement(By.xpath("//*[@id=\"gh-ug\"]"));//Hi krishnendu
		Actions act=new Actions(driver);
		act.moveToElement(signoutt).perform();
	    driver.findElement(By.xpath("//*[@id=\"gh-uo\"]/a")).click();//signout link
}
}
	


