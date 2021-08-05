/**
 * 
 */
package com.hcl.ing;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author Nailesh This class demonstrate java8 io improvements
 *
 */
public class Java8IO {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		String fileName = "E:\\Java8Features\\Java8\\test.txt";
		bufferdReader(fileName); //byte reading from file
		readAllLines(fileName); //read all lines at once
		fileWalk(); // lists all the files and subfolder files
	}

	/**
	 * @throws IOException
	 */
	private static void fileWalk() throws IOException {
		String path = "E:\\Java8Features\\Java8\\";
		Stream<Path> filesStream = Files.walk(Paths.get(path));
		filesStream.forEach(str -> System.out.println(str));
		filesStream.close();
	}

	/**
	 * @param fileName
	 * @throws IOException
	 */
	private static void readAllLines(String fileName) throws IOException {
		List<String> fruitsList =  Files.readAllLines(Paths.get(fileName));
		fruitsList.forEach(System.out::printf);
	}

	/**
	 * @param fileName
	 * @throws IOException
	 */
	private static void bufferdReader(String fileName) throws IOException {
		BufferedReader reader = Files.newBufferedReader(Paths.get(fileName));
		String line = new String();
		while ((line = reader.readLine()) != null) {
			System.out.println(line);
		}
	}

}
