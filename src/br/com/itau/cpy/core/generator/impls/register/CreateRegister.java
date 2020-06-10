package br.com.itau.cpy.core.generator.impls.register;

import com.squareup.javapoet.TypeSpec.Builder;

import br.com.itau.cpy.core.generator.impls.AbstractCodeManager;
import br.com.itau.cpy.core.generator.impls.field.CreateField;
import br.com.itau.cpy.core.generator.impls.field.exceptions.FieldException;
import br.com.itau.cpy.core.generator.impls.list.CreateList;
import br.com.itau.cpy.core.generator.impls.list.exceptions.ListException;
import br.com.itau.cpy.core.generator.impls.register.exceptions.RegisterException;
import br.com.itau.cpy.core.properties.model.GeneratorProperties;
import br.com.itau.cpy.model.Field;
import br.com.itau.cpy.model.Register;
import br.com.itau.cpy.model.impls.CpyContainer;
import br.com.itau.cpy.model.impls.CpyElement;

public class CreateRegister extends AbstractCodeManager<Register> {
	
	private GeneratorProperties properties = null;
	
	public CreateRegister(Builder builder, Register register, GeneratorProperties properties) {
		super(builder, register);
		this.properties = properties;
	}

	@Override
	public void create() throws RegisterException, ListException, FieldException {
		if (getValue().getMaxOccurs() > 1) {
			if (getValue().getDependsOccurs() != null) {
				CpyContainer parent = getValue().getParent();
				while (((Field) parent.getElement(getValue().getDependsOccurs())) == null) {
					parent = parent.getParent();
				}
			}
			new CreateList(getBuilder(), getValue(), properties).create();
		} else {
			for (CpyElement element : getValue().getElements()) {
				if (element instanceof Register) {
					new CreateRegister(getBuilder(), (Register) element, properties).create();
				} else if (element instanceof Field) {
					new CreateField(getBuilder(), (Field) element).create();
				}
			}
		}
	}

	@Override
	public Register getValue() {
		return (Register) getElement();
	}
}
