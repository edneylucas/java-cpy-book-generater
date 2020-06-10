package br.com.itau.cpy.core.generator.impls.list;

import java.awt.List;
import java.io.IOException;
import java.util.ArrayList;

import javax.lang.model.element.Modifier;

import com.squareup.javapoet.AnnotationSpec;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.CodeBlock;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;
import com.squareup.javapoet.TypeSpec.Builder;

import br.com.itau.cpy.core.generator.impls.AbstractCodeManager;
import br.com.itau.cpy.core.generator.impls.field.CreateField;
import br.com.itau.cpy.core.generator.impls.field.exceptions.FieldException;
import br.com.itau.cpy.core.generator.impls.list.exceptions.ListException;
import br.com.itau.cpy.core.generator.impls.register.CreateRegister;
import br.com.itau.cpy.core.generator.impls.register.exceptions.RegisterException;
import br.com.itau.cpy.core.properties.model.GeneratorProperties;
import br.com.itau.cpy.model.Field;
import br.com.itau.cpy.model.Register;
import br.com.itau.cpy.model.impls.CpyElement;

public class CreateList extends AbstractCodeManager<Register> {

	private GeneratorProperties properties = null;

	public CreateList(Builder builder, Register register, GeneratorProperties properties) {
		super(builder, register);
		this.properties = properties;
	}

	@Override
	public void create() throws ListException, FieldException, RegisterException {
		if (getBuilder() != null) {
			addFields();
			
			for (CpyElement element : getValue().getElements()) {
				if (element instanceof Register) {
					new CreateRegister(getBuilderList(), (Register) element, properties).create();
				} else if (element instanceof Field) {
					new CreateField(getBuilderList(), (Field) element).create();
				}
			}
			
			write();
		} else {
			throw new ListException();
		}
	}

	@Override
	public Register getValue() {
		return (Register) getElement();
	}
	
	private Builder builderList = null;
	
	private Builder getBuilderList() {
		if (builderList == null) {
			builderList = TypeSpec.classBuilder(getClassName());
			builderList.addModifiers(Modifier.PUBLIC);
		}
		return builderList;
	}
	
	private ClassName getClassName() {
		return ClassName.get(properties.getPackageName() + ".list", getUpperCamelCaseName(getValue().getName()));
	}

	private TypeName getListinner() {
		return ParameterizedTypeName.get(ClassName.get("java.util", "List"), getClassName());
	}
	
	private void addFields() {
		try {
			FieldSpec createField = createField();
			getBuilder().addField(createField);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			MethodSpec addMethod = createAddMethod();
			getBuilder().addMethod(addMethod);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			MethodSpec getIndexMethod = createIndexMethod();
			getBuilder().addMethod(getIndexMethod);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			MethodSpec setMethod = createSetMethod();
			getBuilder().addMethod(setMethod);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			MethodSpec getMethod = createGetMethod();
			getBuilder().addMethod(getMethod);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	private FieldSpec createField() {
		com.squareup.javapoet.FieldSpec.Builder builder = FieldSpec.builder(getListinner(), getNameField());
		builder.addModifiers(Modifier.PRIVATE);
		builder.initializer(CodeBlock.builder().addStatement("new $T<$T>()", ArrayList.class, getClassName()).build());
		builder.addAnnotation(getAnnotation());
		return builder.build();
	}
	
	private MethodSpec createSetMethod() {
		com.squareup.javapoet.MethodSpec.Builder builder = MethodSpec.methodBuilder("set" + getFieldNameMethod()); 
		builder.addModifiers(Modifier.PUBLIC);
		builder.addParameter(getListinner(), getNameField());
		builder.addStatement("this.$N = $N", getNameField(), getNameField());
		return builder.build();
	}
	
	private MethodSpec createGetMethod() {
		com.squareup.javapoet.MethodSpec.Builder builder = MethodSpec.methodBuilder("get" + getFieldNameMethod());
		builder.addModifiers(Modifier.PUBLIC);
		builder.returns(getListinner());
		builder.addStatement("return $N", getNameField());
		return builder.build();
	}
	
	private MethodSpec createAddMethod() {
		com.squareup.javapoet.MethodSpec.Builder builder = MethodSpec.methodBuilder("add" + getFieldNameMethod());
		builder.addModifiers(Modifier.PUBLIC);
		builder.addParameter(getListinner(), getNameField());
		builder.addStatement("this.$N = $N", getNameField(), getNameField());
		return builder.build();
	}

	private MethodSpec createIndexMethod() {
		com.squareup.javapoet.MethodSpec.Builder builder = MethodSpec.methodBuilder("get" + getFieldNameMethod());
		builder.addModifiers(Modifier.PUBLIC);
		builder.addParameter(int.class, "index");
		builder.returns(getListinner());
		builder.addStatement("return this.$N.get(index)", getNameField());
		return builder.build();
	}
	
	private AnnotationSpec getAnnotation() {
		com.squareup.javapoet.AnnotationSpec.Builder builder = AnnotationSpec.builder(List.class);
		builder.addMember("order", "$S", getOrder());
		builder.addMember("dependsOccurs", "$S", getValue().getDependsOccurs());
		builder.addMember("dependsType", "$S", getValue().getDependsType());
		builder.addMember("dependsValues", "$S", getValue().getDependsValues() == null ? "": getValue().getDependsValues());
		builder.addMember("maxOccurs", "$S", getValue().getMaxOccurs());
		builder.addMember("minOccurs", "$S", getValue().getMinOccurs());
		builder.addMember("name", "$S", getValue().getName());
		builder.addMember("parent", "$S", getValue().getParent().getName());
		return builder.build();
	}
	
	private void write() {
		try {
			JavaFile javaFile = JavaFile.builder(properties.getPackageName() + ".list", getBuilderList().build()).build();
			javaFile.writeTo(properties.getFileCpyJava());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}
