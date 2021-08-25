package Programs;

import java.awt.BorderLayout;
import java.sql.*;
import java.awt.event.*;
import java.sql.DriverManager;
import java.util.regex.Pattern;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class TIcket_Booking_newUser extends JFrame {

	private JPanel contentPane;
	private JTextField new_name_text;
	private JTextField new_email_textField;
	private JTextField new_password_textField;
	private JTextField confirm_pass_textField;
	private JTextField new_phone_textField;
	public JLabel lbl;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TIcket_Booking_newUser frame = new TIcket_Booking_newUser();
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
	public TIcket_Booking_newUser() {
		JFrame curr=this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane txtpnIrctc = new JTextPane();
		txtpnIrctc.setText("                          IRCTC");
		txtpnIrctc.setBackground(Color.BLACK);
		txtpnIrctc.setEditable(false);
		txtpnIrctc.setFont(new Font("Monotype Corsiva", Font.PLAIN, 27));
		txtpnIrctc.setForeground(Color.WHITE);
		txtpnIrctc.setBounds(0, 0, 429, 38);
		contentPane.add(txtpnIrctc);
		
		JLabel new_name = new JLabel("Name");
		new_name.setFont(new Font("Monotype Corsiva", Font.PLAIN, 14));
		new_name.setBounds(10, 49, 46, 14);
		contentPane.add(new_name);
		
		JLabel new_email = new JLabel("Email:");
		new_email.setFont(new Font("Monotype Corsiva", Font.PLAIN, 14));
		new_email.setBounds(10, 89, 46, 14);
		contentPane.add(new_email);
		
		JLabel new_phone = new JLabel("Phone No.");
		new_phone.setFont(new Font("Monotype Corsiva", Font.PLAIN, 14));
		new_phone.setBounds(10, 127, 74, 14);
		contentPane.add(new_phone);
		
		JLabel new_password = new JLabel("Password");
		new_password.setFont(new Font("Monotype Corsiva", Font.PLAIN, 14));
		new_password.setBounds(10, 168, 62, 14);
		contentPane.add(new_password);
		
		JLabel con_password = new JLabel("Confirm Password");
		con_password.setFont(new Font("Monotype Corsiva", Font.PLAIN, 14));
		con_password.setBounds(10, 209, 95, 14);
		contentPane.add(con_password);
		
		new_name_text = new JTextField();
		new_name_text.setBounds(140, 46, 241, 20);
		contentPane.add(new_name_text);
		new_name_text.setColumns(10);
		
		new_email_textField = new JTextField();
		new_email_textField.setBounds(140, 86, 86, 20);
		contentPane.add(new_email_textField);
		new_email_textField.setColumns(10);
		
		new_password_textField = new JTextField();
		new_password_textField.setText("");
		new_password_textField.setBounds(140, 165, 86, 20);
		contentPane.add(new_password_textField);
		new_password_textField.setColumns(10);
		
		confirm_pass_textField = new JTextField();
		confirm_pass_textField.setText("");
		confirm_pass_textField.setBounds(140, 206, 86, 20);
		contentPane.add(confirm_pass_textField);
		confirm_pass_textField.setColumns(10);
		
		new_phone_textField = new JTextField();
		new_phone_textField.setBounds(140, 124, 86, 20);
		contentPane.add(new_phone_textField);
		new_phone_textField.setColumns(10);
		
		JButton Register = new JButton("Register");
		Register.setBackground(Color.BLACK);
		Register.setForeground(Color.WHITE);
		Register.setFont(new Font("Monotype Corsiva", Font.PLAIN, 15));
		Register.setBounds(304, 209, 89, 29);
		Register.addActionListener(new ActionListener()
				{
			public void actionPerformed(ActionEvent e)
			{	String name1=new_name_text.getText();
				String[] name2=name1.split(" ");
				String mail=new_email_textField.getText();
				String pass=new_password_textField.getText();
				String pass1=confirm_pass_textField.getText();
				String phone=new_phone_textField.getText();
				String query="insert into users(mail,Fname,MName,LName,Password,Phone_no) values(?,?,?,?,?,?)";
				if(pass.equals(pass1) && mail.contains("@gmail.com") && (!(name1.equals(null)))&& (phone.length()==10))
				{	 
					try 
					{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ticketbookingsystem","root","Divyesh@123");
					PreparedStatement stmt=con.prepareStatement(query);
					stmt.setString(1,mail);
					stmt.setString(2, name2[0]);
					stmt.setString(3,name2[1]);
					stmt.setString(4,name2[2]);
					stmt.setString(5,pass);
					stmt.setString(6,phone);
					int a=stmt.executeUpdate();
					
					Ticket_Booking_option o= new Ticket_Booking_option();
					o.setVisible(true);
					Ticket_Booking_option.new_welcome(name2[0],mail);
					
					curr.dispose();
					}
					catch(Exception ee) {}
				}
				else
				{
				lbl.setText("PLz Enter Proper Details!!!!!!!");
				new_name_text.setText("");
				new_email_textField.setText("");
				new_password_textField.setText("");
				confirm_pass_textField.setText("");
				new_phone_textField.setText("");
				}
				e =null;
			}
				});
		contentPane.add(Register);
		
		JLabel lblNewLabel = new JLabel("First Name");
		lblNewLabel.setFont(new Font("Monotype Corsiva", Font.PLAIN, 11));
		lblNewLabel.setBounds(140, 65, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Father's Name");
		lblNewLabel_1.setFont(new Font("Monotype Corsiva", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(233, 65, 62, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Surname");
		lblNewLabel_2.setFont(new Font("Monotype Corsiva", Font.PLAIN, 11));
		lblNewLabel_2.setBounds(335, 65, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		lbl = new JLabel("");
		lbl.setForeground(Color.RED);
		lbl.setFont(new Font("Monotype Corsiva", Font.PLAIN, 12));
		lbl.setBounds(10, 247, 414, 14);
		contentPane.add(lbl);
	}
}
