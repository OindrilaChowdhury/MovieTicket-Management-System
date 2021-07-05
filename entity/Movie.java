package entity;

import java.lang.*;

public class Movie
{
	private String movieName;
	private String movieType;
	private String movieQuality;
	private String movieHall ;
	
	public Movie(){}
	public Movie(String movieName, String movieType, String movieQuality, String movieHall)
	{
		this.movieName = movieName;
		this.movieType = movieType;
		this.movieQuality = movieQuality;
		this.movieHall = movieHall;
	}
	
	public void setMovieName(String movieName){this.movieName = movieName;}
	public void setMovieType(String movieName){this.movieType = movieType;}
	public void setMovieQuality(String movieQuality){this.movieQuality = movieQuality;}
	public void setMovieHall(String movieHall){this.movieHall = movieHall;}
	
	public String getMovieName(){return movieName;}
	public String getMovieType(){return movieType;}
	public String getMovieQuality(){return movieQuality;}
	public String getMovieHall(){return movieHall;}
}