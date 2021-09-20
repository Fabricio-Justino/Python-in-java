package br.com.fabricio.python.util;

import java.util.Arrays;
import java.util.Collection;

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Scanner;

import br.com.fabricio.python.classes.Input;
import br.com.fabricio.python.classes.Int;
import br.com.fabricio.python.classes.Open;
import br.com.fabricio.python.classes.Open.Type;
import br.com.fabricio.python.classes.Str;
import br.com.fabricio.python.exception.NumberExcedArgsException;

public class Python {

	/**
	 * create a Str class
	 * 
	 * @param string
	 * @return Str class
	 */
	public static Str str(String string) {
		return new Str(string);
	}

	/**
	 * print in console view el
	 * 
	 * @param <T>
	 * @param el: element to be printed
	 */
	public static <T> void print(T el) {
		System.out.println(el);
	}

	/**
	 * 
	 * @param <T>
	 * @param el  lement to be printed
	 * @param end end with an {@code end}
	 */
	public static <T> void print(T el, String end) {
		System.out.print(el + end);
	}

	/**
	 * 
	 * @param <T>
	 * @param el  lement to be printed
	 * @param end end with an {@code end}
	 */
	public static <T> void print(T el, Str end) {
		System.out.print(el + end.valueOf());
	}

	/**
	 * print on console view an el wrapped by wrapper
	 * 
	 * @param <T>
	 * @param el         elemetn that will be wrapped
	 * @param wrapper    String that will encapsulate the element(el)
	 * @param breakLines if true will jump irst line and last line
	 */
	public static <T> void printw(T el, String wrapper, boolean breakLines) {
		// if(wrapper.length() > el.toString().length()) throw new Exception();

		if (wrapper.length() > el.toString().length())
			printw(el); // I don't know what to do when the wrapper is bigger than el, so I take it to
						// default print

		final int rest = el.toString().length() % wrapper.length();

		if (rest == 0) {
			wrapper = wrapper.repeat(el.toString().length() / wrapper.length());
		} else {
			wrapper = wrapper.repeat(el.toString().length() / wrapper.length())
					+ wrapper.substring(0, (wrapper.length() - rest));
		}

		if (breakLines) {
			printf("\n{}\n{}\n{}\n", wrapper, el, wrapper);
		} else {
			printf("{}\n{}\n{}", wrapper, el, wrapper);
		}
	}

	/**
	 * print on console view an el wrapped by wrapper
	 * 
	 * @param <T>
	 * @param el      elemetn that will be wrapped
	 * @param wrapper String that will encapsulate the element(el)
	 */
	public static <T> void printw(T el, String wrapper) {
		// if(wrapper.length() > el.toString().length()) throw new Exception();

		if (wrapper.length() > el.toString().length())
			printw(el); // I don't know what to do when the wrapper is bigger than el, so I take it to
						// default print

		final int rest = el.toString().length() % wrapper.length();

		if (rest == 0) {
			wrapper = wrapper.repeat(el.toString().length() / wrapper.length());
		} else {
			wrapper = wrapper.repeat(el.toString().length() / wrapper.length())
					+ wrapper.substring(0, (wrapper.length() - rest));
		}

		printf("\n{}\n{}\n{}\n", wrapper, el, wrapper);
	}

	/**
	 * print on console view an el wrapped by "+-"
	 * 
	 * @param <T>
	 * @param el         elemetn that will be wrapped
	 * @param breakLines if true will jump irst line and last line
	 */
	public static <T> void printw(T el, boolean breakLines) {

		String wrapper = "-+";
		if (el.toString().length() % 2 == 0) {
			wrapper = wrapper.repeat(el.toString().length() / 2);
		} else {
			wrapper = wrapper.repeat(el.toString().length() / 2) + wrapper.charAt(0);
		}

		if (breakLines) {
			printf("\n{}\n{}\n{}\n", wrapper, el, wrapper);
		} else {
			printf("{}\n{}\n{}", wrapper, el, wrapper);
		}
	}

	/**
	 * print on console view an el wrapped by "+-"
	 * 
	 * @param <T>
	 * @param el  elemetn that will be wrapped
	 */
	public static <T> void printw(T el) {

		String wrapper = "-+";
		if (el.toString().length() % 2 == 0) {
			wrapper = wrapper.repeat(el.toString().length() / 2);
		} else {
			wrapper = wrapper.repeat(el.toString().length() / 2) + wrapper.charAt(0);
		}

		printf("\n{}\n{}\n{}\n", wrapper, el, wrapper);
	}

	/**
	 * print a table of values in two-dimensional array
	 * 
	 * @param array an object that will be printed
	 */
	public static void printTable(Object[][] array) {
		String el = "";
		for (int row = 0; row < array.length; row++) {
			for (int col = 0; col < array[row].length; col++) {
				if (col == 0) {
					el += "| " + array[row][col].toString() + " |";
				} else {
					el += " " + array[row][col].toString() + " |";
				}
			}
			printw(el, false);
			el = "";
		}
	}

	/**
	 * print a table of values in two-dimensional array
	 * 
	 * @param array   array an object that will be printed
	 * @param wrapper formatter of lines table
	 */
	public static void printTable(Object[][] array, String wrapper) {
		String el = "";
		for (int row = 0; row < array.length; row++) {
			for (int col = 0; col < array[row].length; col++) {
				if (col == 0) {
					el += "| " + array[row][col].toString() + " | ";
				} else {
					el += " " + array[row][col].toString() + " | ";
				}
			}
			printw(el, wrapper, false);
			el = "";
		}
	}

	/**
	 * print in console view the el formated
	 * 
	 * @param el:   string formated
	 * @param args: param that will replace {}(<- placeholder to variable) for args
	 *              in sequence
	 */
	public static void printf(String el, Object... args) {
		Objects.requireNonNull(args);
		if (args.length == 0)
			throw new NullPointerException();

		if (str(el).count("{}") != args.length) {
			throw new NumberExcedArgsException(new Throwable(
					"Number of {} is %d, Number of args is %d".formatted(str(el).count("{}"), args.length)));
		}

		for (Object obj : args) {
			el = el.replaceFirst("[{][}]", obj.toString());
		}
		print(el);
	}

	/**
	 * create the Int class with int value
	 * 
	 * @param value
	 * @return Int class
	 */
	public static Int ints(int value) {
		return new Int(value);
	}

	/**
	 * create Int class with String value
	 * 
	 * @param value: the current String will be converted to Int class
	 * @return Int class
	 */
	public static Int ints(String value) {
		return new Int(value);
	}

	/**
	 * create a input class
	 * 
	 * @return Input class
	 */
	public static Input input() {
		return new Input();
	}

	/**
	 * create a input class with msg thta appear in console view
	 * 
	 * @param msg
	 * @return Input class with conole message(msg)
	 */
	public static Input input(String msg) {
		return new Input(msg);
	}

	/**
	 * create a input class with msg that appear in console view
	 * 
	 * @param msg:       message that appears in console view
	 * @param breakLine: if true jump one line
	 * @return Input class with message(msg)
	 */
	public static Input input(String msg, boolean breakLine) {
		return new Input(msg, breakLine);
	}

	/**
	 * create a input class with msg that appear in console view
	 * 
	 * @param msg: message that appears in console view
	 * @return Input class with message(msg)
	 */
	public static Input input(Str msg) {
		return new Input(msg);
	}

	/**
	 * create a input class with msg that appear in console view
	 * 
	 * @param msg:       message that appears in console view
	 * @param breakLine: if true jump one line
	 * @return Input class with message(msg)
	 */
	public static Input input(Str msg, boolean breakLine) {
		return new Input(msg, breakLine);
	}

	/**
	 * return a string defined by user with and show msg in console view
	 * 
	 * @param msg String that will appear in console view before ask to user
	 * @return String typed by user
	 */
	public static String inputs(String msg) {
		print(msg);
		@SuppressWarnings("resource")
		String result = new Scanner(System.in).nextLine();

		return result;
	}

	/**
	 * return a string defined by user with and show msg in console view
	 * 
	 * @param msg Str that will appear in console view before ask to user
	 * @return String typed by user
	 */
	public static String inputs(Str msg) {
		print(msg);
		@SuppressWarnings("resource")
		String result = new Scanner(System.in).nextLine();

		return result;
	}

	/**
	 * return a String typed by user
	 * 
	 * @return String typed by user
	 */
	public static String inputs() {
		@SuppressWarnings("resource")
		String result = new Scanner(System.in).nextLine();

		return result;
	}

	/**
	 * 
	 * @param path local or archive
	 * @return class Open
	 */
	public static Open open(String path) {
		return new Open(path);
	}

	/**
	 * 
	 * @param path local or archive
	 * @param type of open r(reader) or w(writer)
	 * @return class Open
	 */
	public static Open open(String path, char type) {
		return new Open(path, type);
	}

	/**
	 * 
	 * @param path local or archive
	 * @param type of Open Reader or Writer
	 * @return class Open
	 */
	public static Open open(String path, Type type) {
		return new Open(path, type);
	}

	/**
	 * 
	 * @param path local or archive
	 * @return class Open
	 */
	public static Open open(Str path) {
		return new Open(path);
	}

	/**
	 * 
	 * @param path local or archive
	 * @param type of open r(reader) or w(writer)
	 * @return class Open
	 */
	public static Open open(Str path, char type) {
		return new Open(path, type);
	}

	/**
	 * 
	 * @param path local or archive
	 * @param type of Open Reader or Writer
	 * @return class Open
	 */
	public static Open open(Str path, Type type) {
		return new Open(path, type);
	}

	/**
	 * this method sort your elements
	 * 
	 * @param <T>
	 * @param array to be rodened
	 * 
	 */
	public static <T extends Comparable<? super T>> void sort(T[] array) {
		for (int i = 0; i < array.length; i++) {
			if (i < array.length - 1 && array[i].compareTo(array[i + 1]) >= 1) {
				swap(array, i, i + 1);
				i = -1;
			}
		}

	}
	
	public static <T extends Comparable<? super T>> void quicksort(T[] array) {
		Objects.requireNonNull(array);		
		if(len(array) <= 1) {
			return;
		}
		
		quicksort(array, 0, array.length-1);				
	}
	
	/**
	 * this is the true core of quicksort
	 * 
	 * @param <T>
	 * @param array
	 * @param start
	 * @param end
	 */
	private static <T extends Comparable<? super T>> void quicksort(T[] array, int start, int end) {
		if(start > end) {
			return;
		}
		
		int pivot = partition(array, start, end);
		quicksort(array, start, pivot-1);
		quicksort(array, pivot+1, end);
	}
	
	/**
	 * this method is auxiliar to do the partition of quiksort
	 * 
	 * @param <T>
	 * @param array
	 * @param start
	 * @param end
	 * @return
	 */
	private static <T extends Comparable<? super T>> int partition(T[] array, int start, int end) {
		T pivot = array[end];
		int j = start;	
		
		for(int i = start; i < end; i++) {
			if(array[i].compareTo(pivot) < 0) {
				swap(array, i, j);
				j++;
			} 
		}
		
		swap(array, j, end);
		return j;
	}
	
	public static <T> void quicksort(T[] array, Comparator<? super T> comparator) {
		Objects.requireNonNull(array);		
		if(len(array) <= 1) {
			return;
		}
		
		quicksort(array, 0, array.length-1, comparator);				
	}
	
	/**
	 * this is the true core of quicksort
	 * 
	 * @param <T>
	 * @param array
	 * @param start
	 * @param end
	 */
	private static <T> void quicksort(T[] array, int start, int end,  Comparator<? super T> comparator) {
		if(start > end) {
			return;
		}
		
		int pivot = partition(array, start, end, comparator);
		quicksort(array, start, pivot-1, comparator);
		quicksort(array, pivot+1, end, comparator);
	}
	
	/**
	 * this method is auxiliar to do the partition of quiksort
	 * 
	 * @param <T>
	 * @param array
	 * @param start
	 * @param end
	 * @return
	 */
	private static <T> int partition(T[] array, int start, int end,  Comparator<? super T> comparetor) {
		T pivot = array[end];
		int j = start;	
		for(int i = start; i < end; i++) {
			if(comparetor.compareTo(array[i], pivot) < 0) {
				swap(array, i, j);
				j++;
			} 
		}
		
		swap(array, j, end);
		return j;
	}
	
	

	/**
	 * this method shifts the position of the first to the second indexes given
	 * 
	 * @param <T>
	 * @param array  to shift it position
	 * @param index1 fisrt index of element
	 * @param index2 second index of element
	 */
	public static <T> void swap(T array[], int index1, int index2) {
		if ((index1 >= array.length || index1 < 0) || (index2 >= array.length || index2 < 0)) {
			throw new NoSuchElementException();
		}
		
		if(index1 == index2) {
			return;
		}

		T el = array[index1];
		array[index1] = array[index2];
		array[index2] = el;
	}
	
	/**
	 * this method made the sum of all numbers into the array, then return it as double
	 * 
	 * @param array that will be used to make the sum
	 * @return the sum of all numbers into the array
	 */
	public static <T extends Number> double sum(T[] array) {
		return Arrays.asList(array).stream().mapToDouble(T::doubleValue).sum();
	}
	
	/**
	 * this method made the sum of all numbers into the array, then return it as double
	 * 
	 * @param array that will be used to make the sum
	 * @return the sum of all numbers into the array
	 */
	public static <T extends Number> double sum(Collection<T> array) {
		return array.stream().mapToDouble(T::doubleValue).sum();
	}
	
	/**
	 * this method made the average of the numbers into the array, then return it as double
	 * 
	 * @param array that will be used to make the average numbers
	 * @return the average of all numbers into the array
	 */
	public static <T extends Number> double average(T[] array) {
		return Arrays.asList(array).stream().mapToDouble(T::doubleValue).average().getAsDouble();
	}
	
	/**
	 * this method made the average of the numbers into the array, then return it as double
	 * 
	 * @param array that will be used to make the average numbers
	 * @return the average of all numbers into the array
	 */
	public static <T extends Number> double average(Collection<T> array) {
		return array.stream().mapToDouble(T::doubleValue).average().getAsDouble();
	}

	/**
	 * 
	 * @param <T>
	 * @param array
	 * @return size of array
	 */
	public static <T> int len(T[] array) {
		return array.length;
	}

	/**
	 * 
	 * @param <T>
	 * @param array
	 * @return size of array
	 */
	public static <T> int len(Collection<? super T> array) {
		return array.size();
	}

	/**
	 * 
	 * @param <T>
	 * @param String
	 * @return length of the Strign
	 */
	public static int len(String string) {
		return string.length();
	}

}
