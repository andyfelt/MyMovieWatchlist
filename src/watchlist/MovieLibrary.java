package watchlist;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import ch03.stacks.LinkedStack;
import ch03.stacks.StackUnderflowException;
import support.LLNode;

public class MovieLibrary extends LinkedStack<Movie> {

	//Method fromFile - takes input of file name and reads movies into structure
	public void fromFile(String file) {
		File myFile = new File(file);
		Scanner inputFile;
	
		try {
			inputFile = new Scanner(myFile);
			while(inputFile.hasNext()) {
				Movie line = new Movie(inputFile.nextLine());
				this.push(line);
			}
			System.out.println("The file has been stored.");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//Method toString that prints out current stack w/out changing stack
	public String toString() {
		String toReturn = "";
		LLNode<Movie> endLink = null; // link of the last node on the list is null
		while(endLink != top) { 
			LLNode<Movie> currentNode = top;
			while(currentNode.getLink() != endLink) {
				currentNode = currentNode.getLink();
			}
			toReturn+= currentNode.getInfo().toString();
			endLink = currentNode;
		}
		return toReturn;
	}
		
	//Method inLibrary that takes input string and returns boolean if exist.
	//Library should remain unchanged. 
	//If exact name is not found, should print to console a list of all movie names containing.
	public boolean inLibrary(String title) {
		boolean test = false;
		String testTitle = title.toLowerCase();
		LLNode<Movie> currentNode = top;
		while (currentNode != null) {
			// if title matches at all
			if(currentNode.getInfo().getMovieName().toLowerCase().contains(testTitle)) {
				if(currentNode.getInfo().getMovieName().equalsIgnoreCase(testTitle)) {
					test = true;
					System.out.println("This movie was found!");
					System.out.println(currentNode.getInfo().toString());
					return test;
				}
				System.out.println("There was a partial match.");
				System.out.println(currentNode.getInfo().toString());	
			}
			currentNode = currentNode.getLink();
		}
		return test;
	}
	
	//Method findType returns a collection of movies that are that type.
	public MovieLibrary findType(String type){
		
		//Test the input type to ensure it is valid. if not, return null from method
		String[] allTypes = this.top.getInfo().typeDescription;
		boolean valid = false;
		for(int i = 0; i < allTypes.length; i++)
			if(allTypes[i].equalsIgnoreCase(type)) {
				valid = true;
				break;
			}
			if(valid != true) {
				System.out.println("This is an invalid type.");
				return null;
			}
		
		//Find all movies in the current MovieLibrary that have the user's input genre in their listed genres.
		MovieLibrary selected = new MovieLibrary(); // create LinkedStack of movies meeting type
		String movieType = type.toLowerCase(); // convert input type from user to lowercase
		
		Movie currentNode = this.top(); // reference for the top of the Movie stack to start traversing
		while (currentNode != null) { // while we are not at the bottom of the stack
			String[] currentTypes = currentNode.getMovieTypesDesc(); //get the list of movie types for the current movie
			for(int i = 0; i < currentTypes.length; i++) { // for each type in the type array for that movie
				if(currentTypes[i] == null) {
					break;
				}
				else if(currentTypes[i].equalsIgnoreCase(movieType)) { //if the type equals the user input type
					selected.push(currentNode); // push that movie to the LinkedStack of movies meeting the type
				}
			}
			try {
				this.pop();
				currentNode = this.top();
			}
			catch (StackUnderflowException e) {
				break;
			}
		} 
		return selected;
	}
	
}