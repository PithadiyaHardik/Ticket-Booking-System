package Programs;

import java.awt.BorderLayout;

import java.awt.event.*;
import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class Ticket_Booking_tickets extends JFrame {

	private JPanel contentPane;
	JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ticket_Booking_tickets frame = new Ticket_Booking_tickets();
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
	public void show(String s) 
	{	try {
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ticketbookingsystem","root","Divyesh@123");
		String q1="select * from users where mail=?";
		PreparedStatement stmt1=con.prepareStatement(q1);
		stmt1.setString(1,s);
		ResultSet rs=stmt1.executeQuery();
	    rs.next();
	    int r=rs.getInt(1);
		String q="select * from tickets where r_id=?";
		PreparedStatement stmt= con.prepareStatement(q);
		stmt.setInt(1,r);
		ResultSet rs1=stmt.executeQuery();
		String m=new String("");
		
		
		while(rs1.next())
		{
			m=m+"\n"+rs1.getString(1)+"  "+rs1.getString(2)+"   "+rs1.getString(3)+"  "+rs1.getString(4)+"  "+rs1.getString(5)+"  "+rs1.getString(6);
		}
		 textArea.setText(m);
		}
		catch(Exception e) {System.out.println(e);}
	}
	public Ticket_Booking_tickets() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane txtpnIrctc = new JTextPane();
		txtpnIrctc.setFont(new Font("Monotype Corsiva", Font.PLAIN, 22));
		txtpnIrctc.setText("                                  IRCTC");
		txtpnIrctc.setBackground(Color.BLACK);
		txtpnIrctc.setForeground(Color.WHITE);
		txtpnIrctc.setEditable(false);
		txtpnIrctc.setBounds(0, 0, 434, 32);
		contentPane.add(txtpnIrctc);
		
		 textArea = new JTextArea();
		 textArea.setFont(new Font("Monotype Corsiva", Font.PLAIN, 14));
		 textArea.setForeground(Color.BLUE);
		textArea.setEnabled(false);
		textArea.setEditable(false);
		textArea.setBounds(0, 32, 434, 205);
		contentPane.add(textArea);
		
		JButton Home = new JButton("Home");
		Home.setBackground(Color.BLACK);
		Home.setForeground(Color.WHITE);
		Home.setFont(new Font("Monotype Corsiva", Font.PLAIN, 14));
		Home.setBounds(64, 238, 96, 23);
		contentPane.add(Home);
		JFrame curr=this;
		Home.addActionListener(new ActionListener()
				{
			public void actionPerformed(ActionEvent e)
			{
				Ticket_Booking t=new Ticket_Booking();
				t.setVisible(true);
				curr.dispose();				
			}
				});
		
		JButton Exit = new JButton("Exit");
		Exit.setForeground(Color.WHITE);
		Exit.setFont(new Font("Monotype Corsiva", Font.PLAIN, 14));
		Exit.setBackground(Color.BLACK);
		Exit.setBounds(266, 238, 89, 23);
		Exit.addActionListener(new ActionListener()
		{
	public void actionPerformed(ActionEvent e)
	{
		
		System.exit(0);				
	}
		});
		contentPane.add(Exit);
	}
}
