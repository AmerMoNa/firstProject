package swagLabs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class anything {

	WebDriver driver = new EdgeDriver();
	String URL = "https://www.saucedemo.com/";

	String userName = "standard_user";
	String password = "secret_sauce";
	String firstname = "amer";
	String lastname = "nawasreh";
	String co = "5678";

	@BeforeTest
	public void first() {
		driver.get(URL);
		driver.manage().window().maximize();
	}

	@Test(priority = 1)
	public void login() {
		WebElement usernameinput = driver.findElement(By.id("user-name"));

		WebElement Passwordinput = driver.findElement(By.id("password"));

		WebElement button = driver.findElement(By.id("login-button"));

		usernameinput.sendKeys(userName);
		Passwordinput.sendKeys(password);
		button.click();
	}

	@Test(priority = 2)
	public void addRandomlyItems() {
		WebElement backpack = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
		WebElement bikelight = driver.findElement(By.id("add-to-cart-sauce-labs-bike-light"));

		backpack.click();
		bikelight.click();

	}

	@Test(priority = 3)
	public void removeItem() {
		WebElement rebackpack = driver.findElement(By.id("remove-sauce-labs-backpack"));

		WebElement cartcontainer = driver.findElement(By.id("shopping_cart_container"));

		rebackpack.click();
		cartcontainer.click();

	}

	@Test(priority = 4)
	public void checkOut() {

		WebElement chechoutinput = driver.findElement(By.id("checkout"));
		chechoutinput.click();

		WebElement firstNameinput = driver.findElement(By.id("first-name"));
		firstNameinput.sendKeys(firstname);

		WebElement lastNameinput = driver.findElement(By.id("last-name"));
		lastNameinput.sendKeys(lastname);

		WebElement codeinput = driver.findElement(By.id("postal-code"));
		codeinput.sendKeys(co);

		WebElement continuE = driver.findElement(By.id("continue"));
		continuE.click();

		WebElement finish = driver.findElement(By.id("finish"));
		finish.click();

		WebElement goBack = driver.findElement(By.id("back-to-products"));
		goBack.click();

	}

	@Test(priority = 5)
	public void logOut() throws InterruptedException {

		WebElement burger = driver.findElement(By.id("react-burger-menu-btn"));
		burger.click();
		Thread.sleep(2000); // we need to set a delay because the list needs some time to show
		WebElement sidebar = driver.findElement(By.id("logout_sidebar_link"));
		sidebar.click();

		WebElement logo = driver.findElement(By.className("login_logo"));
		System.out.println(logo.getText());

		System.out.println();

		WebElement usernames = driver.findElement(By.id("login_credentials"));
		System.out.println(usernames.getText());

		System.out.println();

		WebElement onepassword = driver.findElement(By.className("login_password"));
		System.out.println(onepassword.getText());

		System.out.println("--------------------------------------------------------");
	}

	@AfterTest
	public void therd() throws InterruptedException {
		Thread.sleep(1000);

		driver.quit();
	}
}
