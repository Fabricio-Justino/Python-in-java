package br.com.fabricio.python.util;

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

}
