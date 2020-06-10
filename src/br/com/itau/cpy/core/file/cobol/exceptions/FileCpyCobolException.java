package br.com.itau.cpy.core.file.cobol.exceptions;

public class FileCpyCobolException extends Exception {

	private static final long serialVersionUID = 5882377745548827383L;

	public FileCpyCobolException() {
		super();
	}

	public FileCpyCobolException(String message, Throwable cause) {
		super(message, cause);
	}

	public FileCpyCobolException(String message) {
		super(message);
	}

	public FileCpyCobolException(Throwable cause) {
		super(cause);
	}
}