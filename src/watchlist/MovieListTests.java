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
		MovieLibrary list = new MovieLibrary();
		MovieLibrary movies = list.findGoodType(genres, library, queue, 2.5);
		System.out.println(movies);
	}

}
