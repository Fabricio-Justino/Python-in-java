package br.com.fabricio.python.util;

/**
 * this interface is an auxiliary to the Python class to make your value extracted
 * 
 * @author Fabricio Borges Justino
 *
 * @param <T>: type of element
 */
public interface EstractValue<T> {
	
	/**
	 * this method return an value defined by type T
	 * 
	 * @return : the value in T
	 */
	public T valueOf();
}
