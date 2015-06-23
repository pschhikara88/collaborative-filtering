package ml.assignment.perceptron.algorithm;

import java.util.Map;

public class Perceptron {
	
	
	public static int sigmoidUnitExecution(Map<String,Long> docVocab, Map<String,Double> weightData)
	{
		int i=0;
		double weightSum = weightData.get("W0");
		for(String word : docVocab.keySet())
		{
			if(weightData.get(word)!=null)
				weightSum = weightSum + docVocab.get(word)* weightData.get(word);
		}
		if(weightSum>0)
			return 1;
		else
			return -1;
	}
	
	public static void updateWeightVector(Map<String,Long> docVocab, Map<String,Double> weightData,float learningRate, int t, int o)
	{
		double tempWeight=0.0;
		double updatedWeight=0.0;
		double constantFactor= learningRate *(t - o);
		for(String word : docVocab.keySet())
		{
			if(weightData.get(word)!=null)
			{
				updatedWeight = weightData.get(word) + constantFactor * docVocab.get(word);
				weightData.put(word, updatedWeight);
			}		
		}
	}
	
}
