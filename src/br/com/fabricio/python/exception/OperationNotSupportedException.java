package br.com.fabricio.python.exception;

public class OperationNotSupportedException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public OperationNotSupportedException(String msg) {
		super("this operation is not supported to type " + msg);
	}

}
