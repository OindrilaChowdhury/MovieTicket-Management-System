package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import repository.*;
import entity.*;


public class SearchTicketFrame extends JFrame implements ActionListener
{
	private JLabel ticketCounter, ticketQuality, ticketQuantity, ticketPrice;
	private JTextField ticketCounterTF, ticketQualityTF, ticketQuantityTF, ticketPriceTF;
	private JButton loadBtn, insertBtn, updateBtn, deleteBtn, refreshBtn, getAllBtn, backBtn;
	private JPanel panel;
	private JTable ticketTable;
	private JScrollPane ticketTableSP;
	
	private User user;
	private TicketRepo tr;
	private UserRepo ur;
	
	
	public SearchTicketFrame(User user)
	{
		super("Search Tickets");
		this.setSize(800,450);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.user = user;
		
		tr = new TicketRepo();
		ur = new UserRepo();
		
		panel = new JPanel();
		panel.setLayout(null);
		
		
		
		String data[][] = {{"", "", "", ""}};
		
		String head[] = {"ticketCounter", "ticketQuality", "ticketQuantity", "ticketPrice"};
		
		ticketTable = new JTable(data,head);
		ticketTableSP = new JScrollPane(ticketTable);
		ticketTableSP.setBounds(350, 100, 400, 150);
		ticketTable.setEnabled(false);
		panel.add(ticketTableSP);
		
		ticketCounter = new JLabel("Counter :");
		ticketCounter.setBounds(100,100,100,30);
		panel.add(ticketCounter);
		
		ticketCounterTF = new JTextField();
		ticketCounterTF.setBounds(220,100,100,30);
		panel.add(ticketCounterTF);
		
		ticketQuality = new JLabel("Quality :");
		ticketQuality.setBounds(100,150,100,30);
		panel.add(ticketQuality);
		
		ticketQualityTF = new JTextField();
		ticketQualityTF.setBounds(220,150,100,30);
		panel.add(ticketQualityTF);
		
		ticketQuantity = new JLabel("Quantity: ");
		ticketQuantity.setBounds(100,200,100,30);
		panel.add(ticketQuantity);
		
		ticketQuantityTF = new JTextField();
		ticketQuantityTF.setBounds(220,200,100,30);
		panel.add(ticketQuantityTF);
		
		ticketPrice = new JLabel("Price: ");
		ticketPrice.setBounds(100,250,100,30);
		panel.add(ticketPrice);
		
		ticketPriceTF = new JTextField();
		ticketPriceTF.setBounds(220,250,100,30);
		panel.add(ticketPriceTF);
		
		loadBtn = new JButton("Load");
		loadBtn.setBounds(100,300,80,30);
		loadBtn.addActionListener(this);
		panel.add(loadBtn);
		
		//insertBtn = new JButton("Insert");
		//insertBtn.setBounds(200,300,80,30);
		//insertBtn.addActionListener(this);
		//panel.add(insertBtn);
		
		//updateBtn = new JButton("Update");
		//updateBtn.setBounds(300,300,80,30);
		//updateBtn.addActionListener(this);
		//updateBtn.setEnabled(false);
		//panel.add(updateBtn);
		
		//deleteBtn = new JButton("Delete");
		//deleteBtn.setBounds(400,300,80,30);
		//deleteBtn.addActionListener(this);
		//deleteBtn.setEnabled(false);
		//panel.add(deleteBtn);
		
		refreshBtn = new JButton("Refresh");
		refreshBtn.setBounds(500,300,80,30);
		refreshBtn.addActionListener(this);
		refreshBtn.setEnabled(false);
		panel.add(refreshBtn);
		
		getAllBtn = new JButton("Get All");
		getAllBtn.setBounds(500,260,80,30);
		getAllBtn.addActionListener(this);
		panel.add(getAllBtn);
		
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
			if(!ticketCounterTF.getText().equals("") || !ticketCounterTF.getText().equals(null))
			{
				Ticket t = tr.searchTicket(ticketCounterTF.getText());
				if(t!= null)
				{
					ticketQualityTF.setText(t.getTicketQuality());
					ticketQuantityTF.setText(t.getTicketQuantity());
					ticketPriceTF.setText(t.getTicketPrice()+"");
					
					ticketCounterTF.setEnabled(false);
					ticketQualityTF.setEnabled(true);
					ticketQuantityTF.setEnabled(true);
					ticketPriceTF.setEnabled(true);
					
					//updateBtn.setEnabled(true);
					//deleteBtn.setEnabled(true);
					refreshBtn.setEnabled(true);
					//insertBtn.setEnabled(false);
					loadBtn.setEnabled(false);
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Invaild Counter");
				}
			}
		}
		
		else if(command.equals(refreshBtn.getText()))
		{
			ticketCounterTF.setText("");
			ticketQualityTF.setText("");
			ticketQuantityTF.setText("");
			ticketPriceTF.setText("");
			
			ticketCounterTF.setEnabled(true);
			loadBtn.setEnabled(true);
			//insertBtn.setEnabled(true);
			//updateBtn.setEnabled(false);
			//deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
		}
		
		else if(command.equals(getAllBtn.getText()))
		{
			String data[][] = tr.getAllTicket();
			String head[] = {"ticketCounter", "ticketQuality", "ticketQuantity", "ticketPrice"};
			
			panel.remove(ticketTableSP);
			
			ticketTable = new JTable(data,head);
			ticketTable.setEnabled(false);
			ticketTableSP = new JScrollPane(ticketTable);
			ticketTableSP.setBounds(350, 100, 400, 150);
			panel.add(ticketTableSP);
			
			panel.revalidate();
			panel.repaint();
			
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