package com.knewton.front;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class viewprofit extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	functionDefinition fd=new functionDefinition();
	String x;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewprofit frame = new viewprofit();
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
	public viewprofit() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 816, 402);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(175, 238, 238));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frontview f=null;
				try {
					f = new Frontview();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				f.setVisible(true);
				setVisible(false);
			}
		});
		btnBack.setBackground(new Color(204, 204, 204));
		btnBack.setFont(new Font("Candara", Font.BOLD, 14));
		btnBack.setBounds(38, 54, 102, 37);
		contentPane.add(btnBack);
		JLabel lable1 = new JLabel("");
		lable1.setFont(new Font("Candara", Font.BOLD, 16));
		lable1.setBounds(304, 304, 110, 28);
		contentPane.add(lable1);
		
		
		
		JDateChooser date1 = new JDateChooser();
		date1.setBounds(194, 134, 156, 28);
		contentPane.add(date1);
		
		JLabel lblFrom = new JLabel("From");
		lblFrom.setHorizontalAlignment(SwingConstants.CENTER);
		lblFrom.setFont(new Font("Candara", Font.BOLD, 13));
		lblFrom.setBounds(101, 134, 83, 28);
		contentPane.add(lblFrom);
		
		JLabel lblTo = new JLabel("To");
		lblTo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTo.setFont(new Font("Candara", Font.BOLD, 13));
		lblTo.setBounds(374, 134, 83, 28);
		contentPane.add(lblTo);
		
		JDateChooser date2 = new JDateChooser();
		date2.setBounds(443, 134, 156, 28);
		contentPane.add(date2);
		
		
		
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(new java.sql.Date(date1.getDate().getTime()) );
				
				x=fd.ViewProfit(new java.sql.Date(date1.getDate().getTime()),new java.sql.Date(date2.getDate().getTime()));
				lable1.setText(x);
			}
		});
		btnNewButton.setFont(new Font("Candara", Font.BOLD, 13));
		btnNewButton.setBounds(344, 231, 133, 37);
		contentPane.add(btnNewButton);
		
		JLabel lblTotalProfitIs = new JLabel("Total profit is :");
		lblTotalProfitIs.setFont(new Font("Candara", Font.BOLD, 13));
		lblTotalProfitIs.setBounds(194, 304, 102, 28);
		contentPane.add(lblTotalProfitIs);
		
		
	}
}
