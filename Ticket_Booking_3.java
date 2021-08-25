package Programs;

import java.awt.BorderLayout;

import java.sql.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.time.LocalDate;
import java.awt.EventQueue;
import java.util.Date.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.UIManager;
import Programs.*;

public class Ticket_Booking_3 extends JFrame {

	private JPanel contentPane;
	String s1,s2,s3,s4,s5,s6;
	JLabel a,a1,a2,b,c,d;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ticket_Booking_3 frame = new Ticket_Booking_3();
				
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
	public Ticket_Booking_3() {
		setBackground(UIManager.getColor("Button.background"));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane txtpnIrctc = new JTextPane();
		txtpnIrctc.setText("                        IRCTC");
		txtpnIrctc.setBackground(Color.BLACK);
		txtpnIrctc.setFont(new Font("Monotype Corsiva", Font.BOLD, 26));
		txtpnIrctc.setForeground(Color.WHITE);
		txtpnIrctc.setBounds(0, 0, 434, 37);
		contentPane.add(txtpnIrctc);
		
		  a = new JLabel("");
		  a.setBackground(Color.WHITE);
		  a.setFont(new Font("Monotype Corsiva", Font.PLAIN, 13));
		a.setBounds(0, 38, 434, 24);
		a.setOpaque(true);
		contentPane.add(a);
		
		 a1 = new JLabel("");
		 a1.setBackground(Color.WHITE);
		 a1.setFont(new Font("Monotype Corsiva", Font.PLAIN, 13));
		a1.setBounds(0, 85, 262, 14);
		a1.setOpaque(true);
		contentPane.add(a1);
		
		 a2 = new JLabel("");
		 a2.setBackground(Color.WHITE);
		 a2.setFont(new Font("Monotype Corsiva", Font.PLAIN, 13));
		a2.setBounds(0, 110, 262, 14);
		a2.setOpaque(true);
		contentPane.add(a2);
		
		 b = new JLabel("");
		 b.setBackground(Color.WHITE);
		 b.setFont(new Font("Monotype Corsiva", Font.PLAIN, 13));
		b.setBounds(0, 135, 262, 14);
		b.setOpaque(true);
		contentPane.add(b);
		
		 c = new JLabel("");
		 c.setFont(new Font("Monotype Corsiva", Font.PLAIN, 13));
		 c.setBackground(Color.WHITE);
		c.setBounds(0, 160, 262, 14);
		c.setOpaque(true);
		contentPane.add(c);
		
		 d = new JLabel("");
		 d.setFont(new Font("Monotype Corsiva", Font.PLAIN, 12));
		 d.setBackground(Color.WHITE);
		d.setBounds(0, 178, 248, 14);
		d.setOpaque(true);
		contentPane.add(d);
		JFrame f3=this;
		
		JButton done = new JButton("DONE");
		done.setBackground(Color.BLACK);
		done.setForeground(Color.WHITE);
		done.setFont(new Font("Monotype Corsiva", Font.PLAIN, 13));
		done.setBounds(159, 227, 89, 23);
		done.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent l) {
				f3.dispose();
				Ticket_Booking f1= new Ticket_Booking();
				f1.setVisible(true);
			}
		});
		
		contentPane.add(done);
	
	}
	public  void input3(String s1,String s2,String s3,String s4,String s5,String x)
	{
		this.s1=s1;
		this.s2=s2;
		this.s3=s3;
		this.s4=s4;
		this.s5=s5;
		a.setText("Hey, "+s1+"Thank you so much for using our software for booking Ticket.Kindly Take Screenshot of below given Ticket.");
		 a1.setText("FROM:"+s2);
		 a2.setText("TO:"+s3);
		 b.setText("Type:"+s4);
		 c.setText("Payment Method:"+s5);
		 LocalDate d=LocalDate.now();
	
		 try {
				Class.forName("com.mysql.jdbc.Driver");
				
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ticketbookingsystem","root","Divyesh@123");
				String query="insert into tickets(type,payment,s_location,e_location,tbday,r_id) values(?,?,?,?,?,?)";
				
				
				PreparedStatement stmt= con.prepareStatement(query);
				String q="select * from users where mail=?";
				PreparedStatement stmt1=con.prepareStatement(q);
				stmt1.setString(1,s1);
				ResultSet rs=stmt1.executeQuery();
			    rs.next();
				stmt.setInt(6,rs.getInt(1));
				stmt.setString(1,s4);
				stmt.setString(2,s5);
				stmt.setString(3,s2);
				stmt.setString(4,s3);
				stmt.setString(5,d.toString());
				int a=stmt.executeUpdate();
				
		      }
		 catch(Exception c) {System.out.println("unDone");}
		 
	}
}
