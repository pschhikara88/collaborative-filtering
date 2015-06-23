package ml.assignment.perceptron.utility;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import ml.assignment.perceptron.domain.UserVote;
import ml.assignment.perceptron.technical.DataReader;

public class DataConvertor {
	
	public static HashMap<String,ArrayList<UserVote>> getUserVoteByMovieId(ArrayList<UserVote> voteList)
	{
		HashMap<String,ArrayList<UserVote>>  userVoteByMovieIdMap = new HashMap<String,ArrayList<UserVote>> ();
		ArrayList<UserVote> userVoteList=null;
		String movieId=null;
		for(UserVote userVote : voteList)
		{
			movieId = userVote.getMovieId();
			if(userVoteByMovieIdMap.get(movieId)!=null)
			{
				userVoteByMovieIdMap.get(movieId).add(userVote);
			}
			else
			{
				 userVoteList = new ArrayList<UserVote>();
				 userVoteList.add(userVote);
				 userVoteByMovieIdMap.put(movieId, userVoteList);
			}
		}
		
		
		return userVoteByMovieIdMap;
		
	}
	
	public static HashMap<String,ArrayList<UserVote>> getUserVoteByUserId(ArrayList<UserVote> voteList)
	{
		HashMap<String,ArrayList<UserVote>>  userVoteByUserIdMap = new HashMap<String,ArrayList<UserVote>> ();
		ArrayList<UserVote> userVoteList=null;
		String userId=null;
		for(UserVote userVote : voteList)
		{
			userId = userVote.getUserId();
			if(userVoteByUserIdMap.get(userId)!=null)
			{
				userVoteByUserIdMap.get(userId).add(userVote);
			}
			else
			{
				 userVoteList = new ArrayList<UserVote>();
				 userVoteList.add(userVote);
				 userVoteByUserIdMap.put(userId, userVoteList);
			}
		}
		
		
		return userVoteByUserIdMap;
		
	}
	
	public static HashMap<String,HashMap<String,Float>> getUserVoteMapByUserId(ArrayList<UserVote> voteList)
	{
		HashMap<String,HashMap<String,Float>>  userVoteByUserIdMap = new HashMap<String,HashMap<String,Float>> ();
		HashMap<String,Float> userVoteMap=null;
		String userId=null;
		for(UserVote userVote : voteList)
		{
			userId = userVote.getUserId();
			if(userVoteByUserIdMap.get(userId)!=null)
			{
				userVoteByUserIdMap.get(userId).put(userVote.getMovieId(),userVote.getVoteValue());
			}
			else
			{
				userVoteMap = new HashMap<String,Float>();
				userVoteMap.put(userVote.getMovieId(),userVote.getVoteValue());
				 userVoteByUserIdMap.put(userId, userVoteMap);
			}
		}
		
		
		return userVoteByUserIdMap;
		
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
		ArrayList<UserVote> userList = DataReader.readNetflixVoteInfo("C:/Users/SRPOP/Desktop/Gogate/HW3/Netflix/TrainingRatings.txt");
		
		System.out.println(getUserVoteByUserId(userList).size());
		String reg = "^[a-zA-Z]*$";
		System.out.println("acs".matches(reg));
		
	}

}
