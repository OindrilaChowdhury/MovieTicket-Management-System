package repository;

import java.lang.*;
import java.util.ArrayList;
import entity.*;
import interfaces.*;

public class TicketRepo implements ITicketRepo
{
	DatabaseConnection dbc;
	
	public TicketRepo()
	{
		dbc = new DatabaseConnection();
	}
	
	public void insertInDB(Ticket t)
	{
		String query = "INSERT INTO tickets VALUES ('"+t.getTicketCounter()+"','"+t.getTicketQuality()+"','"+t.getTicketQuantity()+"',"+t.getTicketPrice()+");";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	public void deleteFromDB(String ticketCounter)
	{
		String query = "DELETE from tickets WHERE ticketCounter='"+ticketCounter+"';";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception t){System.out.println(t.getMessage());}
	}
	public void updateInDB(Ticket t)
	{
		String query = "UPDATE tickets SET ticketCounter='"+t.getTicketCounter()+"', ticketQuality = '"+t.getTicketQuality()+"', ticketQuantity = "+t.getTicketQuantity()+"',ticketPrice = "+t.getTicketPrice()+" WHERE ticketCounter='"+t.getTicketCounter()+"'";
		
		try
		{
			dbc.openConnection();
			dbc.st.executeUpdate(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	public Ticket searchTicket(String ticketCounter)
	{
		Ticket ticket = null;
		String query = "SELECT  `ticketQuality`, `ticketQuantity`, `ticketPrice` FROM `tickets` WHERE `ticketCounter`='"+ticketCounter+"';";     
		try
		{
			System.out.println(query);
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
		
			while(dbc.result.next())
			{
				
	
				String ticketQuality = dbc.result.getString("ticketQuality");
				String ticketQuantity = dbc.result.getString("ticketQuantity");
				double ticketPrice = dbc.result.getDouble("ticketPrice"); 
				
				ticket = new Ticket();
				ticket.setTicketCounter(ticketCounter);
				ticket.setTicketQuality(ticketQuality);
				ticket.setTicketQuantity(ticketQuantity);
				ticket.setTicketPrice(ticketPrice);
			}
			
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
		dbc.closeConnection();
		return ticket;
	}
	public String[][] getAllTicket()
	{
		ArrayList<Ticket> ar = new ArrayList<Ticket>();
		String query = "SELECT * FROM tickets;";  
		
		try
		{
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
			
		
			while(dbc.result.next())
			{
				String ticketCounter = dbc.result.getString("ticketCounter");
				String ticketQuality = dbc.result.getString("ticketQuality");
				String ticketQuantity = dbc.result.getString("ticketQuantity");
				double ticketPrice = dbc.result.getDouble("ticketPrice");
				
				Ticket t = new Ticket(ticketCounter,ticketQuality,ticketQuantity,ticketPrice);
				ar.add(t);
			}
		}
		catch(Exception t){System.out.println(t.getMessage());}
		dbc.closeConnection();
		
		
		Object obj[] = ar.toArray();
		String data[][] = new String [ar.size()][4];
		
		for(int i=0; i<obj.length; i++)
		{
			data[i][0] = ((Ticket)obj[i]).getTicketCounter();
			data[i][1] = ((Ticket)obj[i]).getTicketQuality();
			data[i][2] = ((Ticket)obj[i]).getTicketQuantity();
			data[i][3] = (((Ticket)obj[i]).getTicketPrice())+"";
		}
		return data;
	}
}




