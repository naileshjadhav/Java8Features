/**
 * 
 */
package com.hcl.ing.model;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Nailesh
 *
 */
public class Developer {
	private Integer id;
	private String name;
	private Set<String> book;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the book
	 */
	public Set<String> getBook() {
		return book;
	}

	/**
	 * @param book the book to set
	 */
	public void setBook(Set<String> book) {
		this.book = book;
	}

	public void addBook(String book) {
		if (this.book == null) {
			this.book = new HashSet<>();
		}
		this.book.add(book);
	}

}
