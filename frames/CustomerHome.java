package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import repository.*;
import entity.*;


public class CustomerHome extends JFrame implements ActionListener
{
	JButton logoutBtn, manageProfileBtn, manageMovieBtn, manageTicketBtn, changePasswordBtn;
	JPanel panel;
	
	User user;
	
	public CustomerHome(User user)
	{
		super("Movie World");
		this.setSize(800,450);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.user = user;
		
		panel = new JPanel();
		panel.setLayout(null);
		
		logoutBtn = new JButton("Signout");
		logoutBtn.setBounds(600, 50, 150, 30);
		logoutBtn.addActionListener(this);
		panel.add(logoutBtn);
		
		changePasswordBtn = new JButton("Change Password");
		changePasswordBtn.setBounds(600, 100, 150, 30);
		changePasswordBtn.addActionListener(this);
		panel.add(changePasswordBtn);
		
		manageProfileBtn = new JButton("My Profile");
		manageProfileBtn.setBounds(50, 100, 150, 30);
		manageProfileBtn.addActionListener(this);
		panel.add(manageProfileBtn);
		
		manageMovieBtn = new JButton("Browse Movie");
		manageMovieBtn.setBounds(225, 100, 150, 30);
		manageMovieBtn.addActionListener(this);
		panel.add(manageMovieBtn);
		
		
		manageTicketBtn = new JButton("Search Ticket");
		manageTicketBtn.setBounds(400, 100, 150, 30);
		manageTicketBtn.addActionListener(this);
		panel.add(manageTicketBtn);
		
		this.add(panel);
	
		
	}
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		
		if(command.equals(logoutBtn.getText()))
		{
			LoginFrame lf = new LoginFrame();
			lf.setVisible(true);
			this.setVisible(false);
		}
		else if(command.equals(manageProfileBtn.getText()))
		{
			
				CustomerFrame cf = new CustomerFrame(user);
				cf.setVisible(true);
				this.setVisible(false);
			
		}
		else if(command.equals(manageMovieBtn.getText()))
		{
			    BrowseMovieFrame bmf = new BrowseMovieFrame(user);
				bmf.setVisible(true);
				this.setVisible(false);
		}
		else if(command.equals(manageTicketBtn.getText()))
		{
			    SearchTicketFrame stf = new SearchTicketFrame(user);
				stf.setVisible(true);
				this.setVisible(false);
		}
		else{}
	}
}