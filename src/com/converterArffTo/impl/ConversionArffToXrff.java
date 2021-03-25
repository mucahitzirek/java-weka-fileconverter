package com.converterArffTo.impl;

import java.io.File;
import java.io.IOException;

import com.converter.DataConverterSelect;

import weka.core.Instances;
import weka.core.converters.ArffLoader;
import weka.core.converters.XRFFSaver;

public class ConversionArffToXrff implements DataConverterSelect {

	@Override
	public void convert(File selectedFile, File converterFile) {

		Instances instancesData = null;
		ArffLoader arffLoader = new ArffLoader();
		try {
			instancesData = arffLoader.getDataSet();
		} catch (IOException e) {
			System.out.println("instancesData : " + e.getMessage());
		}
		
		
		XRFFSaver xrffSaver = new XRFFSaver();
		xrffSaver.setInstances(instancesData);
		try {
			xrffSaver.setFile(converterFile);
			xrffSaver.writeBatch();
		} catch (IOException e) {
			System.out.println("ArffToXrff Hata : " + e.getMessage());
		}

	}

}
