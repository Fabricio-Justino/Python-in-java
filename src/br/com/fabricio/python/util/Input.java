package br.com.fabricio.python.util;

import java.util.Scanner;

public class Input {
	private String msg;
	private boolean nextLine;
	
	
	public Input(String msg) {
		this.msg = msg;
		this.nextLine = true;
	}

	public Input(String msg, boolean breakLine) {
		this.msg = msg;
		this.nextLine = breakLine;
	}

	public Input() {
		this.msg = "";
		this.nextLine = true;
	}

	public int nextInt() {
		System.out.print(this.msg);
		@SuppressWarnings("resource")
		int result = new Scanner(System.in).nextInt();

		if (this.nextLine)
			System.out.println("");

		return result;
	}

	public String nextString() {
		System.out.print(this.msg);
		@SuppressWarnings("resource")
		String result = new Scanner(System.in).nextLine();

		if (this.nextLine)
			System.out.println("");

		return result;
	}

	public double nextDouble() {
		System.out.print(this.msg);
		@SuppressWarnings("resource")
		double result = new Scanner(System.in).nextDouble();

		if (this.nextLine)
			System.out.println("");

		return result;
	}
	
	public float nextFloat() {
		System.out.print(this.msg);
		@SuppressWarnings("resource")
		float result = new Scanner(System.in).nextFloat();

		if (this.nextLine)
			System.out.println("");

		return result;
	}
	
	public long nextLong() {
		System.out.print(this.msg);
		@SuppressWarnings("resource")
		long result = new Scanner(System.in).nextLong();

		if (this.nextLine)
			System.out.println("");

		return result;
	}

}
