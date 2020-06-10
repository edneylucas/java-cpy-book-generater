package br.com.itau.cpy.core.properties;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import br.com.itau.cpy.core.properties.exceptions.PropertiesException;
import br.com.itau.cpy.core.properties.model.GeneratorProperties;

public class GeneratorPropertiesManager {

	private static final String PATH_PROPERTIES = "./config/cpybookjavagenerator.properties";

	private Properties properties = null;

	private static final String EMPTY_VALUE = "";

	private Properties loadProperties() throws PropertiesException {
		if (properties == null) {
			try {
				properties = new Properties();
				properties.load(new FileInputStream(PATH_PROPERTIES));
			} catch (Exception e) {
				throw new PropertiesException("Arquivo properties não localizado: " + PATH_PROPERTIES);
			}
		}
		return properties;
	}

	public GeneratorProperties getProperties() throws PropertiesException {
		GeneratorProperties model = new GeneratorProperties();
		if (properties.getProperty("package.name") != null && !EMPTY_VALUE.equals(properties.getProperty("package.name"))) {
			model.setPackageName(properties.getProperty("package.name"));
		} else {
			throw new PropertiesException("package.name vazio ou não localizado");
		}
		
		if (properties.getProperty("file.copybook.cobol") != null && !EMPTY_VALUE.equals(properties.getProperty("file.copybook.cobol"))) {
			model.setFileCpyCobol(new File(properties.getProperty("file.copybook.cobol")));
		} else {
			throw new PropertiesException("file.copybook.cobol vazio ou não localizado");
		}
		
		if (properties.getProperty("file.copybook.java") != null && !EMPTY_VALUE.equals(properties.getProperty("file.copybook.java"))) {
			model.setFileCpyJava(new File(properties.getProperty("file.copybook.java")));
		} else {
			throw new PropertiesException("file.copybook.java vazio ou não localizado");
		}

		return model;
	}

	public GeneratorPropertiesManager() throws PropertiesException {
		loadProperties();
	}
}