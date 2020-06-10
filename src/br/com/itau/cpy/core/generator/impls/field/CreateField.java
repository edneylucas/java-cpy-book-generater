package br.com.itau.cpy.core.generator.impls.field;

import java.math.BigDecimal;

import javax.lang.model.element.Modifier;

import com.squareup.javapoet.AnnotationSpec;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec.Builder;

import br.com.itau.cpy.core.generator.impls.AbstractCodeManager;
import br.com.itau.cpy.core.generator.impls.field.exceptions.FieldException;
import br.com.itau.cpy.model.Field;
import br.com.itau.cpy.model.enuns.Type;

public class CreateField extends AbstractCodeManager<Field> {

	public CreateField(Builder builder, Field field) {
		super(builder, field);
	}

	@Override
	public void create() throws FieldException {
		if (getBuilder() != null) {
			try {
				FieldSpec field = createField();
				getBuilder().addField(field);
			} catch (Exception e) {
				throw new FieldException();
			}
			
			try {
				MethodSpec setMethod = createSetMethod();
				getBuilder().addMethod(setMethod);
			} catch (Exception e) {
				throw new FieldException();
			}
			
			try {
				MethodSpec getMethod = createGetMethod();
				getBuilder().addMethod(getMethod);
			} catch (Exception e) {
				throw new FieldException();
			}
		} else {
			throw new FieldException();
		}
	}

	@Override
	public Field getValue() {
		return (Field) getElement();
	}
	
	private AnnotationSpec getAnnotation() {
		try {
			com.squareup.javapoet.AnnotationSpec.Builder annotationBuilder = AnnotationSpec.builder(Field.class);

			annotationBuilder.addMember("order", "$S", getOrder());
			annotationBuilder.addMember("name", "$S", getValue().getName());
			annotationBuilder.addMember("parent", "$S", getValue().getParent().getName());
			annotationBuilder.addMember("pic", "$S", getValue().getPIC());
			annotationBuilder.addMember("type", "$S", getValue().getType());
			annotationBuilder.addMember("bytes", "$S", getValue().getBytes());

			if (getValue().getDecimals() > 0) {
				annotationBuilder.addMember("decimals", "$S", getValue().getDecimals());
			}
			if (getValue().getDependsOccurs() != null) {
				annotationBuilder.addMember("dependsOccurs", "$S", getValue().getDependsOccurs());
			}
			if (getValue().getDependsType() != null && !"number".equals(getValue().getDependsType())) {
				annotationBuilder.addMember("dependsType", "$S", getValue().getDependsType());
			}
			if (getValue().getDependsValues() != null) {
				annotationBuilder.addMember("dependsValues", "$S", getValue().getDependsValues());
			}
			if (getValue().getLength() > 0) {
				annotationBuilder.addMember("length", "$S", getValue().getLength());
			}
			if (getValue().getMaxOccurs() > 1) {
				annotationBuilder.addMember("maxOccurs", "$S", getValue().getMaxOccurs());
			}
			if (getValue().getMinOccurs() > 1) {
				annotationBuilder.addMember("minOccurs", "$S", getValue().getMinOccurs());
			}
			if (getValue().getUsage() != null && !"DISPLAY".equals(getValue().getUsage())) {
				annotationBuilder.addMember("usage", "$S", getValue().getUsage());
			}
			if (getValue().getSign() != null && !"nosign".equals(getValue().getSign())) {
				annotationBuilder.addMember("sign", "$S", getValue().getSign());
			}
			if (getValue().getValue() != null) {
				annotationBuilder.addMember("defaultValue", "$S", getValue().getValue());
			}
			
			return annotationBuilder.build();
		} catch (Exception e) {
			return null;
		}
	}
	
	private FieldSpec createField() {
		try {
			com.squareup.javapoet.FieldSpec.Builder builder = FieldSpec.builder(getTypeField(), getNameField());
			builder.addModifiers(Modifier.PRIVATE);
			builder.addAnnotation(getAnnotation());
			return builder.build();
		} catch (Exception e) {
			return null;
		}
	}

	private MethodSpec createSetMethod() {
		try {
			com.squareup.javapoet.MethodSpec.Builder methodBuilder = MethodSpec.methodBuilder("set" + getFieldNameMethod()); 
			methodBuilder.addModifiers(Modifier.PUBLIC);
			methodBuilder.addParameter(getTypeField(), getNameField());
			methodBuilder.addStatement("this.$N = $N", getNameField(), getNameField());
			return methodBuilder.build();
		} catch (Exception e) {
			return null;
		}
	}
	
	private MethodSpec createGetMethod() {
		try {
			com.squareup.javapoet.MethodSpec.Builder builder = MethodSpec.methodBuilder("get" + getFieldNameMethod());
			builder.addModifiers(Modifier.PUBLIC);
			builder.returns(getTypeField());
			builder.addStatement("return $N", getNameField());
			return builder.build();
		} catch (Exception e) {
			return null;
		}
	}
	
	private Class<?> getTypeField() {
		if (Type.NUMERIC.equals(getValue().getType())) {
			if (getValue().getDecimals() > 0) {
				return BigDecimal.class;
			} else {
				if (getValue().getBytes() > 9) {
					return Long.class;
				} else {
					return Integer.class;
				}
			}
		} else {
			return String.class;
		}
	}
}
