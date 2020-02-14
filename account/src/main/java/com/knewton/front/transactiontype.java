package com.knewton.front;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.knewton.front.Frontview;

import javax.swing.JRadioButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.Color;

public class transactiontype extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	functionDefinition fd=new functionDefinition();

	
	JRadioButton rdbtnReturn = new JRadioButton("Return");
	JRadioButton rdbtnBuy = new JRadioButton("Buy");
	JRadioButton rdbtnSell = new JRadioButton("Sell");
	JLabel label3 = new JLabel("");
	final int flag=0;
	int i=1;
	/**
	 * 
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
					transactiontype frame = new transactiontype();
					frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}
	

	/**
	 * Create the frame.
	 * @return 
	 * @return 
	 */
	public  transactiontype() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 659, 390);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 235));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		label3.setBounds(216, 255, 130, 42);
		contentPane.add(label3);
		
	
		rdbtnBuy.setBackground(new Color(135, 206, 235));
		rdbtnBuy.setFont(new Font("Candara", Font.BOLD, 15));
		rdbtnBuy.setBounds(135, 88, 109, 23);
		contentPane.add(rdbtnBuy);
		
		
		rdbtnSell.setBackground(new Color(135, 206, 235));
		rdbtnSell.setFont(new Font("Candara", Font.BOLD, 15));
	
		rdbtnSell.setBounds(135, 132, 109, 23);
		contentPane.add(rdbtnSell);
		
		
		rdbtnReturn.setBackground(new Color(135, 206, 235));
		rdbtnReturn.setFont(new Font("Candara", Font.BOLD, 15));
		
		rdbtnReturn.setBounds(135, 176, 109, 23);
		contentPane.add(rdbtnReturn);
		while(i==1)
		{
		rdbtnSell.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label3.setText(rdbtnSell.getText());
				rdbtnBuy.setSelected(false);
				rdbtnReturn.setSelected(false);
				 final int  flag=2;
				 
			}
		});
		
		
		rdbtnBuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label3.setText(rdbtnBuy.getText());
				rdbtnSell.setSelected(false);
				rdbtnReturn.setSelected(false);
				final int flag=1;
				
			}
		});
		rdbtnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label3.setText(rdbtnReturn.getText());
				rdbtnSell.setSelected(false);
				rdbtnBuy.setSelected(false);
				final int flag=3;
				
			}
		});
		
		i++;
		
		}
		JLabel lblTransactionType = new JLabel("TRANSACTION TYPE");
		lblTransactionType.setFont(new Font("Candara", Font.BOLD, 13));
		lblTransactionType.setHorizontalAlignment(SwingConstants.CENTER);
		lblTransactionType.setBounds(76, 255, 130, 42);
		contentPane.add(lblTransactionType);
		
		JLabel lblNewLabel = new JLabel("TRANSACTION TYPE");
		lblNewLabel.setBackground(SystemColor.inactiveCaption);
		lblNewLabel.setFont(new Font("Candara", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 643, 42);
		contentPane.add(lblNewLabel);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBackground(new Color(204, 204, 204));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frontview f=null;
				try {
					f = new Frontview();
				} catch (SQLException e1) 
				{
					
					e1.printStackTrace();
				}
				f.setVisible(true);
				setVisible(false);
			}
		});
		btnBack.setBounds(24, 44, 89, 23);
		contentPane.add(btnBack);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				 
					addtransactionsell ats=new addtransactionsell();
					ats.setVisible(true);
					setVisible(false);	
			}
		});
		btnConfirm.setBackground(new Color(204, 204, 204));
		btnConfirm.setFont(new Font("Candara", Font.BOLD, 14));
		btnConfirm.setBounds(487, 266, 98, 32);
		contentPane.add(btnConfirm);
		
		
	}
	
	
	
	
}
