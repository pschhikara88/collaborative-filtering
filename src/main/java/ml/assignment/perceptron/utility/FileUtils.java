package ml.assignment.perceptron.utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class FileUtils {
	
	public static String readStringFromFile(String fileName) throws IOException
	{
		StringBuilder testString = new StringBuilder();
		Reader is = new FileReader(new File(fileName));
		BufferedReader bf = new BufferedReader(is);
		String tempString = null;
		while((tempString = bf.readLine())!=null)
		{
			testString.append(tempString + " ");
		}
		return testString.toString();	
		
	}
	
	public static String readStringFromFile(File file) throws IOException
	{
		StringBuilder testString = new StringBuilder();
		Reader is = new FileReader(file);
		BufferedReader bf = new BufferedReader(is);
		String tempString = null;
		while((tempString = bf.readLine())!=null)
		{
			testString.append(tempString + " ");
		}
		return testString.toString();	
		
	}

	public static void main(String args[]) throws IOException
	{
		String testString = readStringFromFile("C:/Users/SRPOP/Desktop/new6.txt");
		String[] tokens = testString.split("\\s+");
		System.out.println(tokens.length);
		for(String s : tokens)
		{
			System.out.println(s);
		}
		
		
	}
}
