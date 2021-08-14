package Java8Maven.Java8Maven;

import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SelectDropDown {

	private WebDriver driver;
	public PageObjects pg;
	Actions act;

	@BeforeTest
	@Parameters("browser")
	public void setUp(@Optional("chrome") String browser) {
		System.out.println("Deafault " + browser);
		this.driver = DriverFactory.getDriver("chrome");
		this.pg = new PageObjects(driver);
		act = new Actions(driver);
	}

	@Test(dataProvider = "gender123")
	public void launchGoogle(String gen) throws InterruptedException {
		driver.get("https://vins-udemy.s3.amazonaws.com/java/html/drop-down.html");

		String[] arr = gen.split("->");
		Arrays.stream(arr).map(s -> driver.findElement(By.linkText(s))).map(link -> act.moveToElement(link))
				.forEach(link -> link.perform());

		Thread.sleep(5000);

	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

	@DataProvider(name = "gender123")
	public Object[] testData() {
		return new Object[] { "Dropdown->Dropdown Link 5->Dropdown Submenu Link 5.4->Dropdown Submenu Link 5.4.2" };
	}

}
