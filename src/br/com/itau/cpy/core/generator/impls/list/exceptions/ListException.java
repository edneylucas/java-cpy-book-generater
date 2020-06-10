package br.com.itau.cpy.core.generator.impls.list.exceptions;

public class ListException extends Exception {

	private static final long serialVersionUID = 5882377745548827383L;

	public ListException() {
		super();
	}

	public ListException(String message, Throwable cause) {
		super(message, cause);
	}

	public ListException(String message) {
		super(message);
	}

	public ListException(Throwable cause) {
		super(cause);
	}
}