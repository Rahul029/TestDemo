package com.mindtree.utility;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class PropertyFileReader {
	public static Properties loadFile() {
		Properties p = new Properties();
		String path = ".//Properties//config.properties";
		try {
			FileInputStream file = new FileInputStream(path);
			try {
				p.load(file);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return p;
	}}
