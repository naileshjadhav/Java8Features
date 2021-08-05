/**
 * 
 */
package com.hcl.ing;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.hcl.ing.model.Developer;

/**
 * @author Nailesh
 * This class demonstrate stream flatmap
 *
 */
public class FlatMapDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Developer dev1 = new Developer();
		dev1.setName("Nailesh");
		dev1.addBook("Java 8 in Action");
		dev1.addBook("Spring Boot in Action");
		dev1.addBook("Effective Java (3nd Edition)");

		Developer dev2 = new Developer();
		dev2.setName("Jadhav");
		dev2.addBook("Learning Python, 5th Edition");
		dev2.addBook("Effective Java (3nd Edition)");

		List<Developer> list = new ArrayList<>();
		list.add(dev1);
		list.add(dev2);

		flatMapwithFilter(list);

	}

	/**
	 * @param list
	 */
	private static void flatMapwithFilter(List<Developer> list) {
		Set<String> books = list.stream()
				// .map(x -> x.getBook())
				.flatMap(x -> x.getBook().stream()) // Stream<String>
				.filter(x -> !x.toLowerCase().contains("python")) // filter python book
				.collect(Collectors.toSet());
		books.forEach(System.out::println);
	}

}
