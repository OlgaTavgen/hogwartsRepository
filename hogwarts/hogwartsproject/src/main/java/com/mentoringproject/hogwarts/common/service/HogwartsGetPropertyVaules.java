package com.mentoringproject.hogwarts.common.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;

public class HogwartsGetPropertyVaules 
{
	public String result = StringUtils.EMPTY;
	
	public InputStream inputStream;
	
	public String getPropValues() throws IOException
	{
		 
		try 
		{
			Properties prop = new Properties();
			String propFileName = "config.properties";
 
			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
 
			if (inputStream != null)
			{
				prop.load(inputStream);
			} 
			
			else
			{
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}
 
			// get the label property value and print it out
			String labelGreen = prop.getProperty("labelGreen");
			String labelRed = prop.getProperty("labelRed");
			String labelYellow = prop.getProperty("labelYellow");
 
			result = "Labels List = " + labelGreen + ", " + labelRed + ", " + labelYellow;
			System.out.println(result);
		} 
		
		catch (Exception e)
		{
			System.out.println("Exception: " + e);
		} 
		
		finally 
		{
			inputStream.close();
		}
		
		return result;
	}

}
