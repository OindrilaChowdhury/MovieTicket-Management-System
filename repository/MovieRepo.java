package repository;

import java.lang.*;
import java.util.ArrayList;
import entity.*;
import interfaces.*;

public class MovieRepo implements IMovieRepo
{
	DatabaseConnection dbc;
	
	public MovieRepo()
	{
		dbc = new DatabaseConnection();
	}
	
	public void insertInDB(Movie m)
	{
		String query = "INSERT INTO movies VALUES ('"+m.getMovieName()+"','"+m.getMovieType()+"',"+m.getMovieQuality()+","+m.getMovieHall()+");";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	public void deleteFromDB(String movieName)
	{
		String query = "DELETE from movies WHERE movieName='"+movieName+"';";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception e){System.out.println(e.getMessage());}
	}
	public void updateInDB(Movie m)
	{
		String query = "UPDATE movies SET movieName='"+m.getMovieName()+"', movieType = '"+m.getMovieType()+"', movieQuality = "+m.getMovieQuality()+", movieHall = "+m.getMovieHall()+" WHERE movieName='"+m.getMovieName()+"'";
		
		try
		{
			dbc.openConnection();
			dbc.st.executeUpdate(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	public Movie searchMovie(String movieName)
	{
		Movie movie = null;
		String query = "SELECT  `movieType`, `movieQuality`,`movieHall` FROM `movies` WHERE `movieName`='"+movieName+"';";     
		try
		{
			System.out.println(query);
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
		
			while(dbc.result.next())
			{
				
				
				String movieType = dbc.result.getString("movieType");
				String movieQuality = dbc.result.getString("movieQuality");
				String movieHall = dbc.result.getString("movieHall");
				
				movie = new Movie();
				movie.setMovieName(movieName);
				movie.setMovieType(movieType);
				movie.setMovieQuality(movieQuality);
				movie.setMovieHall(movieHall);
			}
			
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
		dbc.closeConnection();
		return movie;
	}
	public String[][] getAllMovie()
	{
		ArrayList<Movie> ar = new ArrayList<Movie>();
		String query = "SELECT * FROM movies;";  
		
		try
		{
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
			
		
			while(dbc.result.next())
			{
				String movieName = dbc.result.getString("movieName");
				String movieType = dbc.result.getString("movieType");
				String movieQuality = dbc.result.getString("movieQuality");
				String movieHall = dbc.result.getString("movieHall");
				
				Movie m = new Movie(movieName,movieType,movieQuality,movieHall);
				ar.add(m);
			}
		}
		catch(Exception e){System.out.println(e.getMessage());}
		dbc.closeConnection();
		
		
		Object obj[] = ar.toArray();
		String data[][] = new String [ar.size()][4];
		
		for(int i=0; i<obj.length; i++)
		{
			data[i][0] = ((Movie)obj[i]).getMovieName();
			data[i][1] = ((Movie)obj[i]).getMovieType();
			data[i][2] = ((Movie)obj[i]).getMovieQuality();
			data[i][3] = (((Movie)obj[i]).getMovieHall());
		}
		return data;
	}
	
}




