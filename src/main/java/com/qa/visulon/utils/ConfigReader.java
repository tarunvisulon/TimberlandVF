package com.qa.visulon.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	private Properties prop;
	FileInputStream f;

	public  Properties init_prop()
	{
		prop = new Properties();
		String env = System.getProperty("env");
		
		if(env==null)
		{
			try {
				f = new FileInputStream(
						"../VF_Sprints2021/src/test/java/com/qa/resources/Configreader_dev");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				prop.load(f);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}else {
		
		try {

			switch (env) {
			case "dev":
				f = new FileInputStream(
						"../VF_Sprints2021/src/test/java/com/qa/resources/Configreader_dev");

				
				break;
				
			case "qa":

				f = new FileInputStream(
						"../VF_Sprints2021/src/test/java/com/qa/resources/Configreader_QA");

				

			default:
				break;
			}
			
			prop.load(f);

		} catch (FileNotFoundException e) {

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		return prop;
	
	}

}
