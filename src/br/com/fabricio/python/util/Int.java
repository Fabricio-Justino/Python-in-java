package br.com.fabricio.python.util;

public class Int implements EstractValue<Integer> {
	private int value;
	
	/**
	 * 
	 * @param value Storaged By class Int
	 */
	public Int(int value) {
		this.value = value;
	}
	
	/**
	 * 
	 * @param value Storaged by class Int
	 * 
	 * @throws NumberFormatException when the current String isn't a int value
	 */
	public Int(String value) {
		this.value = Integer.parseInt(value);
	}
	
	/**
	 * 
	 * @param value Storaged by class Int
	 * 
	 * @throws NumberFormatException when the current Str isn't a int value
	 */
	public Int(Str value) {
		this.value = Integer.parseInt(value.valueOf());
	}
	
	/**
	 * default constructor storage Integer value = 0
	 */
	public Int() {
		this.value = 0;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + value;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Int other = (Int) obj;
		if (value != other.value)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("%d", value);
	}
	
	@Override
	public Integer valueOf() {
		return this.value;
	}

}
