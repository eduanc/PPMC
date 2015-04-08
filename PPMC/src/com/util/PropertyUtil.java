package com.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtil {
	public static Properties getProp() throws IOException {
		Properties props = new Properties();
		FileInputStream file = new FileInputStream("com.properties/game.properties");
		props.load(file);
		return props;
	}
	
	public static String getProperty(String key) {
		try {
			return getProp().getProperty(key);
		} catch (IOException e) {
			e.printStackTrace();
			return "";
		}
	}
	
	public static int getIntProperty(String key) {
		try {
			return Integer.parseInt(getProp().getProperty(key));
		} catch (IOException e) {
			e.printStackTrace();
			return 0;
		}
	}
}
