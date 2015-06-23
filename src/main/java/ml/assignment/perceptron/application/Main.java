package ml.assignment.perceptron.application;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import ml.assignment.perceptron.algorithm.CollaborativeFiltering;
import ml.assignment.perceptron.algorithm.Perceptron;
import ml.assignment.perceptron.domain.Movie;
import ml.assignment.perceptron.domain.UserVote;
import ml.assignment.perceptron.technical.DataReader;
import ml.assignment.perceptron.utility.DataConvertor;
import ml.assignment.perceptron.utility.RemoveUtils;
import ml.assignment.perceptron.utility.WeightUtils;

public class Main {
	
	public static void main(String args[]) throws IOException
	{
		/*//int totalDoc=0;
		//String folderName = "C:\\Users\\SRPOP\\Desktop\\Gogate\\HW3\\chineseData";
		String folderName = "data"+File.separator+"Perceptron"+File.separator+"data-set1";
		//String folderName = "C:\\Users\\SRPOP\\Desktop\\Gogate\\HW3\\Perceptron\\data-set1";
		//String folderName = "C:\\Users\\SRPOP\\Desktop\\Gogate\\HW3\\Perceptron\\enron1";
		int noOfIteration=10;
		float learningRate=0.001f;
		
		
		Map<String,ArrayList<Map<String,Long>>> trainingData = DataReader.getDataBasedOnClassification(folderName+File.separator+"train");
		
		Map<String,ArrayList<Map<String,Long>>> testData = DataReader.getDataBasedOnClassification(folderName+File.separator+"test");
		
		for(String className : trainingData.keySet())
		{
			totalDoc =totalDoc + trainingData.get(className).size();
		}
		
	
		
		HashMap<String,Double> weightVector = WeightUtils.initializeWeightVector(ApplicationData.totalVocabData); 
		
		//HashSet<String> stopWords = DataReader.getStopWordsSet("C:\\Users\\SRPOP\\Desktop\\Gogate\\HW2\\stopword.csv");
		HashSet<String> stopWords = DataReader.getStopWordsSet("data"+File.separator+"stopword.csv");
		HashMap<String,Double> weightVectorWithoutStopWords = RemoveUtils.removeStopWordsFromWeightVectorReturnNewMap(weightVector, stopWords);
		
		ArrayList<Map<String,Long>> docList= null;
		int o=0;
		int t=0;
		boolean breakFlag=false;
		for(int i=0;i<noOfIteration;i++)
		{
			for(String className :trainingData.keySet() )
			{
				t=className.equalsIgnoreCase("ham")?1:-1;
				docList = trainingData.get(className);
				for(Map<String,Long> docData : docList)
				{
				  o = Perceptron.sigmoidUnitExecution(docData, weightVector);
				  Perceptron.updateWeightVector(docData, weightVector, learningRate, t, o);
				  breakFlag = checkAccuracy(trainingData,weightVector);
				  if(breakFlag)
					  break;
				}
				if(breakFlag)
					  break;
			}
			if(breakFlag)
				  break;
		}
		
		for(int i=0;i<noOfIteration;i++)
		{
			for(String className :trainingData.keySet() )
			{
				t=className.equalsIgnoreCase("ham")?1:-1;
				docList = trainingData.get(className);
				for(Map<String,Long> docData : docList)
				{
				  o = Perceptron.sigmoidUnitExecution(docData, weightVector);
				  if(t!=o)
					 Perceptron.updateWeightVector(docData, weightVector, learningRate, t, o);
				//  breakFlag = checkAccuracy(trainingData,weightVector);
				}
			}
		}
		
		float testAccuracy = checkAccuracyPercentage(testData,weightVector);
		
		
		
		Map<String,Long> totalVoacbWithoutStopWord = RemoveUtils.removeStopWordsFromTotalVocabReturnNewMap(ApplicationData.totalVocabData,stopWords);
		
		weightVector = WeightUtils.initializeWeightVector(totalVoacbWithoutStopWord); 
		
		for(int i=0;i<noOfIteration;i++)
		{
			for(String className :trainingData.keySet() )
			{
				t=className.equalsIgnoreCase("ham")?1:-1;
				docList = trainingData.get(className);
				for(Map<String,Long> docData : docList)
				{
				  o = Perceptron.sigmoidUnitExecution(docData, weightVectorWithoutStopWords);
				  if(t!=o)
					 Perceptron.updateWeightVector(docData, weightVectorWithoutStopWords, learningRate, t, o);
				//  breakFlag = checkAccuracy(trainingData,weightVector);
				}
			}
		}
		
		float testAccuracy1 = checkAccuracyPercentage(testData,weightVectorWithoutStopWords);
		
		System.out.print(noOfIteration+","+ testAccuracy+","+testAccuracy1);
		
		*/
		
		// Netflix filtering 
		//String movieFileName = "C:\\Users\\SRPOP\\Desktop\\Gogate\\HW3\\Netflix\\movie_titles.txt";
		String trainVoteFileName = "data"+File.separator+"Netflix"+File.separator+"TrainingRatings.txt";
		//String trainVoteFileName = "C:\\Users\\SRPOP\\Desktop\\Gogate\\HW3\\Netflix\\TrainingRatings.txt";
		String testVoteFileName = "data"+File.separator+"Netflix"+File.separator+"TestingRatings.txt";
		//String testVoteFileName = "C:\\Users\\SRPOP\\Desktop\\Gogate\\HW3\\Netflix\\TestingRatings.txt";
	//	String testVoteFileName = "C:\\Users\\SRPOP\\Desktop\\Gogate\\HW3\\Netflix\\sample.txt";
		//ArrayList<Movie> movieList = DataReader.readNetflixMovieInfo(movieFileName);
		
		//ArrayList<UserVote> trainUserVoteList = DataReader.readNetflixVoteInfo(trainVoteFileName);
	
		
		//float[][] corelationMatrix = new float[][];
		
		//HashMap<String,ArrayList<UserVote>> userVoteMapByUserId = DataConvertor.getUserVoteByUserId(trainUserVoteList);
		//HashMap<String,ArrayList<UserVote>> userVoteMapByUserIdTest = DataConvertor.getUserVoteByUserId(testUserVoteList);
		
		HashMap<String,HashMap<String,Float>> userVoteMapByUserId = DataReader.readNetflixVoteInfoInMapWithMap(trainVoteFileName);
		//HashMap<String,ArrayList<UserVote>> userVoteMapByUserId = DataReader.readNetflixVoteInfoInMap(trainVoteFileName);
		//HashMap<String,ArrayList<UserVote>> userVoteMapByUserIdTest = DataReader.readNetflixVoteInfoInMap(testVoteFileName);
		ArrayList<UserVote> testUserVoteList = DataReader.readNetflixVoteInfo(testVoteFileName);
		
		//System.out.println(testUserVoteList);
		
		HashMap<String,Integer> indexMap = new HashMap<String,Integer>();
		int i=0;
		for(String userId : userVoteMapByUserId.keySet())
		{
			indexMap.put(userId, i);
			i++;
		}
		//i--;
		/*for(String userId : userVoteMapByUserIdTest.keySet())
		{
			if(indexMap.get(userId)==null)
			{
				indexMap.put(userId, i);
				i++;
			}
		}*/
		//Double j = (;
		i=(i*(i+1))/2;
		//System.out.println();
		//System.out.println(i);
		//Float[][] corelationMatrix = new Float[i][i];
		Double[] corelationMatrix = new Double[i];
		//System.out.println(corelationMatrix.length);
		
		int count =0;
		HashSet<String> testUserList = new HashSet<String>();
		for(UserVote userVote : testUserVoteList)
		{
			if(userVoteMapByUserId.containsKey(userVote.getUserId()))
			{
				testUserList.add(userVote.getUserId());
			}
		}
		System.out.println(testUserList.size());
		System.out.println(userVoteMapByUserId.size());
		
		HashMap<String,Double> meanVoteByUser = CollaborativeFiltering.meanVoteByUser2(userVoteMapByUserId);
		
		System.out.println(CollaborativeFiltering.createCorrelationMatrix( indexMap, i));
		
		//HashMap<String,Double> meanVoteByUser = CollaborativeFiltering.meanVoteByUser(userVoteMapByUserId);
		
		
		//CollaborativeFiltering.testAccuracyByCFOnNetFlix(userVoteMapByUserIdTest, userVoteMapByUserId, meanVoteByUser,indexMap,corelationMatrix);
		//CollaborativeFiltering.testAccuracyByCFOnNetFlix1(testUserVoteList, userVoteMapByUserId, meanVoteByUser,indexMap,corelationMatrix);
		
		
	}
	
	private static boolean checkAccuracy(Map<String,ArrayList<Map<String,Long>>> testData,HashMap<String,Double> weightVector)
	{
		ArrayList<Map<String,Long>> docList= null;
		int o=0;
		int t=0;
		for(String className :testData.keySet() )
		{
			t=className.equalsIgnoreCase("ham")?1:-1;
			docList = testData.get(className);
			for(Map<String,Long> docData : docList)
			{
				o = Perceptron.sigmoidUnitExecution(docData, weightVector);
				if(t!=o)
					return false;	
			}
		}
		return true;
		
	}
	
	private static float checkAccuracyPercentage(Map<String,ArrayList<Map<String,Long>>> testData,HashMap<String,Double> weightVector)
	{
		ArrayList<Map<String,Long>> docList= null;
		int o=0;
		int t=0;
		int successCount=0;
		int totalCount=0;
		for(String className :testData.keySet() )
		{
			t=className.equalsIgnoreCase("ham")?1:-1;
			docList = testData.get(className);
			for(Map<String,Long> docData : docList)
			{
				o = Perceptron.sigmoidUnitExecution(docData, weightVector);
				if(t==o)
					successCount = successCount+1;
				totalCount = totalCount + 1;
			}
		}
		return 100 * ((float)successCount)/totalCount;
		
	}

}
