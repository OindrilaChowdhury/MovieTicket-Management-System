package interfaces;

import java.lang.*;

import entity.*;

public interface ICustomerRepo
{
	public void submitInDB(Customer c);
	public void deleteFromDB(String customId);
	public void updateInDB(Customer c);
	public Customer searchCustomer(String customId);
}



