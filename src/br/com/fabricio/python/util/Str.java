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

		this.str = this.str.transform(newStr -> {
			char temp = newStr.toUpperCase().charAt(0);
			String template = (newStr.length() > 1) ? temp + newStr.substring(1, newStr.length()) : temp + "";

			return template;
		});

		return new Str(this.str);
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

		this.str = this.str.transform(newJ -> {
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

		return new Str(this.str);
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

		this.str = this.str.transform(newJ -> {
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

		return new Str(this.str);
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
	
	public boolean isEmail() {
		return this.str.matches("[a-zA-Z.]{1,}[0-9]{1,}@[a-zA-Z]{1,}.com");
	}
	
	public boolean isEmail(String ...ends) {
		Objects.requireNonNull(ends);
		boolean n = false;
		
		for(String end : ends) {
			n = n || this.str.matches("[a-zA-Z.]{1,}[0-9]{1,}@[a-zA-Z]{1,}%s".formatted(end));
		}
		
		return n;
	}

	public int count(String findIn) {
		if (this.str.isBlank())
			return -1;

		if (findIn.length() > this.str.length())
			throw new IndexOutOfBoundsException("the ocorrence has value greater than current String");

		if (this.str.equals(findIn))
			return 1;

		int cont = 0;
		String temp = "";
		
		for (int i = 0; i < this.str.length(); i++) {
			temp += this.str.charAt(i);
			if (temp.length() == findIn.length()) {
				if (temp.equals(findIn)) {
					this.str = str.substring(findIn.length(), this.str.length());
					cont++;
					temp = "";
					i = -1;
				} else {
					temp = "";
					i = -1;
					this.str = (this.str.length() > 1) ? this.str.substring(1, this.str.length()) : this.str;
					
					if(this.str.length() <= 1) break;
				}
			}

		}
		
		return cont;
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
