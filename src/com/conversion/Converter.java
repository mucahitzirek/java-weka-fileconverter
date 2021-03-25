package com.conversion;

import java.io.File;
import java.io.IOException;

import com.converter.DataConverterSelect;

public class Converter {

	DataConverterSelect converterFile;
	File selectedFile, convertedFileName;

	public Converter(File selectedFile, File convertedFileName) {
		this.selectedFile = selectedFile;
		this.convertedFileName = convertedFileName;
	}

	public void setConverterFile(DataConverterSelect converterFile) {
		this.converterFile = converterFile;
	}

	//start converter 
	public void convert() throws IOException {

		converterFile.convert(selectedFile, convertedFileName);
	}

}
