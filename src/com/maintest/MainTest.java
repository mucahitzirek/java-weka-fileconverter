package com.maintest;

import java.io.*;

import com.conversion.Converter;
import com.converter.DataConverterSelect;
import com.converterArffTo.impl.ConversionArffToCsv;
import com.converterDataToArff.impl.ConversionCsvToArff;

public class MainTest {

	static DataConverterSelect jsonArff = new ConversionCsvToArff();
	
	static DataConverterSelect arfftoCsv=new ConversionArffToCsv();
	
	public static void main(String[] args) throws IOException {

		Converter converter2 = new Converter(new File("deneme.csv"), new File("deneme.arff"));
		converter2.setConverterFile(jsonArff);
		converter2.convert();

		
	}

}
