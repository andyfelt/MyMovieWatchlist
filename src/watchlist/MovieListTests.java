package watchlist;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

public class MovieListTests {

	@Test
	public void test() throws IOException {
		RankingQueue queue = new RankingQueue();
		queue.fromFile("u.data");
		MovieLibrary library = new MovieLibrary();
		library.fromFile("u.item");
		boolean[] genres = library.top().getMovieType();
		MovieLibrary movies = library.findGoodType(genres, queue, 4.5);
		System.out.println(movies);
		movies.weed();
		System.out.println(movies);
		
		System.out.println(movies.top().toFile());
		
	
		movies.libraryToFile("2Watch");
		movies.libraryToFile("2Watch");
		
		//we are here make test with methods
	}
}
