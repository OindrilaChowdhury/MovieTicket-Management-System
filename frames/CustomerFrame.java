package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import repository.*;
import entity.*;


public class CustomerFrame extends JFrame implements ActionListener
{
	private JLabel customIdLabel, customerNameLabel, customerMailLabel, customerPhoneNoLabel;
	private JTextField customIdTF, customerNameTF, customerMailTF, customerPhoneNoTF;
	private JButton loadBtn, updateBtn, deleteBtn, refreshBtn, backBtn;
	private JPanel panel;
	
	
	private User user;
	private CustomerRepo cr;
	private UserRepo ur;
	
	
	public CustomerFrame(User user)
	{
		super("CustomerFrame");
		this.setSize(800,450);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.user = user;
		
		cr = new CustomerRepo();
		ur = new UserRepo();
		
		panel = new JPanel();
		panel.setLayout(null);
		
		
		
		customIdLabel = new JLabel("ID :");
		customIdLabel.setBounds(100,100,100,30);
		panel.add(customIdLabel);
		
		customIdTF = new JTextField();
		customIdTF.setBounds(220,100,100,30);
		panel.add(customIdTF);
		
		customerNameLabel = new JLabel("Name :");
		customerNameLabel.setBounds(100,150,100,30);
		panel.add(customerNameLabel);
		
		customerNameTF = new JTextField();
		customerNameTF.setBounds(220,150,100,30);
		panel.add(customerNameTF);
		
		customerMailLabel = new JLabel("Email: ");
		customerMailLabel.setBounds(100,200,100,30);
		panel.add(customerMailLabel);
		
		customerMailTF = new JTextField();
		customerMailTF.setBounds(220,200,100,30);
		panel.add(customerMailTF);
		
		customerPhoneNoLabel = new JLabel("PhoneNo: ");
		customerPhoneNoLabel.setBounds(100,250,100,30);
		panel.add(customerPhoneNoLabel);
		
		customerPhoneNoTF = new JTextField();
		customerPhoneNoTF.setBounds(220,250,100,30);
		panel.add(customerPhoneNoTF);
		
		loadBtn = new JButton("Load");
		loadBtn.setBounds(100,300,80,30);
		loadBtn.addActionListener(this);
		panel.add(loadBtn);
		
		//insertBtn = new JButton("Insert");
		//insertBtn.setBounds(200,300,80,30);
		//insertBtn.addActionListener(this);
		//panel.add(insertBtn);
		
		updateBtn = new JButton("Update");
		updateBtn.setBounds(300,300,80,30);
		updateBtn.addActionListener(this);
		updateBtn.setEnabled(false);
		panel.add(updateBtn);
		
		deleteBtn = new JButton("Delete");
		deleteBtn.setBounds(400,300,80,30);
		deleteBtn.addActionListener(this);
		deleteBtn.setEnabled(false);
		panel.add(deleteBtn);
		
		refreshBtn = new JButton("Refresh");
		refreshBtn.setBounds(500,300,80,30);
		refreshBtn.addActionListener(this);
		refreshBtn.setEnabled(false);
		panel.add(refreshBtn);
		
		//getAllBtn = new JButton("Get All");
		//getAllBtn.setBounds(500,260,80,30);
		//getAllBtn.addActionListener(this);
		//panel.add(getAllBtn);
		
		backBtn = new JButton("Back");
		backBtn.setBounds(600, 350, 80, 30);
		backBtn.addActionListener(this);
		panel.add(backBtn);
		
		this.add(panel);
	}
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		
		if(command.equals(loadBtn.getText()))
		{
			if(!customIdTF.getText().equals("") || !customIdTF.getText().equals(null))
			{
				Customer c = cr.searchCustomer(customIdTF.getText());
				if(c!= null)
				{
					customerNameTF.setText(c.getCustomerName());
					customerMailTF.setText(c.getCustomerMail());
					customerPhoneNoTF.setText(c.getCustomerPhoneNo());
					
					customIdTF.setEnabled(false);
					customerNameTF.setEnabled(true);
					customerMailTF.setEnabled(true);
					customerPhoneNoTF.setEnabled(true);
					
					updateBtn.setEnabled(true);
					deleteBtn.setEnabled(true);
					refreshBtn.setEnabled(true);
					//insertBtn.setEnabled(false);
					loadBtn.setEnabled(false);
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Invaild ID");
				}
			}
		}
	
		else if(command.equals(refreshBtn.getText()))
		{
			customIdTF.setText("");
			customerNameTF.setText("");
			customerMailTF.setText("");
			customerPhoneNoTF.setText("");
			
			customIdTF.setEnabled(true);
			loadBtn.setEnabled(true);
			//insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
		}
		else if(command.equals(updateBtn.getText()))
		{
			Customer c = new Customer();
			
			c.setCustomId(customIdTF.getText());
			c.setCustomerName(customerNameTF.getText());
			c.setCustomerMail(customerMailTF.getText());
			c.setCustomerPhoneNo(customerPhoneNoTF.getText());
			
			cr.updateInDB(c);
			
			JOptionPane.showMessageDialog(this, "Updated");
			
			customIdTF.setText("");
			customerNameTF.setText("");
			customerMailTF.setText("");
			customerPhoneNoTF.setText("");
			
			loadBtn.setEnabled(true);
			//insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);

			customIdTF.setEnabled(true);
			customerNameTF.setEnabled(true);
			customerMailTF.setEnabled(true);
			customerPhoneNoTF.setEnabled(true);
		}
		else if(command.equals(deleteBtn.getText()))
		{
			cr.deleteFromDB(customIdTF.getText());
			ur.deleteUser(customIdTF.getText());
			
			JOptionPane.showMessageDialog(this,"Deleted");
			
			customIdTF.setText("");
			customerNameTF.setText("");
			customerMailTF.setText("");
			customerPhoneNoTF.setText("");
			
			customIdTF.setEnabled(true);
			customerNameTF.setEnabled(true);
			customerMailTF.setEnabled(true);
			customerPhoneNoTF.setEnabled(true);
	
			loadBtn.setEnabled(true);
			//insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
		}
		else if(command.equals(backBtn.getText()))
		{
			CustomerHome ch = new CustomerHome(user);
			ch.setVisible(true);
			this.setVisible(false);
		}
		else{}
		
	}
}