package br.com.fabricio.python.exception;

public class TypeNotSupportedException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public TypeNotSupportedException() {
		super("Open doesn't providence this type");
	}
	
	public TypeNotSupportedException(String msg) {
		super(msg);
	}
	
	public TypeNotSupportedException(String msg, Throwable cause) {
		super(msg, cause);
	}
	
	public TypeNotSupportedException(Throwable cause) {
		super("Open doesn't providence this type", cause);
	}
	

}
