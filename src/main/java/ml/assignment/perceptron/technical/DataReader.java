package ml.assignment.perceptron.technical;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import ml.assignment.perceptron.application.ApplicationData;
import ml.assignment.perceptron.domain.Movie;
import ml.assignment.perceptron.domain.UserVote;
import ml.assignment.perceptron.utility.FileUtils;


public class DataReader {
	
	public static Map<String,ArrayList<Map<String,Long>>> getDataBasedOnClassification(String folderPath) throws IOException
	{
		Map<String,ArrayList<Map<String,Long>>> dataBasedOnClassification= new HashMap<String,ArrayList<Map<String,Long>>>();
		
		File folder = new File(folderPath);
		File[] listOfFiles = folder.listFiles();
		//File file =null;
		String classificationName=null;
		File[] listOfClassificationFile=null;
		File classificationFileDirectory=null;
		 String fileContent=null;
		HashMap<String,Long> vocabMap = null;
	//	int docCountPerClassification=0;
		ArrayList<Map<String,Long>> docList=null;
		//int vocabCountPerClassification=0;
		String[] wordList=null;
		for (File file : listOfFiles) {
		  if (file.isDirectory()) 
		  {
			  classificationName = file.getName();
			 
			 //docCountPerClassification=0;
			 // vocabCountPerClassification=0;
			  listOfClassificationFile = file.listFiles();
			  docList = new ArrayList<Map<String,Long>>();
			  for(File classificationFile : listOfClassificationFile )
			  {
				  if (classificationFile.isFile() && classificationFile.getName().endsWith(".txt"))
				  {
					  vocabMap = new HashMap<String,Long>();
					  fileContent= FileUtils.readStringFromFile(classificationFile);
					 // fileContent = fileContent.replaceAll("[^\\dA-Za-z ]", "");
					  wordList = fileContent.split("\\s+");
					  for(String tempWord : wordList)
					  {
						  if(vocabMap.get(tempWord.toLowerCase())!=null)
						  {
							  vocabMap.put(tempWord.toLowerCase(), vocabMap.get(tempWord.toLowerCase())+1) ;
						  }
						  else
						  {
							  vocabMap.put(tempWord.toLowerCase(),1L);
						  }
						  if(ApplicationData.totalVocabData.get(tempWord.toLowerCase())!=null)
						  {
							  ApplicationData.totalVocabData.put(tempWord.toLowerCase(), ApplicationData.totalVocabData.get(tempWord.toLowerCase())+1) ;
						  }
						  else
						  {
							  ApplicationData.totalVocabData.put(tempWord.toLowerCase(),1L);
						  }
					  }
					  docList.add(vocabMap);
				  }
				  
			  }

			  dataBasedOnClassification.put(classificationName, docList);
		  }
		}
		
		return dataBasedOnClassification;
	}
	
	public static ArrayList<Movie> readNetflixMovieInfo(String fileName) throws IOException
	{
		ArrayList<Movie> movieList = new ArrayList<Movie>();
		 BufferedReader br = null;
		 String line = null;
		 String token = ",";
		 Movie movie = null;
		 
				br = new BufferedReader(new FileReader(fileName));
				ArrayList<String> row = null;
				String[] valueList=null;
				while ((line = br.readLine()) != null) {
					
					valueList = line.split(token);
					movie = new Movie(valueList[0],valueList[1],valueList[2]);
					movieList.add(movie);
				}
		 return movieList;
				
	}

	public static ArrayList<UserVote> readNetflixVoteInfo(String fileName) throws IOException
	{
		ArrayList<UserVote> voteInfoList = new ArrayList<UserVote>();
		 BufferedReader br = null;
		 String line = null;
		 String token = ",";
		 long totalUser=0;
		 UserVote userVote = null;
		 
				br = new BufferedReader(new FileReader(fileName));
				ArrayList<String> row = null;
				String[] valueList=null;
				while ((line = br.readLine()) != null) {
					totalUser++;
					valueList = line.split(token);
					userVote = new UserVote(valueList[1],valueList[0],Float.valueOf(valueList[2]));
					voteInfoList.add(userVote);
					
				}
				ApplicationData.totalUserList.add(totalUser);
		 return voteInfoList;
				
	}
	
	
	public static HashMap<String,ArrayList<UserVote>> readNetflixVoteInfoInMap(String fileName) throws IOException
	{
		HashMap<String,ArrayList<UserVote>> voteInfoMap = new HashMap<String,ArrayList<UserVote>>();
		 BufferedReader br = null;
		 ArrayList<UserVote> userVoteList = null;
		
		 String line = null;
		 String token = ",";
		 long totalUser=0;
		 UserVote userVote = null;
		 
				br = new BufferedReader(new FileReader(fileName));
				ArrayList<String> row = null;
				String[] valueList=null;
				while ((line = br.readLine()) != null) {
					totalUser++;
					valueList = line.split(token);
					userVote = new UserVote(valueList[1],valueList[0],Float.valueOf(valueList[2]));
					if(voteInfoMap.get(valueList[1])!=null)
					{
						voteInfoMap.get(valueList[1]).add(userVote);
					}
					else
					{
						userVoteList =  new  ArrayList<UserVote> ();
						userVoteList.add(userVote);
						voteInfoMap.put(valueList[1], userVoteList);
					}
					
				}
				ApplicationData.totalUserList.add(totalUser);
			
		 return voteInfoMap;
				
	}
	
	public static HashMap<String,HashMap<String,Float>> readNetflixVoteInfoInMapWithMap(String fileName) throws IOException
	{
		HashMap<String,HashMap<String,Float>> voteInfoMap = new HashMap<String,HashMap<String,Float>>();
		 BufferedReader br = null;
		 HashMap<String,Float> userVoteMap = null;
		 HashSet<String> userList = null;
		 String line = null;
		 String token = ",";
		 long totalUser=0;
		 UserVote userVote = null;
		 
				br = new BufferedReader(new FileReader(fileName));
				ArrayList<String> row = null;
				String[] valueList=null;
				while ((line = br.readLine()) != null) {
					totalUser++;
					valueList = line.split(token);
					userVote = new UserVote(valueList[1],valueList[0],Float.valueOf(valueList[2]));
					if(voteInfoMap.get(valueList[1])!=null)
					{
						voteInfoMap.get(valueList[1]).put(valueList[0],Float.valueOf(valueList[2]));
					}
					else
					{
						userVoteMap =  new  HashMap<String,Float> ();
						userVoteMap.put(valueList[0],Float.valueOf(valueList[2]));
						voteInfoMap.put(valueList[1], userVoteMap);
					}
					if(ApplicationData.movieUserInfoMap.containsKey(valueList[0]))
					{
						ApplicationData.movieUserInfoMap.get(valueList[0]).add(valueList[1]);
					}
					else
					{
						userList = new HashSet<String>();
						userList.add(valueList[1]);
						ApplicationData.movieUserInfoMap.put(valueList[0],userList);
					}
				}
				ApplicationData.totalUserList.add(totalUser);
			
		 return voteInfoMap;
				
	}
	
	public static HashSet<String> getStopWordsSet(String fileName)
	{
		HashSet<String> stopSet = new HashSet<String>();
		 BufferedReader br = null;
		 String line = null;
		 String token = ",";
		 
			try {
		 
				Map<String, String> maps = new HashMap<String, String>();
		 
				br = new BufferedReader(new FileReader(fileName));
				ArrayList<String> row = null;
				String[] valueList=null;
				while ((line = br.readLine()) != null) {
		 
					// use comma as separator
					valueList = line.split(token);
					for(String value: valueList)
						stopSet.add(value.toLowerCase());
				}
		 
		 
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (br != null) {
					try {
						br.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			
			return stopSet;
	}
	
	
	public static void main(String args[]) throws IOException
	{
		/*Map<String,Map<String,Long>> testData = getDataBasedOnClassification("C:\\Users\\SRPOP\\Desktop\\Gogate\\testFolder\\train");
		Map<String,HashMap<String,Map<String,Long>>> dataBasedOnClassification= getTestDataBasedOnClassification("C:\\Users\\SRPOP\\Desktop\\Gogate\\testFolder\\train");
		System.out.println("ApplicationData.docCountByClassification : " + ApplicationData.docCountByClassification);
		System.out.println("ApplicationData.vocabCountByClassification : " + ApplicationData.vocabCountByClassification);
		System.out.println(dataBasedOnClassification);
		HashSet<String> stopWords = getStopWordsSet("C:\\Users\\SRPOP\\Desktop\\Gogate\\HW2\\stopword.csv");
			System.out.println(stopWords.size());*/
		System.out.println(readNetflixVoteInfo("C:/Users/SRPOP/Desktop/Gogate/HW3/Netflix/TrainingRatings.txt").size());
		String reg = "^[a-zA-Z]*$";
		System.out.println("acs".matches(reg));
		
	}
}
