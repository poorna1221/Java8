package Java8Maven.Java8Maven;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BrokenImagesTest {

	private WebDriver driver;

	@BeforeTest
	@Parameters("browser")
	public void setUp(@Optional("chrome") String browser) {
		System.out.println("Deafault " + browser);
		this.driver = DriverFactory.getDriver("chrome");

	}

	/*
	 * @Test public void launchGoogle() {
	 * this.driver.get("https://the-internet.herokuapp.com/broken_images");
	 * 
	 * driver.findElements(By.xpath("//*[@src]")).stream().map(e ->
	 * e.getAttribute("src")) .forEach(e -> System.out.println("URL is" + e +
	 * "Response code" + BrokenUrlCheck.getResponseCode(e))); }
	 */

	@Test
	public void collectorsList() {

		System.out.println("Before" + LocalDateTime.now());

		this.driver.get("https://the-internet.herokuapp.com/broken_images");

		List<String> ls = driver.findElements(By.xpath("//*[@src]")).stream().parallel().map(e -> e.getAttribute("src"))
				.filter(src -> BrokenUrlCheck.getResponseCode(src) != 200).collect(Collectors.toList());

		ls.stream().forEach(System.out::println);

		ls.stream().forEach(s -> System.out.println("HI" + s));

		System.out.println("After" + LocalDateTime.now());

		// find any can be used with parallel stream, so it will give any element that
		// satisfies. as program run on multiple threads parallely

	}

}
