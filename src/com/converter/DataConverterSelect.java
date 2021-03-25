package com.converter;

import java.io.File;
import java.io.IOException;

public interface DataConverterSelect {

	void convert(File selectedFile, File converterFile) throws IOException;

}
