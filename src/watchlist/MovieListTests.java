package watchlist;

import org.junit.Test;

public class MovieListTests {

	@Test
	public void test() {
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
	}
}
