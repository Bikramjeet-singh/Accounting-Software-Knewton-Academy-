package com.knewton.front;
import java.awt.EventQueue;



import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

import javax.swing.JLabel;
import javax.swing.JList;


public class addcategory extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField b;
	functionDefinition fd=new functionDefinition();
	
	
   



	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					addcategory frame = new addcategory();
					frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	
	public addcategory() 
	{
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 935, 500);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(175, 238, 238));
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				Frontview f = null;
				try {
					f = new Frontview();
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
				f.setVisible(true);
				setVisible(false);
			}
			
		});
		
		b = new JTextField();
		b.setBounds(155, 131, 157, 36);
		contentPane.add(b);
		b.setColumns(10);
		
		JList<String> list = new JList<String>();
		list.setBounds(473, 96, 157, 265);
		contentPane.add(list);
		
		DefaultListModel<String> DLM=new DefaultListModel<String>();
		ArrayList<String> al=fd.getcategoryname();
		
		
		for(int i=0;i<al.size();i++)
		{
			DLM.addElement(al.get(i).toString());
			list.setModel(DLM);
		}
		
		JLabel lblCname = new JLabel("Category Name");
		lblCname.setFont(new Font("Candara", Font.BOLD, 14));
		lblCname.setBounds(154, 90, 158, 30);
		contentPane.add(lblCname);
		
		btnBack.setBackground(new Color(204, 204, 204));
		btnBack.setFont(new Font("Candara", Font.BOLD, 14));
		btnBack.setBounds(10, 11, 104, 36);
		contentPane.add(btnBack);
		
		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				Frontview f=null;
				try
				{
					fd.addcategory(b);
					//JOptionPane.showMessageDialog(null, "New Category added successfully");
					f = new Frontview();
				}
				catch (SQLException e1) {
					
					e1.printStackTrace();
				}
				f.setVisible(true);
				setVisible(false);
				
			}
		});
		btnSubmit.setBackground(new Color(204, 204, 204));
		btnSubmit.setFont(new Font("Candara", Font.BOLD, 15));
		btnSubmit.setForeground(new Color(0, 0, 0));
		btnSubmit.setBounds(736, 386, 157, 46);
		contentPane.add(btnSubmit);
		
		
		}
		
}
		
	
		
		
	

			
	
