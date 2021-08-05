/**
 * 
 */
package com.hcl.ing;

import java.util.Optional;

/**
 * @author Nailesh
 * This class demonstrate java8 optional feature
 *
 */
public class OptionalFeature {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String name = "Ashish";
		String nullName = null;
		Optional<String> opt = Optional.of("Nailesh"); //creates optional of non null values
	    System.out.println(""+opt.isPresent()); //Is value present

	    opt = Optional.ofNullable(null);
	    System.out.println(""+opt.isPresent());//does not throws exception
	    
	    //opt = Optional.of(null); // it throws exception
	    //System.out.println(""+opt.isPresent());//does not throws exception
	    Optional.ofNullable(name).ifPresent(System.out::println); //If present
	    System.out.println("Or else: "+Optional.ofNullable(nullName).orElse("Jadhav")); //Or else
	    
	}

}
