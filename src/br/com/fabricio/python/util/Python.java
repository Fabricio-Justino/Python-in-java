package br.com.fabricio.python.util;

import java.util.Scanner;

public class Python {
	
	public static Str str(String string) {
		return new Str(string);
	}
	
	public static<T> void print(T el) {
		System.out.println(el);
	}
	
	public static<T> void printf(T el, Object ...arg) {
		
	}
	
	public static Int ints(int value) {
		return new Int(value);
	}
	
	public static Int ints(String value){
		return new Int(value);
	}
	
	public static Input input() {
		return new Input();
	}
	
	public static Input input(String msg) {
		return new Input(msg);
	}
	
	public static Input input(String msg, boolean breakLine) {
		return new Input(msg, breakLine);
	}
	
	public static String inputs(String msg) {
		System.out.print(msg);
		@SuppressWarnings("resource")
		String result = new Scanner(System.in).nextLine();

		return result;
	}
	
	public static String inputs() {
		@SuppressWarnings("resource")
		String result = new Scanner(System.in).nextLine();

		return result;
	}
	
}
