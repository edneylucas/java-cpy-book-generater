package br.com.itau.cpy;
import java.util.List;

import org.slf4j.LoggerFactory;

import br.com.itau.cpy.core.file.cobol.FileCpyCobolManager;
import br.com.itau.cpy.core.file.cobol.exceptions.FileCpyCobolException;
import br.com.itau.cpy.core.file.cobol.model.FileCpyCobol;
import br.com.itau.cpy.core.generator.ClassGenerator;
import br.com.itau.cpy.core.properties.GeneratorPropertiesManager;
import br.com.itau.cpy.core.properties.exceptions.PropertiesException;
import br.com.itau.cpy.exception.CopybookException;

public class CodeGenerator {
	
	private static org.slf4j.Logger log = LoggerFactory.getLogger(CodeGenerator.class);
	
	public static void main(String[] args) {
		try {
			log.info(".:: Inicialização do API CodeGenerator ::.");
			
			GeneratorPropertiesManager properties = new GeneratorPropertiesManager();
			List<FileCpyCobol> listaFileCpyCobol = new FileCpyCobolManager(properties.getProperties().getFileCpyCobol()).getFiles();
			for (FileCpyCobol model : listaFileCpyCobol) {
				
				log.info("Aguarde inicializando o code generator da cpybook: {}", model.getName());
				new ClassGenerator(properties.getProperties(), CpyBookManager.generate(model.getCpyBook(), model.getName())).create();
			}
		} catch (PropertiesException e) {
			log.error("Properties: {}", e.getMessage());
		} catch (FileCpyCobolException e) {
			log.error("FileCpyBook: {}", e.getMessage());
		} catch (CopybookException e) {
			log.error("Erro no copy", e);
		} finally {
			log.info(".:: Finalizando ao API CodeGenerator ::.");
		}
	}

}
