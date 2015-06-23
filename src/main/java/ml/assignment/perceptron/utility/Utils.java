package ml.assignment.perceptron.utility;

public class Utils {
	
	public static String createCorrelationId(String userId1, String userId2)
	{
		StringBuilder correlationId=new StringBuilder();
		if(userId1.compareToIgnoreCase(userId2)>=1)
		{
			correlationId.append(userId1);
			correlationId.append(userId2);
		
		}
		else
		{
			correlationId.append(userId2);
			correlationId.append(userId1);
		}
		return correlationId.toString();
	}

}
