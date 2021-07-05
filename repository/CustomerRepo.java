package repository;

import java.lang.*;
import java.util.ArrayList;
import entity.*;
import interfaces.*;

public class CustomerRepo implements ICustomerRepo
{
	DatabaseConnection dbc;
	
	public CustomerRepo()
	{
		dbc = new DatabaseConnection();
	}
	
	public void submitInDB(Customer c)
	{
		String query = "INSERT INTO customers VALUES ('"+c.getCustomId()+"','"+c.getCustomerName()+"','"+c.getCustomerMail()+"',"+c.getCustomerPhoneNo()+");";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	public void deleteFromDB(String customId)
	{
		String query = "DELETE from customers WHERE customId='"+customId+"';";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception e){System.out.println(e.getMessage());}
	}
	public void updateInDB(Customer c)
	{
		String query = "UPDATE customers SET customerName='"+c.getCustomerName()+"', customerMail = '"+c.getCustomerMail()+"', customerPhoneNo = "+c.getCustomerPhoneNo()+" WHERE customId='"+c.getCustomId()+"'";
		
		try
		{
			dbc.openConnection();
			dbc.st.executeUpdate(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	public Customer searchCustomer(String customId)
	{
		Customer custom = null;
		String query = "SELECT `customerName`, `customerMail`, `customerPhoneNo` FROM `customers` WHERE `customId`='"+customId+"';";     
		try
		{
			System.out.println(query);
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
		
			while(dbc.result.next())
			{
				
				String customerName = dbc.result.getString("customerName");
				String customerMail = dbc.result.getString("customerMail");
				String customerPhoneNo = dbc.result.getString("customerPhoneNo");
				
				custom = new Customer();
				custom.setCustomId(customId);
				custom.setCustomerName(customerName);
				custom.setCustomerMail(customerMail);
				custom.setCustomerPhoneNo(customerPhoneNo);
			}
			
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
		dbc.closeConnection();
		return custom;
	}
	
}




