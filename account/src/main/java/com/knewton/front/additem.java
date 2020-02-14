package com.knewton.front;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JList;

public class additem extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	functionDefinition fd=new functionDefinition();
	String x=null;
	private JTextField itemname;
	ArrayList<String> al=fd.getcategoryname();
	private JTextField bprice;
	private JTextField sprice;
	

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					additem frame = new additem();
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
	public additem() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 935, 500);
		
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(176, 224, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		bprice = new JTextField();
		bprice.setBounds(534, 156, 159, 35);
		contentPane.add(bprice);
		bprice.setColumns(10);
		

		sprice = new JTextField();
		sprice.setColumns(10);
		sprice.setBounds(365, 156, 159, 35);
		contentPane.add(sprice);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Candara", Font.BOLD, 14));
		btnBack.setBackground(new Color(245, 245, 245));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frontview f=null;
				try {
					f = new Frontview();
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
				f.setVisible(true);
				
			}
		});
		btnBack.setBounds(42, 54, 113, 35);
		contentPane.add(btnBack);
		
		itemname = new JTextField();
		itemname.setBounds(196, 156, 159, 35);
		contentPane.add(itemname);
		itemname.setColumns(10);
		

		JLabel lblCategoryname = new JLabel("Category-name");
		lblCategoryname.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCategoryname.setBounds(22, 127, 127, 28);
		contentPane.add(lblCategoryname);
		

		String cname[]=new String[al.size()];
		
		
		for(int i=0;i<cname.length;i++)
		{
			cname[i]=al.get(i);
		}
		
		JList<String> list = new JList<String>();
		
		list.setBounds(754, 84, 135, 295);
		contentPane.add(list);
		 
		JComboBox<?> comboBox = new JComboBox<Object>(cname);
		comboBox.setBounds(22, 156, 164, 35);
		contentPane.add(comboBox);
		comboBox.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
							
					 	x = comboBox.getSelectedItem().toString();
					 	
					 	DefaultListModel<String> DLM=new DefaultListModel<String>();
					 	ArrayList<String> al1=fd.getiname(x);
						
						for(int i=0;i<al1.size();i++)
						{
							DLM.addElement(al1.get(i).toString());
							list.setModel(DLM);
						}
					}
					
				});
		

		
		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.setBackground(new Color(245, 245, 245));
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				float f1=Float.parseFloat(bprice.getText());
				float f2=Float.parseFloat(sprice.getText());
				fd.additem(itemname,x,f1,f2 );
				Frontview f=null;
				try {
					f = new Frontview();
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
				
				f.setVisible(true);
				setVisible(false);
				
			}
		});
		btnSubmit.setFont(new Font("Candara", Font.BOLD, 15));
		btnSubmit.setBounds(338, 394, 159, 41);
		contentPane.add(btnSubmit);
		
		JLabel lblNewLabel = new JLabel("Item-Name");
		lblNewLabel.setFont(new Font("Candara", Font.BOLD, 14));
		lblNewLabel.setBounds(196, 131, 113, 25);
		contentPane.add(lblNewLabel);
		
		JLabel label3 = new JLabel("Buying Price");
		label3.setFont(new Font("Candara", Font.BOLD, 14));
		label3.setBounds(534, 131, 113, 25);
		contentPane.add(label3);
		
		
		JLabel SellingPrice = new JLabel("Selling Price");
		SellingPrice.setFont(new Font("Candara", Font.BOLD, 14));
		SellingPrice.setBounds(365, 131, 113, 25);
		contentPane.add(SellingPrice);
		
		
		
		
		
	}
}
