package br.com.itau.cpy.core.generator;

import java.io.IOException;

import javax.lang.model.element.Modifier;

import com.squareup.javapoet.AnnotationSpec;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.TypeSpec;
import com.squareup.javapoet.TypeSpec.Builder;

import br.com.itau.cpy.core.generator.impls.field.CreateField;
import br.com.itau.cpy.core.generator.impls.register.CreateRegister;
import br.com.itau.cpy.core.properties.model.GeneratorProperties;
import br.com.itau.cpy.model.CpyBook;
import br.com.itau.cpy.model.Field;
import br.com.itau.cpy.model.Register;
import br.com.itau.cpy.model.impls.CpyElement;
import br.com.wipro.cpyjavacore.api.annotation.CopyBook;

public class ClassGenerator extends AbstractGenerator {

	private GeneratorProperties properties = null;
	
	private CpyBook cpyBook = null;
	
	public ClassGenerator(GeneratorProperties properties, CpyBook cpyBook) {
		this.properties = properties;
		this.cpyBook = cpyBook;
	}
	
	public void create() {
		try {
			for (CpyElement element : cpyBook.getElements()) {
				if (element instanceof Register) {
					new CreateRegister(getBuilder(), (Register) element, properties).create();
				} else if (element instanceof Field) {
					new CreateField(getBuilder(), (Field) element).create();
				}
			}
			write();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private ClassName getClassName() {
		return ClassName.get(properties.getPackageName(), getUpperCamelCaseName(cpyBook.getName()));
	}

	private Builder builder = null;
	
	private Builder getBuilder() {
		if (builder == null) {
			builder = TypeSpec.classBuilder(getClassName());
			builder.addModifiers(Modifier.PUBLIC);
			builder.addAnnotation(getAnnotation());
		}
		return builder;
	}
	
	public AnnotationSpec getAnnotation() {
		com.squareup.javapoet.AnnotationSpec.Builder builder = AnnotationSpec.builder(CopyBook.class);
		builder.addMember("totalBytes", "$S", cpyBook.getTotalBytes());
		builder.addMember("name", "$S", cpyBook.getName());
		return builder.build();
	}
	
	private void write() throws IOException {
		JavaFile javaFile = JavaFile.builder(properties.getPackageName(), getBuilder().build()).build();
		javaFile.writeTo(properties.getFileCpyJava());
	}
}
