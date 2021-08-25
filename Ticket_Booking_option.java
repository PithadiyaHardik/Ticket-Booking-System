package Programs;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Ticket_Booking_option extends JFrame {

	private JPanel contentPane;
	public static  JLabel welcome; 
	static String mail,name;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ticket_Booking_option frame = new Ticket_Booking_option();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
		public static void new_welcome(String s,String s1)
		{
			welcome.setText("Welcome,  "+s+" Select your option");
			mail=s1;
			name=s;
		}
		public static void input(String s1)
		{	welcome.setText("Welcome,"+s1+"  Select your option");
			mail=s1;
			
		}
		
	/**
	 * Create the frame.
	 */
	public Ticket_Booking_option() {
		
		JFrame curr=this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane txtpnIrctc = new JTextPane();
		txtpnIrctc.setContentType("text/bold");
		txtpnIrctc.setForeground(Color.WHITE);
		txtpnIrctc.setBackground(Color.BLACK);
		txtpnIrctc.setFont(new Font("Monotype Corsiva", Font.PLAIN, 25));
		txtpnIrctc.setEditable(false);
		txtpnIrctc.setText("                             IRCTC");
		txtpnIrctc.setBounds(0, 0, 434, 37);
		contentPane.add(txtpnIrctc);
		
		JButton see_tickets = new JButton("SEE TICKETS");
		see_tickets.setForeground(Color.WHITE);
		see_tickets.setBackground(Color.BLACK);
		see_tickets.setFont(new Font("Monotype Corsiva", Font.PLAIN, 13));
		see_tickets.setBounds(94, 69, 198, 23);
		contentPane.add(see_tickets);
		see_tickets.addActionListener(new ActionListener()
		{
	public void actionPerformed(ActionEvent e)
    	{	
		
		Ticket_Booking_tickets t= new Ticket_Booking_tickets();
		
		try{t.show(mail);}
		catch(Exception s) {}
		t.setVisible(true);
		
		
		
		
		curr.dispose();		
		}
		});
		
		JButton book_ticket = new JButton("BOOK TICKET");
		book_ticket.setFont(new Font("Monotype Corsiva", Font.PLAIN, 14));
		book_ticket.setForeground(Color.WHITE);
		book_ticket.setBackground(Color.BLACK);
		book_ticket.setBounds(94, 131, 198, 23);
		contentPane.add(book_ticket);
	   book_ticket.addActionListener(new ActionListener()
		{
	public void actionPerformed(ActionEvent e)
	{	
		Ticket_Booking_2 f1= new Ticket_Booking_2();
	    f1.setVisible(true);
	    f1.input2(name,mail);
		curr.dispose();	
		}
		});
		
		
		JButton back_Home = new JButton("HOME");
		back_Home.setFont(new Font("Monotype Corsiva", Font.PLAIN, 14));
		back_Home.setForeground(Color.WHITE);
		back_Home.setBackground(Color.BLACK);
		back_Home.setBounds(159, 197, 89, 23);
		contentPane.add(back_Home);
		back_Home.addActionListener(new ActionListener()
				{
			public void actionPerformed(ActionEvent e)
			{	Ticket_Booking f= new Ticket_Booking();
			    f.setVisible(true);
				curr.dispose();			}
				});
		
		welcome = new JLabel("");
		welcome.setForeground(Color.DARK_GRAY);
		welcome.setFont(new Font("Monotype Corsiva", Font.PLAIN, 12));
		welcome.setBounds(10, 48, 424, 14);
		contentPane.add(welcome);
		
	}
}
