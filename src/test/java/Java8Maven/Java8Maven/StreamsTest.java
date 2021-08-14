package Java8Maven.Java8Maven;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StreamsTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> ls = new ArrayList<Integer>();
		ls.add(2);
		ls.add(1);
		ls.add(9);
		ls.add(9);
		ls.add(6);
		ls.add(5);
		ls.add(3);
		ls.add(4);
		ls.add(7);
		ls.add(8);
		ls.add(3);

		/*
		 * for (int i = 0; i < ls.size(); i++) { if (ls.get(i) % 2 == 0) {
		 * System.out.println(ls.get(i)); } }
		 */

		ls.stream().filter(i -> i % 2 == 0).limit(3).map(i -> i * i).forEach(n -> System.out.println(n));

		ls.stream().sorted(Comparator.reverseOrder()).peek(i -> System.out.println("received" + i))
				.forEach(i -> System.out.println(i));

		ls.stream().filter(i -> i % 2 == 0).filter(i -> i > 5).map(i -> (i * i) + 2)
				.forEach(s -> System.out.println(s));

		ls.stream().distinct().sorted().forEach(s -> System.out.println("distinct" + s));

	}

}
