package Java8Maven.Java8Maven;

import java.util.stream.Stream;

public class EmptyStreams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Stream<Integer> streamIterated = Stream.iterate(40, n -> n + 2).limit(20);

		streamIterated.forEach(s -> System.out.println(s));

		Stream<String> streamGenerated1 = Stream.generate(() -> "Poorna").limit(10);
		streamGenerated1.forEach(s -> System.out.println(s));
	}

}
