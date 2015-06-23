package ml.assignment.perceptron.application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class ApplicationData {
	
	public static Map<String,Long> docCountByClassification = new HashMap<String,Long>();
	
	public static Map<String,Long> vocabCountByClassification = new HashMap<String,Long>();
	
	public static Map<String,Long> totalVocabData = new HashMap<String,Long>();
	
	public static Map<String,Float> correlationMap = new HashMap<String,Float>();
	
	public static ArrayList<Long> totalUserList = new  ArrayList<Long>();
	
	//public static Map<String,HashSet<String>> movieUserInfoMap = new  HashMap<String,HashSet<String>> ();
	//public static ArrayList<HashSet<String>> movieUserInfoMap = new  ArrayList<HashSet<String>> ();
}
