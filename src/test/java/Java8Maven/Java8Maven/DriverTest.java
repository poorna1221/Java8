package Java8Maven.Java8Maven;

import java.util.List;
import java.util.function.Predicate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DriverTest {

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

		List<WebElement> ele = this.driver.findElements(By.tagName("a"));

		Predicate<WebElement> pw = (e) -> e.getText().length() == 0;

		System.out.println("Before" + ele.size());

		// ele.removeIf(pw);

		// System.out.println("After1" + ele.size());

		ele.forEach(n -> System.out.println(n.getText()));

		// remove links having s

		Predicate<WebElement> linksWithS = (e) -> e.getText().toLowerCase().contains("s");
		ele.removeIf(pw.or(linksWithS));

		System.out.println("After2" + ele.size());

		ele.forEach(n -> System.out.println("Before Remove" + n.getText()));

		// read from predicates list in another way

		PredicatesList.get().forEach(n -> ele.removeIf(n));

		System.out.println("List of predicates rule" + ele.size());

		ele.forEach(n -> System.out.println("After Remove" + n.getText()));

	}

}
