package br.com.itau.cpy.core.file.cobol.enuns;

public enum Extension {
	CPY(".cpy"), NOT_DEFINED("");
	
	private Extension(String extension) {
		this.extension = extension;
	}
	
	private String extension = null;
	
	public String getExtension() {
		return extension;
	}
}
