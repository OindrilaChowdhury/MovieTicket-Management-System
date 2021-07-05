package interfaces;

import java.lang.*;

import entity.*;

public interface IMovieRepo
{
	public void insertInDB(Movie m);
	public void deleteFromDB(String movieName);
	public void updateInDB(Movie m);
	public Movie searchMovie(String movieName);
	public String [][] getAllMovie();
	
}