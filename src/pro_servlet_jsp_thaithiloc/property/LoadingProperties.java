package pro_servlet_jsp_thaithiloc.property;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;
import java.util.Set;

public class LoadingProperties {
	static Properties config;
	static HashMap<String, String> proMap = new HashMap<String, String>();
	InputStream input;

	public HashMap<String, String> readDBProperties(String path) throws IOException {
		config = new Properties();
		input = getClass().getClassLoader().getResourceAsStream(path);
		if (input == null) {
			System.out.println("Sorry, unable to find to " + path);
		}
		config.load(input);
		Set<String> propertyName = config.stringPropertyNames();
		for (String property : propertyName) {
			// lấy value và key tương ứng thêm lần lượt vào hashmap
			proMap.put(property, config.getProperty(property));
		}
//		System.out.println("Hash map: " + this.proMap);
		// trả về hashmap
		return proMap;
	}

	public String getValueOfProperty(String value) throws IOException {
		proMap = readDBProperties("DB.properties");
		return proMap.get(value).toString();
	}

	public String getValueOfErrProperty(String value) throws IOException {
		proMap = readDBProperties("errorMsg.properties");
		return proMap.get(value).toString();
	}

	public static void main(String[] args) throws IOException {
		LoadingProperties l = new LoadingProperties();
//		l.readDBProperties("DB.properties");
		System.out.println(l.getValueOfProperty("PASSWORD"));
		System.out.println(l.getValueOfErrProperty("ERROR_MSG"));
	}

}
