package br.com.itau.cpy.core.generator.impls.field.exceptions;

public class FieldException extends Exception {

	private static final long serialVersionUID = 5882377745548827383L;

	public FieldException() {
		super();
	}

	public FieldException(String message, Throwable cause) {
		super(message, cause);
	}

	public FieldException(String message) {
		super(message);
	}

	public FieldException(Throwable cause) {
		super(cause);
	}
}