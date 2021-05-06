package watchlist;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import ch05.queues.ArrayUnbndQueue;
import support.LLNode;

public class RankingQueue extends ArrayUnbndQueue<Ranking> implements MyUnboundedQueueInterface<Ranking>{
	//reads the rankings from a file and adds them to the queue
	public void fromFile(String fileName) {
		File data = new File(fileName);  
		try {
			Scanner inputFile = new Scanner(data);
			while(inputFile.hasNextLine()) {
				 String rankingData = inputFile.nextLine();
				 Ranking ranking = new Ranking(rankingData);
				 this.enqueue(ranking);
			}
			inputFile.close();
		} catch (FileNotFoundException e) {
			System.out.println("file not found.");
		  } 
	}
	
	//returns the average rating for given movie in this ranking queue
	public double movieAvgRating(int inputMovieID) {
		int sum = 0;
		int timesRated = 0;
		double avgRating = 0.0;
		for (int i = 0; i < this.numElements; i++) {
			Ranking current = this.dequeue();
			this.enqueue(current);
			if (current.getMovieId() == inputMovieID) {
				sum += current.getRating();
				timesRated++;
			}
		}
		if (timesRated != 0) {
			avgRating = ((double) sum)/timesRated;
		}
		return avgRating;
	} 
	
	//returns a MovieLibrary containing movies that match the type and 
		//have the same or better average rating than provided
	//returns an empty library if no movie matches both criteria
	public MovieLibrary findGoodType(MovieLibrary inputLibrary, String movieType, double minAvgRating) {
		MovieLibrary typeLibrary = inputLibrary.findType(movieType);
		MovieLibrary goodTypeLibrary = new MovieLibrary();
		LLNode<Movie> movieNode = typeLibrary.getTopNode();
		while (movieNode != null) {
			Movie movie = movieNode.getInfo();
			int movieID = movie.getMovieId();
			double avgRating = this.movieAvgRating(movieID);
			if (avgRating >= minAvgRating)
				goodTypeLibrary.push(movie);
			movieNode = movieNode.getLink();
		}
		return goodTypeLibrary;
	}
}
