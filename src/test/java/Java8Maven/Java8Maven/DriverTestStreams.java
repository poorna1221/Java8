package Java8Maven.Java8Maven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DriverTestStreams {

	private WebDriver driver;

	@BeforeTest
	@Parameters("browser")
	public void setUp(@Optional("chrome") String browser) {
		System.out.println("Deafault " + browser);
		this.driver = DriverFactory.getDriver("chrome");

	}

	@Test
	public void launchGoogle() {
		this.driver.get("https://www.google.com/");

		// this.driver.findElements(By.tagName("a")).forEach(n ->
		// System.out.println(n.getText()));

		this.driver.findElements(By.tagName("a")).stream().filter(i -> i.getText().length() > 0)
				.map(i -> i.getText().toUpperCase()).filter(i -> !(i.contains("S")))
				.forEach(n -> System.out.println(n));

		// another way

		this.driver.findElements(By.tagName("a")).stream().map(e -> e.getText()).map(e -> e.trim())
				.map(e -> e.toUpperCase()).filter(e -> e.length() > 0).filter(e -> !e.contains("S"))
				.forEach(s -> System.out.println(s));

		// another way

		this.driver.findElements(By.tagName("a")).stream().map(WebElement::getText).map(String::trim)
				.map(String::toUpperCase).filter(e -> e.length() > 0).filter(e -> !e.contains("S"))
				.forEach(System.out::println);

	}

	@AfterTest
	public void tearDown() {
		this.driver.quit();
	}

}
