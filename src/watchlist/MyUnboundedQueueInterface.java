package watchlist;

import ch05.queues.UnboundedQueueInterface;

public interface MyUnboundedQueueInterface<T> extends UnboundedQueueInterface<T>{
	//reads the rankings from a file and adds them to the queue
	public void fromFile(String fileName);
	
	//returns the average rating for given movie in this ranking queue
	public double movieAvgRating(int inputMovieID);
	
	//returns a MovieLibrary containing movies that match the type and 
		//have the same or better average rating than provided
	//returns an empty library if no movie matches both criteria
	public MovieLibrary findGoodType(MovieLibrary inputLibrary, String movieType, double minAvgRating);
}
