package br.com.fabricio.python.util;

import java.util.Objects;
import java.util.Scanner;

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
	 * print in console view the el formated
	 * 
	 * @param el:   string formated
	 * @param args: param that will replace {}(<- placeholder to variable) for args
	 *              in sequence
	 */
	public static void printf(String el, Object... args) {
		Objects.requireNonNull(args);
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
	 * @param msg: message that appears in console view
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
	 * @param msg: message that appears in console view
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
	

}
