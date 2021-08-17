package br.com.fabricio.python.util;

import java.util.Objects;

/**
 * this class is a copy of Python str with your method and anymore make by
 * myself
 * 
 * @author Fabricio Borges Justino
 * @version 1.0
 *
 */
public class Str implements EstractValue<String> {
	private String str;

	/**
	 * cosntructor of class Str with String param
	 * 
	 * @param str: elemet to operate
	 */
	public Str(String str) {
		this.str = str;
	}

	/*
	 * constructor of class Str with no param
	 */
	public Str() {
		this.str = "";
	}

	/**
	 * 
	 * @return a Str capitalized
	 */
	public Str capitalize() {
		if (this.str.isBlank())
			return new Str();
		
		String el;
		el = this.str.transform(newStr -> {
			char temp = newStr.toUpperCase().charAt(0);
			String template = (newStr.length() > 1) ? temp + newStr.substring(1, newStr.length()) : temp + "";

			return template;
		});

		return new Str(el);
	}

	/**
	 * this method splits a String into Str in each whites spaces and causes each
	 * element in the created array to be capitalized
	 * 
	 * @return an Str with initial after each whites spaces capitalized
	 */
	public Str title() {
		if (this.str.isBlank())
			return new Str();
		
		String el;
		el = this.str.transform(newJ -> {
			String arr[] = newJ.split("[ ]");
			String completa = "";
			for (String item : arr) {
				if (item.isBlank())
					continue;

				char newCharacter = item.toUpperCase().charAt(0);
				String replaced = (item.length() > 1) ? newCharacter + item.substring(1, item.length())
						: newCharacter + "";
				completa += replaced + " ";
			}

			return completa.trim();
		});

		return new Str(el);
	}

	/**
	 * this method splits a String into Str com-param defined by regex and causes
	 * each element in the created array to be capitalized
	 * 
	 * @param regex: separetor to make a split
	 * @return a Str with each element in created array capitalized
	 */
	public Str title(String regex) {
		if (this.str.isBlank())
			return new Str();

		String el;
		el = this.str.transform(newJ -> {
			String arr[] = newJ.split(regex);
			String completa = "";
			for (String item : arr) {
				if (item.isBlank())
					continue;

				char newCharacter = item.toUpperCase().charAt(0);
				String replaced = (item.length() > 1) ? newCharacter + item.substring(1, item.length())
						: newCharacter + "";
				completa += replaced + " ";
			}

			return completa.trim();
		});

		return new Str(el);
	}

	/**
	 * this method verifies if the current Srt is alphanumeric
	 * 
	 * @return : True if current Str is alphanumeric
	 */
	public boolean isAlNun() {
		if (this.str.isBlank())
			return false;

		return this.str.matches("[a-zA-Z0-9]{1,}");
	}

	/**
	 * this method verifies if the current Str is alphabetic
	 * 
	 * @return True if current Str is alphabetic
	 */
	public boolean isAlpha() {
		if (this.str.isBlank())
			return false;

		return this.str.matches("[a-zA-Z]{1,}");
	}

	/**
	 * this method verifies if the current Str is an number
	 * 
	 * @return True if current Str is Numeric
	 */
	public boolean isNumeric() {
		if (this.str.isBlank())
			return false;

		return this.str.matches("[0-9]{1,}");
	}

	/**
	 * verifies the current string has the shape an email
	 * 
	 * @return returns true if the current string has a pattern for an email
	 */
	public boolean isEmail() {
		return this.str.matches("[a-zA-Z.]{1,}[0-9]{1,}@[a-zA-Z]{1,}.com");
	}

	/**
	 * verifies the current string has a shape of email and ends with at least one
	 * "end" from the array of "ends"
	 * 
	 * @param ends: array of String that defines the behavior of end ex: (.com, .br)
	 * @return true if the current string has a pattern for an email with end
	 *         defined by ends[]
	 */
	public boolean isEmail(String... ends) {
		Objects.requireNonNull(ends);
		boolean n = false;

		for (String end : ends) {
			n = n || this.str.matches("[a-zA-Z.]{1,}[0-9]{1,}@[a-zA-Z]{1,}%s".formatted(end));
		}

		return n;
	}

	/**
	 * 
	 * searches for a string(findIn) the current string and counts how many times it
	 * appears(occurrence)
	 * 
	 * @param findIn: String que sera o objeto de pesquisa na estring atual
	 * @return number of occurrences defined by "findIn" in the current String
	 */
	public int count(String findIn) {
		if (this.str.isBlank())
			return -1;

		if (findIn.length() > this.str.length())
			throw new IndexOutOfBoundsException("the ocorrence has value greater than current String");

		if (this.str.equals(findIn))
			return 1;

		int cont = 0;
		String temp = "";
		String el = this.str + " ".repeat(findIn.length());

		for (int i = 0; i < el.length(); i++) {
			temp += el.charAt(i);
			if (temp.length() == findIn.length()) {
				if (temp.equals(findIn)) {
					el = el.substring(findIn.length(), el.length());
					cont++;
					temp = "";
					i = -1;
				} else {
					temp = "";
					i = -1;
					el = (el.length() > 1) ? el.substring(1, el.length()) : el;

					if (el.length() <= 1)
						break;
				}
			}

		}

		return cont;
	}
	
	/**
	 * return a Str class formated
	 * 
	 * @param args
	 * @return return Str formatted with {} replaced by each arg in the sequence defined
	 * 
	 * @throws NumberExcedArgsException when quantity of {} isn't equal args length
	 */
	public Str format(Object... args) {
		Objects.requireNonNull(args);

		String el = this.str;

		if (this.count("{}") != args.length) {
			throw new NumberExcedArgsException(
					new Throwable("Number of {} is %d, Number of args is %d".formatted(this.count("{}"), args.length)));
		}

		for (Object obj : args) {
			el = el.replaceFirst("[{][}]", obj.toString());
		}

		return new Str(el);
	}

	@Override
	public int hashCode() {
		return this.str.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Str other = (Str) obj;
		if (str == null) {
			if (other.str != null)
				return false;
		} else if (!str.equals(other.str))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return this.str;
	}

	@Override
	public String valueOf() {
		return this.str;
	}

}
