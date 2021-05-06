import static org.junit.Assert.*;

import org.junit.Test;

public class MovieListTests {

	@Test
	public void test() {
		RankingQueue queue = new RankingQueue();
		queue.fromFile("u.data");
		MovieLibrary library = new MovieLibrary();
		library.fromFile("u.item.item");
		boolean[] genres = library.top().getMovieType();
		MovieList list = new MovieList();
		MovieLibrary movies = list.findGoodType(genres, library, queue, 2.5);
		System.out.println(movies);
	}

}
