package br.com.itau.cpy.core.properties.exceptions;

public class PropertiesException extends Exception {

	private static final long serialVersionUID = 5882377745548827383L;

	public PropertiesException() {
		super();
	}

	public PropertiesException(String message, Throwable cause) {
		super(message, cause);
	}

	public PropertiesException(String message) {
		super(message);
	}

	public PropertiesException(Throwable cause) {
		super(cause);
	}
}