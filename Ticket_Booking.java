package Programs;
import Programs.*;
import java.sql.*;


import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.*;
import java.util.*;

import javax.swing.JInternalFrame;

public class Ticket_Booking extends JFrame {

	public JPanel contentPane;
	public JTextField user_name;
	public JPasswordField passwordField;
	public JButton reset;
	public JLabel massage;
	
	
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)  {
		EventQueue.invokeLater(new Runnable() {
			public void run()  {
				try {
					Ticket_Booking frame = new Ticket_Booking();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ticket_Booking() {
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		
		
		contentPane.setForeground(SystemColor.control);
		contentPane.setBackground(SystemColor.control);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane txtpnTicketBooking = new JTextPane();
		txtpnTicketBooking.setForeground(Color.WHITE);
		txtpnTicketBooking.setFont(new Font("Monotype Corsiva", Font.BOLD, 30));
		txtpnTicketBooking.setEditable(false);
		txtpnTicketBooking.setText("                 IRCTC");
		txtpnTicketBooking.setBackground(Color.BLACK);
		txtpnTicketBooking.setBounds(0, 0, 434, 42);
		contentPane.add(txtpnTicketBooking);
		
		JLabel l1 = new JLabel();
		l1.setIcon(new ImageIcon("C://Users//HP//Pictures//railway.jpg"));
		
		l1.setBounds(287, 32, 147, 197);
		contentPane.add(l1);
		
		JLabel l2 = new JLabel("Username");
		l2.setFont(new Font("Monotype Corsiva", Font.PLAIN, 17));
		l2.setBounds(10, 70, 84, 24);
		contentPane.add(l2);
		
		user_name = new JTextField();
		user_name.setBounds(111, 72, 114, 20);
		contentPane.add(user_name);
		user_name.setColumns(10);
		
		JLabel l3 = new JLabel("Password");
		l3.setFont(new Font("Monotype Corsiva", Font.PLAIN, 17));
		l3.setBounds(10, 119, 84, 14);
		contentPane.add(l3);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(111, 116, 114, 20);
		contentPane.add(passwordField);
		
		reset = new JButton("Reset");
		reset.setBackground(new Color(0, 0, 0));
		reset.setForeground(Color.WHITE);
		reset.setFont(new Font("Monotype Corsiva", Font.BOLD, 13));
		reset.setBounds(10, 165, 89, 23);
		contentPane.add(reset);
		JFrame f1= this;
		reset.addActionListener(new ActionListener()
				{
				public void actionPerformed(ActionEvent e)
				{
					user_name.setText("");
					passwordField.setText("");
					
				}
			
				});
		
			
		
		
		JButton login = new JButton("Log In");
		login.setForeground(Color.WHITE);
		login.setBackground(Color.BLACK);
		login.setFont(new Font("Monotype Corsiva", Font.BOLD, 13));
		login.setBounds(136, 165, 89, 23);
		login.setOpaque(true);
		login.addActionListener(new ActionListener()
				{
			public void actionPerformed(ActionEvent e) 
			{
				
				String p= passwordField.getText();
				String u=user_name.getText();
				String findpass;
				if(p.equals("")||u.equals(""))
				{
					massage.setText("PLz enter both username and password");
				}
				
				else
				{
				boolean flag=false;
				try {
				Class.forName("com.mysql.jdbc.Driver");
				
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ticketbookingsystem","root","Divyesh@123");
				
				PreparedStatement stmt= con.prepareStatement("select Password from users where mail=?");
				stmt.setString(1,u);
				
				ResultSet rs=stmt.executeQuery();
				
				rs.next();
				try 
				{
				findpass=rs.getString("Password");
			
				if(!findpass.equals(p))
				{
					massage.setText("Invalid username or password");
					
				}
				else
				{	 Ticket_Booking_option o=new Ticket_Booking_option();
			
				      o.input(u);
				     o.setVisible(true);
				    
					 f1.dispose();
				}
				}
				catch(Exception n)
				{
					massage.setText("Plz Register yourself");
				}
			
				}
				catch(Exception m) {}
				
				
				
			}
				e=null;}
				});
		contentPane.add(login);
		
		 massage = new JLabel("");
		 massage.setForeground(Color.RED);
		 massage.setFont(new Font("Monotype Corsiva", Font.PLAIN, 13));
		massage.setBounds(0, 199, 252, 14);
		contentPane.add(massage);
		
		JButton new_Button = new JButton("New User");
		new_Button.setBackground(Color.BLACK);
		new_Button.setForeground(Color.WHITE);
		new_Button.setFont(new Font("Monotype Corsiva", Font.BOLD, 14));
		new_Button.setBounds(277, 165, 131, 23);
		contentPane.add(new_Button);
		new_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent n)
			{	TIcket_Booking_newUser f= new TIcket_Booking_newUser();
			  	f.setVisible(true);	
			  	f1.dispose();
				
				
			}
		});
		
		
		
	
		
	}
}
