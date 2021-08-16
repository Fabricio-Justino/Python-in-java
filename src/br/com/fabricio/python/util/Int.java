package br.com.fabricio.python.util;

public class Int implements EstractValue<Integer> {
	private int value;
	
	
	public Int(int value) {
		this.value = value;
	}
	
	public Int(String value) {
		this.value = Integer.parseInt(value);
	}
	
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
