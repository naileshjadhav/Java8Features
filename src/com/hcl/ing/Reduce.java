/**
 * 
 */
package com.hcl.ing;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 * @author Nailesh This class demonstrate reduction operation
 *
 */
public class Reduce {
	private static List<BigDecimal> prices = Arrays.asList(new BigDecimal(21), new BigDecimal(11), new BigDecimal(30));

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final BigDecimal totalOfDiscountedPrices = prices.stream()
				.filter(price -> price.compareTo(BigDecimal.valueOf(20)) > 0)
				.map(price -> price.multiply(BigDecimal.valueOf(0.9))).reduce(BigDecimal.ZERO, BigDecimal::add);

		System.out.println("Total of discounted prices: " + totalOfDiscountedPrices);

	}

}
