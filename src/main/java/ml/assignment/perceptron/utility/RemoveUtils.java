package ml.assignment.perceptron.utility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class RemoveUtils {
	
	public static Map<String,Map<String,Long>>   removeStopWordsAndReturnNewMap(Map<String,Map<String,Long>>  classificationData, HashSet<String> stopWords)
	{
		Map<String,Map<String,Long>>  reducedClassData = new HashMap<String,Map<String,Long>>();
		Map<String,Long> featureMap = null;
		Map<String,Long> newFeatureMap = null;
		for(String class1 : classificationData.keySet() )
		{
			featureMap = classificationData.get(class1);
			
			newFeatureMap = new HashMap<String,Long>();
			newFeatureMap.putAll(featureMap);
			System.out.println("NewfeatureMap : "+ newFeatureMap.size());
			for(String removeString : stopWords)
			{
				if(newFeatureMap.containsKey(removeString))
				{
					newFeatureMap.remove(removeString);
				}
			}
			System.out.println("NewfeatureMap : "+ newFeatureMap.size());
			reducedClassData.put(class1, newFeatureMap);
		}
		return reducedClassData;
	}
	
	public static void   removeStopWords(Map<String,Map<String,Long>>  classificationData, HashSet<String> stopWords)
	{
		Map<String,Long> featureMap = null;
		for(String class1 : classificationData.keySet() )
		{
			featureMap = classificationData.get(class1);
			for(String removeString : stopWords)
			{
				if(featureMap.containsKey(removeString))
				{
					featureMap.remove(removeString);
				}
			}
		}
	}
	
	public static void   removeStopWordsFromTotalVocab(Map<String,Long>  totalVocab, HashSet<String> stopWords)
	{

			for(String removeString : stopWords)
			{
				if(totalVocab.containsKey(removeString))
				{
					totalVocab.remove(removeString);
				}
			}
			
	}
	
	public static Map<String,Long>  createNewVocabWithKFeatures(Map<String,Long>  totalVocab, ArrayList<String> kFeatures)
	{
		Map<String,Long> reducedKFeatureVocab = new HashMap<String,Long>();
		 
			for(String feature : kFeatures)
			{
				if(totalVocab.containsKey(feature))
				{
					reducedKFeatureVocab.put(feature,totalVocab.get(feature) );
				}
			}
			System.out.println("NewfeatureMap : "+ reducedKFeatureVocab.size());
			return reducedKFeatureVocab;
			
	}
	
	public static Map<String,Long>  createNewVocabWithKFeatures(Map<String,Long>  totalVocab, HashSet<String> kFeatures)
	{
		Map<String,Long> reducedKFeatureVocab = new HashMap<String,Long>();
		 
			for(String feature : kFeatures)
			{
				if(totalVocab.containsKey(feature))
				{
					reducedKFeatureVocab.put(feature,totalVocab.get(feature) );
				}
			}
			System.out.println("NewfeatureMap : "+ reducedKFeatureVocab.size());
			return reducedKFeatureVocab;
			
	}
	
	public static Map<String,Long>   removeSpecialCharacterFromTotalVocabAndReturnNewMap(Map<String,Long>  totalVocab)
	{
		Map<String,Long> newVocab = new HashMap<String,Long>();
		 
			for(String feature : totalVocab.keySet())
			{
				//if(feature.matches("^.*((?=.*\\d)|(?=.*[a-zA-Z])).*$"))
				if(feature.matches("^[a-zA-Z0-9]*$"))
				{
					newVocab.put(feature,totalVocab.get(feature) );
				}
			}
			System.out.println("NewfeatureMap : "+ newVocab.size());
			return newVocab;
			
	}
	
	public static Map<String,Long>   removeLessFrequentWordFromTotalVocabAndReturnNewMap(Map<String,Long>  totalVocab,int frequentFactor)
	{
		Map<String,Long> newVocab = new HashMap<String,Long>();
		 
			for(String feature : totalVocab.keySet())
			{
				//if(feature.matches("^.*((?=.*\\d)|(?=.*[a-zA-Z])).*$"))
				if(totalVocab.get(feature)>=frequentFactor)
					newVocab.put(feature, totalVocab.get(feature));
			}
			System.out.println("NewfeatureMap : "+ newVocab.size());
			return newVocab;
			
	}
	
	
	public static Map<String,Long>  removeStopWordsFromTotalVocabReturnNewMap(Map<String,Long>  totalVocab, HashSet<String> stopWords)
	{
		Map<String,Long>  reducedVocab = new HashMap<String,Long> ();
		reducedVocab.putAll(totalVocab);
		
			for(String removeString : stopWords)
			{
				if(reducedVocab.containsKey(removeString))
				{
					reducedVocab.remove(removeString);
				}
			}
			System.out.println("NewfeatureMap : "+ reducedVocab.size());
		return reducedVocab;	
	}
	
	public static HashMap<String,Double>  removeStopWordsFromWeightVectorReturnNewMap(HashMap<String,Double>  weightVector, HashSet<String> stopWords)
	{
		HashMap<String,Double>  reducedWeight = new HashMap<String,Double> ();
		reducedWeight.putAll(weightVector);
		
			for(String removeString : stopWords)
			{
				if(weightVector.containsKey(removeString))
				{
					reducedWeight.remove(removeString);
				}
			}
			System.out.println("NewfeatureMap : "+ reducedWeight.size());
		return reducedWeight;	
	}
	
	public static ArrayList<Map<String,HashMap<String,Map<String,Long>>>> splitTrainingSet(Map<String,HashMap<String,Map<String,Long>>> actualtrainedData)
	{
		ArrayList<Map<String,HashMap<String,Map<String,Long>>>> splitData = new ArrayList<Map<String,HashMap<String,Map<String,Long>>>>();
		Map<String,HashMap<String,Map<String,Long>>> testClassData1= new HashMap<String,HashMap<String,Map<String,Long>>>();
		Map<String,HashMap<String,Map<String,Long>>> testClassData2= new HashMap<String,HashMap<String,Map<String,Long>>>();
		splitData.add(testClassData1);
		splitData.add(testClassData2);
		HashMap<String,Map<String,Long>> docData = null;
		HashMap<String,Map<String,Long>> splitDocData1 = null;
		HashMap<String,Map<String,Long>> splitDocData2 = null;
		int splitNo=0;
		for(String class1 : actualtrainedData.keySet())
		{
			splitDocData1 = new HashMap<String,Map<String,Long>>();
			splitDocData2 = new HashMap<String,Map<String,Long>>();
			docData = actualtrainedData.get(class1);
			splitNo = Integer.valueOf(Double.valueOf(docData.size()*0.3).intValue());
			for(String docName : docData.keySet())
			{
				
				if(splitDocData1.size()==splitNo)
				{
					splitDocData2.put(docName, docData.get(docName));
				}
				else
				{
					splitDocData1.put(docName, docData.get(docName));
				}
			}
			//testClassData1.put(class1, splitDocData1);
			//testClassData2.put(class1, splitDocData2);
			splitData.get(0).put(class1,splitDocData1);
			splitData.get(1).put(class1,splitDocData2);
			
			
		}
		return splitData;
	}

}
