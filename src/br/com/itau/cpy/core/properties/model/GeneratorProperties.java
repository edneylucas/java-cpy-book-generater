package br.com.itau.cpy.core.properties.model;

import java.io.File;

public class GeneratorProperties {

	private String packageName = null;

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	} 
	
	private File fileCpyCobol = null;

	public File getFileCpyCobol() {
		return fileCpyCobol;
	}

	public void setFileCpyCobol(File fileCpyCobol) {
		this.fileCpyCobol = fileCpyCobol;
	}
	
	private File fileCpyJava = null;

	public File getFileCpyJava() {
		return fileCpyJava;
	}

	public void setFileCpyJava(File fileCpyJava) {
		this.fileCpyJava = fileCpyJava;
	}
	
	@Override
	public String toString() {
		return "[ packageName: " + getPackageName() + " | fileCpyCobol: " + getFileCpyCobol() +" | fileCpyJava: "+ getFileCpyJava() +" ]" ;
	}
}
