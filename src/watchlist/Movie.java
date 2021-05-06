package watchlist; 

public class Movie{

	//Creation of protected data.
	protected int movieID;
	protected String movieName;
	protected String releaseDate;
	protected String videoReleaseDate;
	protected String url;
	static protected String[] typeDescription = {"unknown", "Action", "Adventure", "Animation", "Children's", "Comedy", 
			"Crime", "Documentary", "Drama", "Fantasy", "Film-Noir", "Horror", "Musical", "Mystery", "Romance", "Sci-Fi",
			"Thriller", "War", "Western"};
	static public int movieTypeLength = typeDescription.length;
	protected boolean[] movieType = new boolean[movieTypeLength];

	//Constructor
	public Movie(int id, String name, String date, String videoDate, String web, boolean[] type) {
		this.movieID = id;
		this.movieName = name;
		this.releaseDate = date;
		this.videoReleaseDate = videoDate;
		this.url = web;
		this.movieType = type;
	}
	
	//Constructor that takes a String line (from a file) and parses it out.
	public Movie(String entry) {
		String[] line = entry.split("\\|");
		this.movieID = Integer.parseInt(line[0]);
		this.movieName = line[1];
		this.releaseDate = line[2];
		this.videoReleaseDate = line[3];
		this.url = line[4];
		int a = 0;
		for(int i = 5; i<line.length; i++) { //Create the movieType array
			if(line[i].equals("1")) {
				movieType[a] = true;
			}
			else {
				movieType[a] = false;
			}
			a ++;
		}
	}
	
	//Create getters and setters
	public int getMovieID() {
		return movieID;
	}

	public String getMovieName() {
		return movieName;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public String getVideoReleaseDate() {
		return videoReleaseDate;
	}

	public String getUrl() {
		return url;
	}

	public boolean[] getMovieType() {
		return movieType;
	}

	public String[] getTypeDescription() {
		return typeDescription;
	}

	public void setMovieID(int movieID) {
		this.movieID = movieID;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public void setVideoReleaseDate(String videoReleaseDate) {
		this.videoReleaseDate = videoReleaseDate;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setMovieType(boolean[] movieType) {
		this.movieType = movieType;
	}

	public void setTypeDescription(String[] typeDescription) {
		Movie.typeDescription = typeDescription;
	}

	//Method for creating an display of the data
	public String toString() {
		String output = "Movie: \n";
		output += "\t ID: " + movieID + "\n";
		output += "\t Name: " + movieName + "\n";
		output += "\t Released: " + releaseDate + "\n";
		output += "\t Video Released: " + videoReleaseDate + "\n";
		for(int i = 0; i < movieType.length; i++)
			if(movieType[i] == true) {
				output += "\t Type: " + typeDescription[i] + "\n"; //this needs to spit out the corresponding genre
			}
		return output;
	}
	
	//Method for printing typeDescription list in a palatable manner
	public String descToString() {
		String list = "The genres are: ";
		for(int i = 0; i<typeDescription.length; i++)
			list = list + typeDescription[i] + " | ";
		return list;
	}
	
	//Method for creating a String array of the selected movie types for that movie
	public String[] getMovieTypesDesc() {
		String[] selectedTypes = new String[19];
		int index = 0;
		for(int i = 0; i < movieType.length; i++)
			if(movieType[i] == true) {
				selectedTypes[index] = typeDescription[i];
				index ++;
			}
		return selectedTypes;
	}
}
