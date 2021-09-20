package br.com.fabricio.python.util;

@FunctionalInterface
public interface Comparator <T extends Comparable<? super T>>{	
	
	public abstract int compareTo(T value1, T value2);		
}
