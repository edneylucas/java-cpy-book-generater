package br.com.itau.cpy.core.generator.impls;

import java.util.HashMap;
import java.util.Map;

import com.squareup.javapoet.TypeSpec.Builder;

import br.com.itau.cpy.core.generator.AbstractGenerator;
import br.com.itau.cpy.model.impls.CpyElement;

public abstract class AbstractCodeManager<Element extends CpyElement> extends AbstractGenerator {
	
	private Element element = null;
	private Builder builder = null;
	
	public AbstractCodeManager(Builder builder, Element element) {
		this.builder = builder;
		this.element = element;
	}
	
	protected Builder getBuilder() {
		return builder;
	}
	
	protected Element getElement() {
		return element;
	}
	
	protected String getNameField() {
		return getLowerCamelCaseName(getValue().getName());
	}
	
	protected String getFieldNameMethod() {
		return getUpperCamelCaseName(getValue().getName());
	}
	
	public abstract void create() throws Exception;
	
	public abstract Element getValue();
	
	Map<Object, Integer> orderCounter = new HashMap<Object, Integer>();	

	
	protected int getOrder() {

		Integer count = orderCounter.get(getBuilder());
		if (count == null) {
			count = 1;
		}
		orderCounter.put(getBuilder(), count + 1);

		return count;

	}

}
