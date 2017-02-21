package com.learning.java.api.util.properties;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyFileLoader {

	public static Properties loadFromResourcePath(String resourceDir, String fileName) throws FileNotFoundException {
		final Properties properties = new Properties();

		String filePath = "/" + resourceDir + "/" + fileName;
		final InputStream inputStream = PropertyFileLoader.class.getResourceAsStream(filePath);

		if (inputStream != null) {
			try {
				properties.load(inputStream);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			String absoluteFilePath = new File(filePath).getAbsolutePath();
			throw new FileNotFoundException(fileName + " is not found at resource path  : " + " " 
					+ absoluteFilePath.substring(0, absoluteFilePath.indexOf(fileName) - 1));
		}
		return properties;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Properties properties = loadFromResourcePath("config/properties", "awss3.properties");
			System.out.println("name   : " + properties.getProperty("name"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}