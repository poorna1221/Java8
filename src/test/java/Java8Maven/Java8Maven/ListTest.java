package Java8Maven.Java8Maven;

import java.util.ArrayList;
import java.util.List;

public class ListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<String> str = new ArrayList<String>();

		str.add("poorna");
		str.add("chandra");
		str.add("rao");
		str.add("jogi");

		str.forEach(s -> System.out.println(s));

	}

}
