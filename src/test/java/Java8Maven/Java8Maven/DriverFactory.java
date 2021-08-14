package Java8Maven.Java8Maven;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

	private static final Supplier<WebDriver> chromeSupplier = () -> {

		System.setProperty("webdriver.chrome.driver", "ChromeDriver\\chromedriver.exe");
		return new ChromeDriver();
	};

	private static final Supplier<WebDriver> firefoxSupplier = () -> {

		System.setProperty("webdriver.chrome.driver", "ChromeDriver\\chromedriver.exe");
		return new ChromeDriver();
	};

	static Map<String, Supplier<WebDriver>> MP = new HashMap<String, Supplier<WebDriver>>();

	static {
		MP.put("chrome", chromeSupplier);
		MP.put("firefox", firefoxSupplier);
	}

	public static WebDriver getDriver(String browser) {

		return MP.get(browser).get();

	}

}
