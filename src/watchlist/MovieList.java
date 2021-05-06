package watchlist;

public class MovieList {
	// This comment added by AJF:  

	public MovieLibrary genresFromUser(boolean[] genreType, double minimum) {
		
		

		return null;
		
	}
	// finding the movies that satisfy one the genre inputs
	public MovieLibrary findGoodType(boolean[] genreType, MovieLibrary fullLibrary, RankingQueue queue, double avgRating) {
		MovieLibrary toReturn = new MovieLibrary();
		MovieLibrary tempStack = new MovieLibrary();
		
		//for each movie in fullLibrary - find the movies that fit the genreType
		while (!fullLibrary.isEmpty()) { // while we are not at the bottom of the stack
			Movie currentMovie = fullLibrary.top();
			boolean[] currentMovieGenres = currentMovie.getMovieType();
			for(int i = 0; i<Movie.movieTypeLength; i++) {
				//compare userGenreList to movieGenreList - if any match, include
				if(genreType[i] && currentMovieGenres[i] && queue.movieAvgRating(currentMovie.getMovieID()) >= avgRating) {
					toReturn.push(currentMovie);
					break;
				}
				//move those movies into the toReturn library
			}
			tempStack.push(currentMovie);
			fullLibrary.pop();
		}
		
		//TODO: while loop to push everything back on the library
		while (!tempStack.isEmpty()) {
			fullLibrary.push(tempStack.top());
			tempStack.pop();
		}

		
		
		return toReturn;
	}
	
	
	
}
