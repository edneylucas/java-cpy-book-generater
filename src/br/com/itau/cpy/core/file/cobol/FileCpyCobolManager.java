package br.com.itau.cpy.core.file.cobol;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.itau.cpy.core.file.cobol.enuns.Extension;
import br.com.itau.cpy.core.file.cobol.exceptions.FileCpyCobolException;
import br.com.itau.cpy.core.file.cobol.model.FileCpyCobol;

public class FileCpyCobolManager implements FileFilter {

	private List<File> files = null;
	
	public FileCpyCobolManager(File file) {
		this.files = Arrays.asList(file.listFiles(this));
	}

	public List<FileCpyCobol> getFiles() throws FileCpyCobolException {
		List<FileCpyCobol> list = new ArrayList<FileCpyCobol>();
		try {
			if (files != null && files.size() != 0) {
				for (File file : files) {
					FileInputStream inputStream = new FileInputStream(file);
					byte[] buffer = new byte[1024];
					
					StringBuilder builder = new StringBuilder();
					while (inputStream.read(buffer) != -1) {
						builder.append(new String(buffer));
						buffer = new byte[1024];
					}
					inputStream.close();
					list.add(new FileCpyCobol(file, builder));
				}
			} else {
				throw new FileCpyCobolException("Não existe arquivo cpybook na pasta");
			}
		} catch (IOException e) {
			throw new FileCpyCobolException(e);
		}
		return list;
	}
	
	public boolean accept(File pathname) {
		return pathname.getAbsolutePath().endsWith(Extension.CPY.getExtension());
	}
}
