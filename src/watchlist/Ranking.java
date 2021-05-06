package watchlist;

public class Ranking {
	protected int userId;
	protected int movieId;
	protected int rating;
	protected int timeStamp;
	
	//Constructor with int type arguments
	public Ranking(int newUserId, int newMovieId, int newRating, int newTimeStamp) {
		this.userId = newUserId;
		this.movieId = newMovieId;
		this.rating = newRating;
		this.timeStamp = newTimeStamp;
	}
	
	//Constructor with String type argument
	public Ranking(String input) {
		 String[] dataAsStrings = input.split("\t");
		 this.userId = Integer.parseInt(dataAsStrings[0]);
		 this.movieId = Integer.parseInt(dataAsStrings[1]);
		 this.rating = Integer.parseInt(dataAsStrings[2]);
		 this.timeStamp = Integer.parseInt(dataAsStrings[3]);
	}
	
	//getters
	public int getUserId() {
		return userId;
	}
	
	public int getMovieId() {
		return movieId;
	}
	
	public int getRating() {
		return rating;
	}
	
	public int getTimeStamp() {
		return timeStamp;
	}

	//setters
	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public void setTimeStamp(int timeStamp) {
		this.timeStamp = timeStamp;
	}

	//returns a multiline string of ranking object
	public String toString() {
		return("userId: " + userId + "\nmovieId: " + movieId + "\nrating: " + 
				rating + "\ntime stamp: " + timeStamp + "\n");
	}
}
