package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import repository.*;
import entity.*;

public class RegistrationFrame extends JFrame implements ActionListener,MouseListener
{
	private JLabel customIdLabel, customerNameLabel, customerMailLabel, customerPhoneNoLabel, passLabel1, passLabel2;
	private JTextField customIdTF, customerNameTF, customerMailTF, customerPhoneNoTF;
	private JButton submitBtn, backBtn, showPassBtn1;
	private JPasswordField passPF1,passPF2;
	
	private JPanel panel;
	private LoginFrame lf;

	private User user;
	private CustomerRepo cr;
	private UserRepo ur;
	
	public RegistrationFrame(LoginFrame lf)
	{
		super("Register Now !!!");
		this.setSize(800,450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		this.lf = lf;
		
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

		passLabel1 = new JLabel("Password : ");
		passLabel1.setBounds(400, 100,100, 30);
		panel.add(passLabel1);
		
		passPF1 = new JPasswordField();
		passPF1.setBounds(520, 100, 100, 30);
		passPF1.setEchoChar('*');
		panel.add(passPF1);
		
		showPassBtn1 = new JButton("Show");
		showPassBtn1.setBounds(625,100,80,30);
		showPassBtn1.addMouseListener(this);
		panel.add(showPassBtn1);

		passLabel2 = new JLabel("Confirm Password : ");
		passLabel2.setBounds(400, 150,180, 30);
		panel.add(passLabel2);
		
		passPF2 = new JPasswordField();
		passPF2.setBounds(600, 150, 100, 30);
		panel.add(passPF2);
		
		
		submitBtn = new JButton("Submit");
		submitBtn.setBounds(100,300,80,30);
		submitBtn.addActionListener(this);
		panel.add(submitBtn);
		
		
		backBtn = new JButton("Back");
		backBtn.setBounds(600, 350, 80, 30);
		backBtn.addActionListener(this);
		panel.add(backBtn);
		
		
		this.add(panel);
	}
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		
		if(command.equals(submitBtn.getText()))
		{
			Customer c = new Customer();
			CustomerRepo cr = new CustomerRepo();
			UserRepo ur = new UserRepo();
			User u = new User();
			int x = 2;
			//Random rd = new Random();
			//int x = rd.nextInt(9999999)+10000000;

			c.setCustomId(customIdTF.getText());
			c.setCustomerName(customerNameTF.getText());
			c.setCustomerMail(customerMailTF.getText());
			c.setCustomerPhoneNo(customerPhoneNoTF.getText());
			
			u.setUserId(customIdTF.getText());
			u.setPassword(passPF2.getText());
			u.setStatus(x);
			
			cr.submitInDB(c);
			ur.insertUser(u);
			
			JOptionPane.showMessageDialog(this, "Inserted, Id: "+customIdTF.getText()+"and Password: "+passPF2.getText()+"and Status: "+x);

			customIdTF.setText("");
			customerNameTF.setText("");
			customerMailTF.setText("");
			customerPhoneNoTF.setText("");
			passPF1.setText("");
			passPF2.setText("");
			
			submitBtn.setEnabled(true);
			
		}
		else if(command.equals(backBtn.getText()))
		{
			this.setVisible(false);
			lf.setVisible(true);
		}
		else{}
	}
    public void mouseClicked(MouseEvent me){}
	public void mousePressed(MouseEvent me)
	{
		passPF1.setEchoChar((char)0);
	}
	public void mouseReleased(MouseEvent me)
	{
		passPF1.setEchoChar('*');
	}
	public void mouseEntered(MouseEvent me){}
	public void mouseExited(MouseEvent me){}
}