package Java8Maven.Java8Maven;

import java.util.List;
import java.util.function.Predicate;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SelectAllCheckBoxes {

	private WebDriver driver;
	public PageObjects pg;

	@BeforeTest
	@Parameters("browser")
	public void setUp(@Optional("chrome") String browser) {
		System.out.println("Deafault " + browser);
		this.driver = DriverFactory.getDriver("chrome");
		this.pg = new PageObjects(driver);
	}

	@Test(dataProvider = "PR1")
	public void launchGoogle(Predicate<List<WebElement>> gen) throws InterruptedException {
		pg.openUrl();
		// pg.selectChkBoxes(gen);
		pg.selectChkBoxesWithPredicate(gen);
		Thread.sleep(2000);

	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

	@DataProvider(name = "gender123")
	public Object[] testData() {
		return new Object[] { "Male", "Female" };
	}

	@DataProvider(name = "PR")
	public Object[] testDataPredicates() {
		Predicate<List<WebElement>> prMale = tdlist -> tdlist.get(1).getText().equalsIgnoreCase("Male");
		Predicate<List<WebElement>> prFemale = tdlist -> tdlist.get(1).getText().equalsIgnoreCase("feMale");
		Predicate<List<WebElement>> prMaleOrFemale = prMale.or(prFemale);
		return new Object[] { prMaleOrFemale };
	}

	@DataProvider(name = "PR1")
	public Object[] testGenderCountry() {
		Predicate<List<WebElement>> prMale = tdlist -> tdlist.get(1).getText().equalsIgnoreCase("Female");
		Predicate<List<WebElement>> country = tdlist -> tdlist.get(2).getText().equalsIgnoreCase("UK");
		Predicate<List<WebElement>> name = tdlist -> tdlist.get(0).getText().equalsIgnoreCase("Sally");

		Predicate<List<WebElement>> prMaleOrFemale = prMale.and(country).and(name);
		return new Object[] { prMaleOrFemale };
	}
}
