package Programs;

import java.awt.BorderLayout;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.DriverManager;

import Programs.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ButtonGroup;

public class Ticket_Booking_2 extends JFrame {

	private JPanel contentPane;
	private JTextField start_location;
	private JTextField end_location;
	 ButtonGroup bg1 = new ButtonGroup();
	String s1,mail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ticket_Booking_2 frame = new Ticket_Booking_2();
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
	void input2(String s1,String s2)
	{
		this.s1=s2;
		
		
	}
	public Ticket_Booking_2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Ticket_Booking_3 f3= new Ticket_Booking_3();
		JFrame f2=this;
		
		
		JTextPane txtpnIrctc = new JTextPane();
		txtpnIrctc.setFont(new Font("Monotype Corsiva", Font.BOLD, 22));
		txtpnIrctc.setEditable(false);
		txtpnIrctc.setForeground(Color.WHITE);
		txtpnIrctc.setText("                           IRCTC");
		txtpnIrctc.setBounds(0, 0, 434, 38);
		txtpnIrctc.setBackground(Color.BLACK);
		contentPane.add(txtpnIrctc);
		
		JLabel s_location_label = new JLabel("Start Location");
		s_location_label.setFont(new Font("Monotype Corsiva", Font.PLAIN, 14));
		s_location_label.setBounds(0, 49, 86, 21);
		contentPane.add(s_location_label);
		
		start_location = new JTextField();
		start_location.setBounds(86, 49, 86, 20);
		contentPane.add(start_location);
		start_location.setColumns(10);
		
		JLabel e_location_label = new JLabel("End Location");
		e_location_label.setFont(new Font("Monotype Corsiva", Font.PLAIN, 14));
		e_location_label.setBounds(0, 81, 68, 14);
		contentPane.add(e_location_label);
		
		end_location = new JTextField();
		end_location.setBounds(86, 81, 86, 20);
		contentPane.add(end_location);
		end_location.setColumns(10);
		
		JLabel no_ticket = new JLabel("No. of Tickets.");
		no_ticket.setFont(new Font("Monotype Corsiva", Font.PLAIN, 14));
		no_ticket.setBounds(0, 124, 86, 14);
		contentPane.add(no_ticket);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		comboBox.setBounds(86, 120, 86, 20);
		contentPane.add(comboBox);
		
		JLabel Type = new JLabel("Type:");
		Type.setFont(new Font("Monotype Corsiva", Font.PLAIN, 15));
		Type.setBounds(275, 49, 68, 14);
		contentPane.add(Type);
		
		JRadioButton Type1 = new JRadioButton("1st Class");
		bg1.add(Type1);
		Type1.setFont(new Font("Monotype Corsiva", Font.PLAIN, 12));
		Type1.setBounds(275, 77, 109, 23);
		contentPane.add(Type1);
		
		
		JRadioButton Type2 = new JRadioButton("2nd Class");
		Type2.setFont(new Font("Monotype Corsiva", Font.PLAIN, 13));
		Type2.setBounds(275, 103, 109, 23);
		contentPane.add(Type2);
		bg1.add(Type2);
		
		JRadioButton Type3 = new JRadioButton("Luggage");
		Type3.setFont(new Font("Monotype Corsiva", Font.PLAIN, 13));
		Type3.setBounds(275, 124, 109, 23);
		contentPane.add(Type3);
		bg1.add(Type3);
		
		JRadioButton Type4 = new JRadioButton("Handicap");
		Type4.setFont(new Font("Monotype Corsiva", Font.PLAIN, 13));
		Type4.setBounds(275, 150, 109, 23);
		contentPane.add(Type4);
		bg1.add(Type4);
		
		JLabel Payment = new JLabel("Payment Method:");
		Payment.setFont(new Font("Monotype Corsiva", Font.PLAIN, 15));
		Payment.setBounds(0, 159, 116, 14);
		contentPane.add(Payment);
		 ButtonGroup bg2 = new ButtonGroup();
		JRadioButton G_pay = new JRadioButton("G pay");
		G_pay.setFont(new Font("Monotype Corsiva", Font.PLAIN, 13));
		G_pay.setBounds(0, 180, 53, 23);
		contentPane.add(G_pay);
		bg2.add(G_pay);
		
		JRadioButton paytm = new JRadioButton("Paytm");
		paytm.setFont(new Font("Monotype Corsiva", Font.PLAIN, 13));
		paytm.setBounds(55, 180, 61, 23);
		contentPane.add(paytm);
		bg2.add(paytm);
		
		JRadioButton debit = new JRadioButton("Debit");
		debit.setFont(new Font("Monotype Corsiva", Font.PLAIN, 11));
		debit.setBounds(118, 180, 54, 23);
		contentPane.add(debit);
		bg2.add(debit);
		
		
		
		
		
		JButton reset2 = new JButton("RESET");
		reset2.setForeground(Color.WHITE);
		reset2.setBackground(Color.BLACK);
		reset2.setFont(new Font("Monotype Corsiva", Font.PLAIN, 16));
		reset2.setBounds(27, 227, 89, 23);
		contentPane.add(reset2);
		reset2.addActionListener(new ActionListener()
				{
			public void actionPerformed(ActionEvent a)
			{
				bg1.clearSelection();
				bg2.clearSelection();
				start_location.setText("");
				end_location.setText("");
				comboBox.setSelectedItem("1");
				a=null;
			}
			
				});
		
		JButton submit2 = new JButton("SUBMIT");
		submit2.setForeground(Color.WHITE);
		submit2.setBackground(Color.BLACK);
		submit2.setFont(new Font("Monotype Corsiva", Font.PLAIN, 16));
		submit2.setBounds(132, 227, 116, 23);
		contentPane.add(submit2);
		submit2.addActionListener(new ActionListener()
				{
			public void actionPerformed(ActionEvent ae)
			{
			 String s=start_location.getText();
				 String e= end_location.getText();
				 String t="";
				 String p="";
				 String n=(String) comboBox.getSelectedItem();
				if(Type1.isSelected()) { t="1st class";}
				else if(Type2.isSelected()) {t="2nd class";}
				else if(Type3.isSelected()) {t="Luggage";}
				else if(Type4.isSelected()){t="Handicaped";}
				if(G_pay.isSelected()) {p="G_pay";}
				else if(paytm.isSelected()) {p="paytm";}
				else  if(debit.isSelected()){ p="Debit";}
				if(p.equals("")|| e.equals("") || t.equals("") || s.equals(""))
				{
					start_location.setText("");
					end_location.setText("");
					bg1.clearSelection();
					bg2.clearSelection();
					JOptionPane.showMessageDialog(contentPane,"Please eneter all details!!!!!!!");
					
					
				}
				else
				{  
					
					f3.input3(s1,s,e,t,p,n);
					f2.dispose();
					f3.setVisible(true);
					
					
				}
			}
				});
		
	}
}
