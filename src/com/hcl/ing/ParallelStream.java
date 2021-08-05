/**
 * 
 */
package com.hcl.ing;

import java.time.Duration;
import java.time.Instant;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author Nailesh
 *
 */
public class ParallelStream {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Instant start = Instant.now();
        long count = parallelExecution();
        Instant finish = Instant.now();
        
        System.out.println("\nTotal: " + count);
        System.out.println("Time to execute: "+Duration.between(start, finish).getSeconds());

    }

	/**
	 * @return count
	 */
	private static long parallelExecution() {
		long count = Stream.iterate(0, n -> n + 1)
                .limit(1_000_00)
                .parallel()   //with this 2s, without this 1m 4s
                .filter(ParallelStream::isPrime)
                .peek(x -> System.out.format("%s\t", x))
                .count();
		return count;
	}

    public static boolean isPrime(int number) {
        if (number <= 1) return false;
        return !IntStream.rangeClosed(2, number / 2).anyMatch(i -> number % i == 0);
    }

}
