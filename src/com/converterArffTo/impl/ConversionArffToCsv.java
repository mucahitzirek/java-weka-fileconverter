package com.converterArffTo.impl;

import java.io.File;
import java.io.IOException;

import com.converter.DataConverterSelect;

import weka.core.Instances;
import weka.core.converters.ArffLoader;
import weka.core.converters.CSVSaver;

public class ConversionArffToCsv implements DataConverterSelect {

	/*
	 * Converter Arff File -> Csv File
	 * 
	 */
	
	@Override
	public void convert(File selectedFile, File converterFile) {

		Instances instancesData = null;
		ArffLoader arffLoader = new ArffLoader();
		try {
			if (selectedFile.exists()) {
				arffLoader.setSource(selectedFile);
				instancesData = arffLoader.getDataSet();
			}
		} catch (IOException e) {
			System.out.println("Hata instancesData : " + e.getMessage());
		}
		CSVSaver csvSaver = new CSVSaver();
		csvSaver.setInstances(instancesData);
		try {
			csvSaver.setFile(converterFile);
			csvSaver.writeBatch();
		} catch (IOException e) {
			System.out.println("Hata file writebatch : " + e.getMessage());
		}

	}

}
