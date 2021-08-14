package Java8Maven.Java8Maven;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FilesProcess {

	public static void main(String args[]) throws IOException {

		Path p = Paths.get("D://LearningTools//Eclipse//JavaEclipseWorkspace//Java8Maven//Data//testdata.txt");
		List<String> ls = Files.readAllLines(p);
		System.out.println("Total size is " + ls.size());

		System.out.println("Names starts with B :: "
				+ ls.stream().map(s -> s.toUpperCase()).filter(s -> s.startsWith("B")).count());

		List<String> csList = ls.stream().map(s -> s.toUpperCase()).filter(s -> s.startsWith("C"))
				.filter(s -> s.contains("S")).collect(Collectors.toList());

		System.out.println(csList.size());

		int count = ls.stream().map(s -> s.toUpperCase()).filter(s -> s.startsWith("M")).map(n -> n.trim())
				.map(a -> a.length()).mapToInt(z -> z).sum();

		System.out.println("Count is" + count);

		List<String> str = ls.stream().filter(s -> s.contains("-")).map(s -> s.replace("-", " "))
				.collect(Collectors.toList());
		System.out.println(str);

		System.out.println("Max string is:: " + ls.stream().max(Comparator.comparing(s -> s.length())).get());

		List<Integer> intList = new ArrayList<Integer>();
		intList.add(1);
		intList.add(4);
		intList.add(100);
		intList.add(3);
		intList.add(5);

		System.out.println("Sum is :: " + intList.stream().sorted().reduce((a, b) -> (a - b)).get());

		System.out.println("Max no:: " + intList.stream().max(Comparator.comparing(a -> a)).get());

	}

}
