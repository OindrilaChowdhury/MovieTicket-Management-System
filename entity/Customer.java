package entity;

import java.lang.*;

public class Customer
{
	private String customId;
	private String customerName;
	private String customerMail;
	private String customerPhoneNo;
	
	public Customer(){}
	public Customer(String customId, String customerName, String customerMail, String customerPhoneNo)
	{
		this.customId = customId;
		this.customerName = customerName;
		this.customerMail = customerMail;
		this.customerPhoneNo = customerPhoneNo;
	}
	
	public void setCustomId(String customId){this.customId = customId;}
	public void setCustomerName(String customerName){this.customerName = customerName;}
	public void setCustomerMail(String customerMail){this.customerMail = customerMail;}
	public void setCustomerPhoneNo(String customerPhoneNo){this.customerPhoneNo = customerPhoneNo;}
	
	public String getCustomId(){return customId;}
	public String getCustomerName(){return customerName;}
	public String getCustomerMail(){return customerMail;}
	public String getCustomerPhoneNo(){return customerPhoneNo;}
}