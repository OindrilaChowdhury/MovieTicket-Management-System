package interfaces;

import java.lang.*;

import entity.*;

public interface ITicketRepo
{
	public void insertInDB( Ticket t);
	public void deleteFromDB(String ticketCounter);
	public void updateInDB(Ticket t);
	public Ticket searchTicket(String ticketCounter);
	public String [][] getAllTicket();
}

