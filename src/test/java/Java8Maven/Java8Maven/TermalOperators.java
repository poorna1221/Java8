package Java8Maven.Java8Maven;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

import org.testng.annotations.Test;

public class TermalOperators {

	@Test
	public void countOperator() {
		List<String> ls = new ArrayList<>();

		ls.add("Ball");
		ls.add("Apple");
		ls.add("Abcde");
		ls.add("Cat");
		ls.add("Dog");
		ls.add("Elephant");
		ls.add("Fan");

		System.out.println(ls.stream().distinct().count());

		System.out.println(ls.stream().min(Comparator.naturalOrder()));

		System.out.println(ls.stream().max(Comparator.reverseOrder()));

		System.out.println("contains e" + ls.stream().filter(s -> s.length() > 3).anyMatch(s -> s.contains("s")));

		System.out.println("not contains z" + ls.stream().filter(s -> s.length() > 3).noneMatch(s -> s.contains("z")));

		Map<Object, List<String>> mp = ls.stream().collect(Collectors.groupingBy(s -> s.length() > 3));
		System.out.println("map" + mp);

		Random rnd = new Random();
		rnd.ints().limit(5).forEach(System.out::println);

		ArrayList<Integer> list = new ArrayList<Integer>();

		list.add(100);
		list.add(100);
		list.add(9);
		list.add(8);
		list.add(200);

		System.out.println("SUM IS :: " + list.stream().mapToInt(l -> l).sum());

		System.out.println("SUM IS :: " + list.stream().reduce((a, b) -> (a + b)).get());

		System.out.println("ls is:: " + list.stream().mapToInt(i -> i * i).filter(x -> (x > 100)).sum());

	}

}
