package Practice;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.IntStream;

import org.testng.annotations.Test;

public class AnyMatch {

	@Test
	public void anyMatch() {

		Boolean b = Arrays.asList(1, 4, 5, 3, 2, 6, 2).stream().anyMatch(s -> s == 2);
		System.out.println(b);

		int firstNumber = Arrays.asList(4, 4, 5, 3, 2, 6, 2).stream().sorted().findFirst().get();
		System.out.println("firstNumber is ::" + firstNumber);

	}

	@Test
	public void noneMatch() {

		Boolean b = Arrays.asList(1, 4, 5, 3, 2, 6, 2).stream().noneMatch(s -> s == 8);
		System.out.println("none match::" + b);

	}

	@Test
	public void findAny() {

		Integer in = Arrays.asList(1, 4, 5, 3, 2, 6, 2).stream().findAny().get();
		System.out.println("find any randome number::" + in);

		// Creating an IntStream
		IntStream stream = IntStream.of(4, 5, 8, 10, 12, 16).parallel();

		// Using Stream findAny().
		// Executing the source code multiple times
		// may not return the same result.
		// Every time you may get a different
		// Integer which is divisible by 4.
		stream = stream.filter(i -> i % 4 == 0);

		OptionalInt answer = stream.findAny();
		if (answer.isPresent()) {
			System.out.println("Rand:: "+answer.getAsInt());
		}

	}

}
