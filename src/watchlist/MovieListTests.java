package watchlist;

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
		
		movies.libraryToFile("2Watch");
		
		
		//we are here make test with methods
	}
	
	@Test
	public void test2() throws IOException {
		RankingQueue queue = new RankingQueue();
		queue.fromFile("u.data");
		MovieLibrary library = new MovieLibrary();
		library.fromFile("u.item");
		library.pop();
		boolean[] genres = library.top().getMovieType();
		MovieLibrary movies = library.findGoodType(genres, queue, 4.5);
		System.out.println(movies);
		movies.weed();
		System.out.println(movies);
		
		
		
		
		
		
		//we are here make test with methods
	}
}
