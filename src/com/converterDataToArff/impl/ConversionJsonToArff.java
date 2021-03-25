package com.converterDataToArff.impl;

import java.io.File;

import com.converter.DataConverterSelect;

import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.JSONLoader;

public class ConversionJsonToArff implements DataConverterSelect {

	
	/*
	 * Converter Json File -> Arff File
	 * 
	 */

	@Override
	public void convert(File selectedFile, File converterFile) {

		Instances instancesData = null;
		JSONLoader jsonLoader = new JSONLoader();

		try {
			jsonLoader.setSource(selectedFile);
			instancesData = jsonLoader.getDataSet();
		} catch (Exception e) {

			System.out.println("instancesData : " + e.getMessage());
		}

		ArffSaver arffSaver = new ArffSaver();
		arffSaver.setInstances(instancesData);
		try {
			arffSaver.setFile(converterFile);
			arffSaver.writeBatch();
		} catch (Exception e) {

			System.out.println("jsonToArff Hata : " + e.getMessage());

		}

	}

}
