package com.converterDataToArff.impl;

import java.io.File;
import java.io.IOException;

import com.converter.DataConverterSelect;

import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.CSVLoader;

public class ConversionCsvToArff implements DataConverterSelect {

	/*
	 * Converter Csv File -> Arff File
	 * 
	 */
	@Override
	public void convert(File selectedFile, File converterFile) {

		Instances instancesData = null;
		CSVLoader loader = new CSVLoader();
		try {
			loader.setSource(selectedFile);
			instancesData = loader.getDataSet();

		} catch (IOException e) {
			System.out.println("instancesData : " + e.getMessage());
		}
		// save ARFF
		ArffSaver saver = new ArffSaver();
		saver.setInstances(instancesData);
		try {
			saver.setFile(converterFile);
			saver.writeBatch();

		} catch (IOException e) {
			System.out.println("CvstoArff Saver Hata : " + e.getMessage());
		}

	}

}
