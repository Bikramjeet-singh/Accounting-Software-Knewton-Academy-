package com.knewton.front;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;

public class addtransactionsell extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField quantity;
	String x,y,z,q;
	functionDefinition fd=new functionDefinition();
	ArrayList<String> al=fd.getcategoryname();
	ArrayList<String> al1=new ArrayList<String>();
	ArrayList<String> al2=new ArrayList<String>();
	private JTextField quantity2;
	transactiontype tt=new transactiontype();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addtransactionsell frame = new addtransactionsell();
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
		
	public addtransactionsell() {
		setTitle("TRANSACTION");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 844, 391);
		contentPane = new JPanel();
		
		//System.out.println(flag1);
		
		contentPane.setBackground(new Color(135, 206, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		JLabel label4 = new JLabel("");
		label4.setBounds(564, 150, 73, 34);
		contentPane.add(label4);
		
		
		
		quantity2 = new JTextField();
		quantity2.setBounds(452, 150, 86, 34);
		contentPane.add(quantity2);
		quantity2.setColumns(10);
		quantity2.setVisible(false);
		
		
		JLabel grandtotal = new JLabel("");
		grandtotal.setFont(new Font("Candara", Font.BOLD, 15));
		grandtotal.setHorizontalAlignment(SwingConstants.CENTER);
		grandtotal.setBounds(490, 294, 147, 47);
		contentPane.add(grandtotal);
		
		
		
		quantity = new JTextField();
		quantity.setBounds(452, 86, 86, 34);
		contentPane.add(quantity);
		quantity.setColumns(10);
		quantity.setVisible(false);
		
		
		String cname[]=new String[al.size()];
		String cname2[]=new String[al.size()];
		
		for(int i=0;i<cname.length;i++)
		{
			cname[i]=al.get(i);
		}
		for(int i=0;i<cname2.length;i++)
		{
			cname2[i]=al.get(i);
		}
		
		JComboBox<?> category1 = new JComboBox<Object>(cname);
		category1.setBounds(28, 86, 142, 34);
		contentPane.add(category1);
		
		JLabel lblNewLabel_1 = new JLabel("GRAND TOTAL");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Candara", Font.BOLD, 14));
		lblNewLabel_1.setBounds(324, 297, 156, 44);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_2 = new JButton("Confirm");
		btnNewButton_2.setVisible(false);
		
		JComboBox<?> category2 = new JComboBox<Object>(cname2);
		category2.setBounds(28, 150, 142, 34);
		contentPane.add(category2);
		category2.setVisible(false);
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setBounds(564, 86, 73, 34);
		contentPane.add(lblNewLabel);
		
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				float f=Float.parseFloat(quantity.getText());
				float g=Float.parseFloat(fd.getprice(2, y));
				lblNewLabel.setText(Float.toString(f*g));
				grandtotal.setText(Float.toString(f*g));
				
			}
		});
		
		JButton btnNewButton_3 = new JButton("Confirm");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				float h=Float.parseFloat(quantity2.getText());
				float i=Float.parseFloat(fd.getprice(2, q));
				float f=Float.parseFloat(quantity.getText());
				float g=Float.parseFloat(fd.getprice(2, y));
				
				label4.setText(Float.toString(h*i));
				grandtotal.setText(Float.toString((h*i)+(f*g)));
				
			}
		});
		btnNewButton_3.setBounds(662, 150, 86, 34);
		contentPane.add(btnNewButton_3);
		btnNewButton_3.setVisible(false);
		
		
		
		
		JButton btnNewButton_1 = new JButton("+");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				category2.setVisible(true);
			}
		});
		btnNewButton_1.setVisible(false);
	
		
		category1.addActionListener(new ActionListener() 
		{
				
			 public void actionPerformed(ActionEvent e) 
			 {      
				 	x = category1.getSelectedItem().toString();
				 	al1=fd.getiname(x);									//x contains category name
				 	
				 	String iname[]=new String[al1.size()];
				 	for(int i=0;i<iname.length;i++)
					{
						iname[i]=al1.get(i);
					}
					
				 	
				 	JComboBox<?> comboBox2= new JComboBox<Object>(iname);
					comboBox2.setBounds(180, 86, 142, 34);
					contentPane.add(comboBox2);
					comboBox2.setVisible(true);
					comboBox2.addActionListener(new ActionListener()
					{
						public void actionPerformed(ActionEvent e) 
						 {
							y=comboBox2.getSelectedItem().toString();		//y contains item name
							JLabel label1 = new JLabel("");
							label1.setLabelFor(label1);
							label1.setForeground(new Color(0, 0, 0));
							label1.setBackground(new Color(255, 255, 255));
							label1.setBounds(339, 86, 92, 34);
							contentPane.add(label1);
							label1.setText(fd.getprice(2, y));
							label1.setVisible(true);
							quantity.setVisible(true);
							btnNewButton_2.setVisible(true);
							btnNewButton_1.setVisible(true);
						
					 }});
			 
			 }
			 	});
		category2.addActionListener(new ActionListener()
				{
					
						public void actionPerformed(ActionEvent e)
						{
							z=category2.getSelectedItem().toString();
							al2=fd.getiname(z);
							
							String iname2[]=new String[al2.size()];
						 	for(int i=0;i<iname2.length;i++)
							{
								iname2[i]=al2.get(i);
							}
						 	JComboBox<?> item2 = new JComboBox<Object>(iname2);
							item2.setBounds(180, 150, 127, 34);
							contentPane.add(item2);
							item2.addActionListener(new ActionListener()
									{
										public void actionPerformed(ActionEvent e)
										{
											q=item2.getSelectedItem().toString();
											JLabel label2 = new JLabel("");
											label2.setBounds(363, 150, 68, 34);
											contentPane.add(label2);
											label2.setText(fd.getprice(2, q));
											quantity2.setVisible(true);
											btnNewButton_3.setVisible(true);
											quantity2.setVisible(true);
											//btnNewButton_4.setVisible(true);
										}
								
									});
								
						 	
						}
						
				});
		
		
		
		
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				transactiontype tt=new transactiontype();
				tt.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setBounds(28, 35, 73, 23);
		contentPane.add(btnNewButton);
		
		
		btnNewButton_1.setBounds(758, 86, 60, 34);
		contentPane.add(btnNewButton_1);
		
		
		btnNewButton_2.setBounds(662, 86, 86, 34);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_4 = new JButton("Billing");
		btnNewButton_4.setFont(new Font("Candara", Font.BOLD, 14));
		btnNewButton_4.setBounds(662, 294, 136, 47);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("+");
		btnNewButton_5.setBounds(758, 150, 60, 34);
		contentPane.add(btnNewButton_5);
		}
}
