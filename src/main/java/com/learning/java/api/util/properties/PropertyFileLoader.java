package com.learning.java.api.util.properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyFileLoader {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Properties properties = new Properties();

		InputStream inputStream = PropertyFileLoader.class.getResourceAsStream("/config/properties/awss3.properties");

		if (inputStream != null) {
			try {
				properties.load(inputStream);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("name   : " + properties.getProperty("name"));
	}
}