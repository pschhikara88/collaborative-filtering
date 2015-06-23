package ml.assignment.perceptron.domain;

public class Movie {
	
	private String movieId;
	private String releaseYear;
	private String movieName;
	
	
	public Movie(String movieId, String releaseYear, String movieName) {
		super();
		this.movieId = movieId;
		this.releaseYear = releaseYear;
		this.movieName = movieName;
	}
	
	public Movie() {
		super();
	}

	public String getMovieId() {
		return movieId;
	}
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
	public String getReleaseYear() {
		return releaseYear;
	}
	public void setReleaseYear(String releaseYear) {
		this.releaseYear = releaseYear;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	
	

}
