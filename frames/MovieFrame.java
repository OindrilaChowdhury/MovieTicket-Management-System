package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import repository.*;
import entity.*;


public class MovieFrame extends JFrame implements ActionListener
{
	private JLabel movieNameLabel, movieTypeLabel, movieQualityLabel, movieHallLabel;
	private JTextField movieNameTF, movieTypeTF, movieQualityTF, movieHallTF;
	private JButton loadBtn, insertBtn, updateBtn, deleteBtn, refreshBtn, getAllBtn, backBtn;
	private JPanel panel;
	private JTable movieTable;
	private JScrollPane movieTableSP;
	
	private User user;
	private MovieRepo mr;
	private UserRepo ur;
	
	
	public MovieFrame(User user)
	{
		super("All Movies");
		this.setSize(800,450);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.user = user;
		
		mr = new MovieRepo();
		ur = new UserRepo();
		
		panel = new JPanel();
		panel.setLayout(null);
		
		
		
		String data[][] = {{"", "", "", ""}};
		
		String head[] = {"movieName", "movieType", "movieQuality", "movieHall"};
		
		movieTable = new JTable(data,head);
		movieTableSP = new JScrollPane(movieTable);
		movieTableSP.setBounds(350, 100, 400, 150);
		movieTable.setEnabled(false);
		panel.add(movieTableSP);
		
		movieNameLabel = new JLabel("Name :");
		movieNameLabel.setBounds(100,100,100,30);
		panel.add(movieNameLabel);
		
		movieNameTF = new JTextField();
		movieNameTF.setBounds(220,100,100,30);
		panel.add(movieNameTF);
		
		movieTypeLabel = new JLabel("Type :");
		movieTypeLabel.setBounds(100,150,100,30);
		panel.add(movieTypeLabel);
		
		movieTypeTF = new JTextField();
		movieTypeTF.setBounds(220,150,100,30);
		panel.add(movieTypeTF);
		
		movieQualityLabel = new JLabel("Quality: ");
		movieQualityLabel.setBounds(100,200,100,30);
		panel.add(movieQualityLabel);
		
		movieQualityTF = new JTextField();
		movieQualityTF.setBounds(220,200,100,30);
		panel.add(movieQualityTF);
		
		movieHallLabel = new JLabel("Hall : ");
		movieHallLabel.setBounds(100,250,100,30);
		panel.add(movieHallLabel);
		
		movieHallTF = new JTextField();
		movieHallTF.setBounds(220,250,100,30);
		panel.add(movieHallTF);
		
		loadBtn = new JButton("Load");
		loadBtn.setBounds(100,300,80,30);
		loadBtn.addActionListener(this);
		panel.add(loadBtn);
		
		insertBtn = new JButton("Insert");
		insertBtn.setBounds(200,300,80,30);
		insertBtn.addActionListener(this);
		panel.add(insertBtn);
		
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
			if(!movieNameTF.getText().equals("") || !movieNameTF.getText().equals(null))
			{
				Movie m = mr.searchMovie(movieNameTF.getText());
				if(m!= null)
				{
					movieTypeTF.setText(m.getMovieType());
					movieQualityTF.setText(m.getMovieQuality());
					movieHallTF.setText(m.getMovieHall()+"");
					
					movieNameTF.setEnabled(false);
					movieTypeTF.setEnabled(true);
					movieQualityTF.setEnabled(true);
					movieHallTF.setEnabled(true);
					
					updateBtn.setEnabled(true);
					deleteBtn.setEnabled(true);
					refreshBtn.setEnabled(true);
					insertBtn.setEnabled(false);
					loadBtn.setEnabled(false);
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Invaild Name");
				}
			}
		}
		else if(command.equals(insertBtn.getText()))
		{
			Movie m = new Movie();
			User u = new User();

			
			m.setMovieName(movieNameTF.getText());
			m.setMovieType(movieTypeTF.getText());
			m.setMovieQuality(movieQualityTF.getText());
			m.setMovieHall(movieHallTF.getText());
			
			
			
			mr.insertInDB(m);
			ur.insertUser(u);
			
			JOptionPane.showMessageDialog(this, "Inserted, movieName: "+movieNameTF.getText()+"and movieType: "+movieTypeTF.getText()+"and movieQuality: "+movieQualityTF.getText()+"and movieHall: "+movieHallTF.getText());
			
			movieNameTF.setText("");
			movieTypeTF.setText("");
			movieQualityTF.setText("");
			movieHallTF.setText("");
			
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
			
		}
		else if(command.equals(refreshBtn.getText()))
		{
			movieNameTF.setText("");
			movieTypeTF.setText("");
			movieQualityTF.setText("");
			movieHallTF.setText("");
			
			movieNameTF.setEnabled(true);
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
		}
		else if(command.equals(updateBtn.getText()))
		{
			Movie m = new Movie();
			

			m.setMovieName(movieNameTF.getText());
			m.setMovieType(movieTypeTF.getText());
			m.setMovieQuality(movieQualityTF.getText());
			m.setMovieHall(movieHallTF.getText());
			
			mr.updateInDB(m);
			
			JOptionPane.showMessageDialog(this, "Updated");
			

			movieNameTF.setText("");
			movieTypeTF.setText("");
			movieQualityTF.setText("");
			movieHallTF.setText("");
			
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
			
			movieNameTF.setEnabled(true);
			movieTypeTF.setEnabled(true);
			movieQualityTF.setEnabled(true);
			movieHallTF.setEnabled(true);
		}
		else if(command.equals(deleteBtn.getText()))
		{
			mr.deleteFromDB(movieNameTF.getText());
			//ur.deleteUser(empIdTF.getText());
			
			JOptionPane.showMessageDialog(this,"Deleted");
			

			movieNameTF.setText("");
			movieTypeTF.setText("");
			movieQualityTF.setText("");
			movieHallTF.setText("");
			
			movieNameTF.setEnabled(true);
			movieTypeTF.setEnabled(true);
			movieQualityTF.setEnabled(true);
			movieHallTF.setEnabled(true);
	
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
		}
		else if(command.equals(getAllBtn.getText()))
		{
			String data[][] = mr.getAllMovie();
			String head[] = {"movieName", "movieType", "movieQuality", "movieHall"};
			
			panel.remove(movieTableSP);
			
			movieTable = new JTable(data,head);
			movieTable.setEnabled(false);
			movieTableSP = new JScrollPane(movieTable);
			movieTableSP.setBounds(350, 100, 400, 150);
			panel.add(movieTableSP);
			
			panel.revalidate();
			panel.repaint();
			
		}
		else if(command.equals(backBtn.getText()))
		{
			EmployeeHome eh = new EmployeeHome(user);
			eh.setVisible(true);
			this.setVisible(false);
		}
		else{}
		
	}
}