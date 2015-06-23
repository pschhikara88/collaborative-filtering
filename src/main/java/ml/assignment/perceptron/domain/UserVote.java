package ml.assignment.perceptron.domain;

public class UserVote {
	
	private String userId;
	private String movieId;
	private float voteValue;
	
	
	public UserVote() {
		super();
	}
	
	public UserVote(String userId, String movieId, float voteValue) {
		super();
		this.userId = userId;
		this.movieId = movieId;
		this.voteValue = voteValue;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getMovieId() {
		return movieId;
	}
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
	public float getVoteValue() {
		return voteValue;
	}
	public void setVoteValue(float voteValue) {
		this.voteValue = voteValue;
	}

	@Override
	public String toString() {
		return "UserVote [userId=" + userId + ", movieId=" + movieId
				+ ", voteValue=" + voteValue + "]";
	}
	
	

}
