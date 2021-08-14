package Java8Maven.Java8Maven;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConsumerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Consumer<String> cs = (s) -> {
			System.out.println(s.toUpperCase());
			System.out.println(s.toUpperCase() + Math.random());

		};
		cs.accept("Poorna");

		BiConsumer<String, Integer> bcs = (s, i) -> System.out.println("Name is  " + s + "  age is  " + i);
		bcs.accept("Poorna", 30);

		System.out.println("Max no :: " + Stream.of(8, 201, 3, 1, 100, 4).max(Comparator.comparing(i -> i)).get());

		List<String> list = new ArrayList<String>();
		list.add("Saket");
		list.add("Sau");
		list.add("Softwaretestinghelp");
		list.add("Steve");

		System.out.println(list.stream().filter(s -> s.length() > 5).count());

		Integer arr[] = { 12, 86, 1, 10, 34, 1, 89, 35 };

		List<Integer> lsI = Arrays.asList(arr);
		List<Integer> sec = lsI.stream().sorted().collect(Collectors.toList());
		System.out.println(sec.get(sec.size() - 2));

		Consumer<Integer> css = i -> {
			System.out.println(i + i);
		};

		css.accept(8);

		System.out.println(LocalDateTime.now());

		String[] sar = { "B2C", "World", "Stack Overflow", "is", "a", "gr8", "platform" };

		Boolean b = Arrays.asList(sar).stream().filter(s -> s.length() <= 5).map(s -> s.substring(1))
				.anyMatch(a -> Character.isDigit(a.charAt(0)));

		// Below solution failes without streams as stream isalready opened
		Stream<String> ss = Arrays.asList(sar).stream().filter(s -> s.length() <= 5).map(s -> s.substring(1));

		System.out.println(ss.anyMatch(s -> Character.isLetter(s.charAt(0))));
		// System.out.println(ss.anyMatch(s -> Character.isDigit(s.charAt(0))));

		// Below solution using supplier will work as we can call stream again & again
		// with less code
		Supplier<Stream<String>> sss = () -> Arrays.asList(sar).stream().filter(s -> s.length() <= 5)
				.map(s -> s.substring(1));

		System.out.println("1" + sss.get().anyMatch(s -> Character.isLetter(s.charAt(0))));
		System.out.println("2" + sss.get().anyMatch(s -> Character.isDigit(s.charAt(0))));

		System.out.println("find any" + sss.get().findAny().get());

	}
}
