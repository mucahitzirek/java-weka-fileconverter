package com.converterArffTo.impl;

import java.io.File;
import java.io.IOException;

import com.converter.DataConverterSelect;

import weka.core.Instances;
import weka.core.converters.ArffLoader;
import weka.core.converters.JSONSaver;

public class ConversionArffToJson implements DataConverterSelect {

	/*
	 * Converter Arff File -> Json File
	 * 
	 */
	@Override
	public void convert(File selectedFile, File converterFile) {

		Instances instancesData = null;
		ArffLoader arffLoader = new ArffLoader();
		try {
			arffLoader.setSource(selectedFile);
			instancesData = arffLoader.getDataSet();
		} catch (IOException e) {
			System.out.println("Hata instancesData : " + e.getMessage());
		}
		JSONSaver jsonSaver = new JSONSaver();
		jsonSaver.setInstances(instancesData);
		try {
			jsonSaver.setFile(converterFile);
			jsonSaver.writeBatch();
		} catch (IOException e) {
			System.out.println("Hata file writebatch : " + e.getMessage());
		}

	}

	public static void dataName() {

		// Save Data Name... to fx

	}
}
