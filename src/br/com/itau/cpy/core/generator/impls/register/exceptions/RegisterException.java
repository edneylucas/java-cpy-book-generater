package br.com.itau.cpy.core.generator.impls.register.exceptions;

public class RegisterException extends Exception {

	private static final long serialVersionUID = 5882377745548827383L;

	public RegisterException() {
		super();
	}

	public RegisterException(String message, Throwable cause) {
		super(message, cause);
	}

	public RegisterException(String message) {
		super(message);
	}

	public RegisterException(Throwable cause) {
		super(cause);
	}
}