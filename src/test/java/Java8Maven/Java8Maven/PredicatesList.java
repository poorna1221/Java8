package Java8Maven.Java8Maven;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.openqa.selenium.WebElement;

public class PredicatesList {

	static List<Predicate> lp = new ArrayList<Predicate>();
	private static Predicate<WebElement> pw = (e) -> e.getText().length() == 0;
	private static Predicate<WebElement> linksWithS = (e) -> e.getText().toLowerCase().contains("s");

	@SuppressWarnings("rawtypes")
	public static List<Predicate> get() {

		lp.add(pw);
		lp.add(linksWithS);

		return lp;

	}

}
