package br.com.itau.cpy.core.generator;

public abstract class AbstractGenerator {

	protected String getUpperCamelCaseName(String originalName) {
		String lowerCamelCaseName = getLowerCamelCaseName(originalName);
		return lowerCamelCaseName.substring(0, 1).toUpperCase() + lowerCamelCaseName.substring(1);
	}

	protected String getLowerCamelCaseName(String originalName) {
		String[] partNames = originalName.split("\\W");
		StringBuilder returnString = new StringBuilder();
		int initialIndex = 0;
		if (partNames.length > initialIndex) {
			returnString.append(partNames[initialIndex].substring(0, 1).toLowerCase() + partNames[initialIndex].substring(1).toLowerCase());
			for (int i = initialIndex+1; i < partNames.length; i++) {
				returnString.append(partNames[i].substring(0, 1).toUpperCase() + partNames[i].substring(1).toLowerCase());
			}
		} else {
			returnString.append(partNames[0].substring(0, 1).toLowerCase() + partNames[0].substring(1).toLowerCase());
		}
		return returnString.toString();
	}
}
