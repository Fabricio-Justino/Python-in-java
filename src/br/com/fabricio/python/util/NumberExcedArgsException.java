package br.com.fabricio.python.util;

public class NumberExcedArgsException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	
	public NumberExcedArgsException() {
		super("Number of args is not equal to the number of argument");
	}
	
	public NumberExcedArgsException(String msg) {
		super(msg);
	}
	
	public NumberExcedArgsException(String msg, Throwable cause) {
		super(msg, cause);
	}
	
	public NumberExcedArgsException(Throwable cause) {
		super("Number of args is not equal to the number of argument",cause);
	}

}
