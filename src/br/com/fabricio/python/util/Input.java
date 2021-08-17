package br.com.fabricio.python.util;

import java.util.Scanner;

public class Input {
	private String msg;
	private boolean nextLine;
	
	/**
	 *  
	 * @param msg: this String will be showed in console view
	 */
	public Input(String msg) {
		this.msg = msg;
		this.nextLine = true;
	}

	/**
	 *  
	 * @param msg: this String will be showed in console view
	 */
	public Input(String msg, boolean breakLine) {
		this.msg = msg;
		this.nextLine = breakLine;
	}
	
	/**
	 * 
	 * @param msg
	 */
	public Input(Str msg) {
		this.msg = msg.valueOf();
		this.nextLine = true;
	}
	
	/**
	 * 
	 * @param msg: this Str will be showed in console view
	 * @param breakLine: it definies if the next message will jump one line
	 */
	public Input(Str msg, boolean breakLine) {
		this.msg = msg.valueOf();
		this.nextLine = breakLine;
	}
	
	/**
	 * default constructor
	 */
	public Input() {
		this.msg = "";
		this.nextLine = true;
	}
	
	/**
	 * 
	 * @return Integer value typed by useer
	 */
	public int nextInt() {
		System.out.print(this.msg);
		@SuppressWarnings("resource")
		int result = new Scanner(System.in).nextInt();

		if (this.nextLine)
			System.out.println("");

		return result;
	}
	
	/**
	 * 
	 * @return String argument typed by useer
	 */
	public String nextString() {
		System.out.print(this.msg);
		@SuppressWarnings("resource")
		String result = new Scanner(System.in).nextLine();

		if (this.nextLine)
			System.out.println("");

		return result;
	}
	
	/**
	 * 
	 * @return Double value typed by useer
	 */
	public double nextDouble() {
		System.out.print(this.msg);
		@SuppressWarnings("resource")
		double result = new Scanner(System.in).nextDouble();

		if (this.nextLine)
			System.out.println("");

		return result;
	}
	
	/**
	 * 
	 * @return Float value typed by useer
	 */
	public float nextFloat() {
		System.out.print(this.msg);
		@SuppressWarnings("resource")
		float result = new Scanner(System.in).nextFloat();

		if (this.nextLine)
			System.out.println("");

		return result;
	}
	
	/**
	 * 
	 * @return Long value typed by useer
	 */
	public long nextLong() {
		System.out.print(this.msg);
		@SuppressWarnings("resource")
		long result = new Scanner(System.in).nextLong();

		if (this.nextLine)
			System.out.println("");

		return result;
	}
	
	/**
	 * 
	 * @return Int classe typed by user
	 */
	public Int pyInt() {
		System.out.print(this.msg);
		@SuppressWarnings("resource")
		int result = new Scanner(System.in).nextInt();

		if (this.nextLine)
			System.out.println("");

		return new Int(result);
	}
	
	/**
	 * 
	 * @return Str class typed by user
	 */
	public Str str() {
		System.out.print(this.msg);
		@SuppressWarnings("resource")
		String result = new Scanner(System.in).nextLine();

		if (this.nextLine)
			System.out.println("");

		return new Str(result);
	}

}
