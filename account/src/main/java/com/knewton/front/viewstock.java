package com.knewton.front;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.knewton.model.Item;

import java.awt.Color;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JLabel;

public class viewstock extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	functionDefinition fd=new functionDefinition();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewstock frame = new viewstock();
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
	public viewstock() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 935, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(176, 224, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JList<String> list = new JList<String>();
		list.setBounds(246, 101 ,449, 334);
		contentPane.add(list);
		
		
		DefaultListModel<String> DLM=new DefaultListModel<String>();
		ArrayList<Item> al=fd.viewStock();
	  	System.out.println(al);
		
		for(int i=0;i<al.size();i++)
		{
			DLM.addElement(al.get(i).toString());
			list.setModel(DLM);
		}
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frontview f=null;
				try 
				{
					f = new Frontview();
				}
				catch (SQLException e1)
				{
					
					e1.printStackTrace();
				}
				f.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setBackground(new Color(204, 204, 204));
		btnNewButton.setFont(new Font("Candara", Font.BOLD, 14));
		btnNewButton.setBounds(10, 21, 100, 38);
		contentPane.add(btnNewButton);
		
		JLabel lblCategoryidItemidItemname = new JLabel("CategoryID   ItemID    Name    SellingPrice   BuyingPrice    Quantity    Category");
		lblCategoryidItemidItemname.setBounds(246, 72, 521, 26);
		contentPane.add(lblCategoryidItemidItemname);
		
		
	}
}
