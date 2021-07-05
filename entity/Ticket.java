package entity;

import java.lang.*;

public class Ticket
{
	private String ticketCounter; 
	private String ticketQuality;
	private String ticketQuantity;
	private double ticketPrice;

	
	
	public Ticket(){}
	public Ticket(String ticketCounter, String ticketQuality, String ticketQuantity,double ticketPrice)
	{
		this.ticketCounter = ticketCounter;
		this.ticketQuality = ticketQuality;
		this.ticketQuantity = ticketQuantity;
		this.ticketPrice = ticketPrice;
		
	}
	
	public void setTicketCounter(String ticketCounter){this.ticketCounter = ticketCounter;}
	public void setTicketQuality(String ticketQuality){this.ticketQuality = ticketQuality;}
	public void setTicketQuantity(String ticketQuantity){this.ticketQuantity = ticketQuantity;}
	public void setTicketPrice(double ticketPrice){this.ticketPrice = ticketPrice;}
	
	
	public String getTicketCounter(){return ticketCounter;}
	public String getTicketQuality(){return ticketQuality;}
	public String getTicketQuantity(){return ticketQuantity;}
	public double getTicketPrice(){return ticketPrice;}
	
	

	
}