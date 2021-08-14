package Java8Maven.Java8Maven;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class StreamsOf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String a = "Apple";
		String b = "Ball";
		String c = "Cat";
		String d = "Dog";
		String e = "Apple";

		Stream.of(a, b, c, d, e).filter(x -> x.length() > 3).forEach(s -> System.out.println(s));

		int[] arr = { 1, 2, 3, 4, 5, 6, 7 };

		StudentClass f = new StudentClass("Poorna", 31, 160);
		StudentClass g = new StudentClass("sowji", 27, 140);
		StudentClass h = new StudentClass("Arun", 33, 170);
		Stream.of(f, g, h).filter(i -> i.getAge() > 27).forEach(j -> System.out.println(j.getName()));

		Stream.of(f, g, h).filter(i -> i.getAge() > 27).forEach(j -> System.out.println(j.getName()));

		List<Integer> li = new ArrayList<Integer>();
		Collections.addAll(li, 1, 2, 3, 4, 5);

		Integer oi = li.stream().reduce((x, y) -> (x + y)).get();

		System.out.println("Sum is" + oi);

		System.out.println("Sum In" + li.stream().mapToInt(z -> z).sum());

	}

}
