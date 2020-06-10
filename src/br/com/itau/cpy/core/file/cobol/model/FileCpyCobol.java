package br.com.itau.cpy.core.file.cobol.model;

import java.io.File;

public class FileCpyCobol {

	private String name = null;

	public FileCpyCobol(File file, StringBuilder builder) {
		setCpyBook(builder.toString());
		setName(file.getName().toUpperCase().split("\\.")[0]);
	}

	public String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}
	
	private String cpyBook = null;

	public String getCpyBook() {
		return cpyBook;
	}

	private void setCpyBook(String cpyBook) {
		this.cpyBook = cpyBook;
	}
}
