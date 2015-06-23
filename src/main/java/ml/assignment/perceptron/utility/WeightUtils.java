package ml.assignment.perceptron.utility;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class WeightUtils {
	
	public static HashMap<String, Double>  initializeWeightVector(Map<String,Long>  totalVocab )
	{
		
		//System.out.println("test vocab : " + totalVocab.containsKey("hanover"));
		HashMap<String, Double> weightMap = new HashMap<String, Double>();
		Random random = new Random();
		for(String feature : totalVocab.keySet())
		{
			weightMap.put(feature,random.nextDouble());
		}
		weightMap.put("W0",random.nextDouble());
		return weightMap;
	}
	
	public static double getWeightMagnitude(HashMap<String, Double> weightVector)
	{
		double tempDouble=0.0;
		for(String vectorKey : weightVector.keySet())
		{
			tempDouble = tempDouble + Math.pow(weightVector.get(vectorKey),2);
		}
		return Math.sqrt(tempDouble);
	}
	
	public static HashMap<String, Double> copyWeightVector(HashMap<String, Double> weightVector)
	{
		HashMap<String, Double> weightMap = new HashMap<String, Double>();
		for(String vectorKey : weightVector.keySet())
		{
			weightMap.put(vectorKey, weightVector.get(vectorKey));
		}
		return weightMap;
	}

}
