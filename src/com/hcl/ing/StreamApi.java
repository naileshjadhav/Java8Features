/**
 * 
 */
package com.hcl.ing;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Nailesh 
 * This is Stream api demo class
 *
 */
public class StreamApi {

	private static List<String> list = Arrays.asList("Beijing");
	private static Stream<String> stream = Stream.of("Nailesh", "Amar01", "Akash", "Jadhav", "Ashish");
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		streamFilter();
		mapCollectors();
		
	}

	/**
	 *  This method demonstrate map, distinct and collectors using stream
	 */
	private static void mapCollectors() {
		Stream<String> stream1 = Stream.of("Nailesh", "Amar01", "Akash", "Jadhav", "Ashish");
		list = stream1.distinct().map(e->e.toUpperCase()).collect(Collectors.toList());
		list.forEach(System.out::println);
		System.out.println("-------------------");
	}

	/**
	 * This is stream filter method to filter string contains number
	 */
	private static void streamFilter() {
		Predicate<? super String> predicate = p -> p.matches(".*\\d.*");
		stream.filter(predicate).forEach(System.out::println);
		System.out.println("-------------------");
	}

}
