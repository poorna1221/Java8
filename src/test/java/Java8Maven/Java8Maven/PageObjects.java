package Java8Maven.Java8Maven;

import java.util.List;
import java.util.function.Predicate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageObjects {

	private WebDriver driver;

	public PageObjects(WebDriver driver) {
		this.driver = driver;
	}

	public void openUrl() {

		this.driver.get("https://vins-udemy.s3.amazonaws.com/java/html/java8-stream-table.html");
		System.out.println("Hello");
	}

	public void selectChkBoxes(String gender) throws InterruptedException {

		this.driver.findElements(By.xpath("//table/tbody/tr")).stream().skip(1)
				.map(trList -> trList.findElements(By.tagName("td")))
				.filter(tdlist -> tdlist.get(1).getText().contains(gender)).map(td -> td.get(3))
				.map(td -> td.findElement(By.tagName("input"))).forEach(e -> e.click());
		Thread.sleep(2000);

	}

	public void selectChkBoxesWithPredicate(Predicate<List<WebElement>> pwl) throws InterruptedException {

		this.driver.findElements(By.xpath("//table/tbody/tr")).stream().skip(1)
				.map(trList -> trList.findElements(By.tagName("td"))).filter(pwl).map(td -> td.get(3))
				.map(td -> td.findElement(By.tagName("input"))).forEach(e -> e.click());
		Thread.sleep(2000);

	}
}
