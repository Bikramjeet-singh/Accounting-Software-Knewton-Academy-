package com.knewton.front;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField username;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
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
	public login() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 623, 358);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(175, 238, 238));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBackground(new Color(240, 240, 240));
		lblUsername.setFont(new Font("Candara", Font.BOLD, 18));
		lblUsername.setBounds(162, 86, 97, 26);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Candara", Font.BOLD, 18));
		lblPassword.setBounds(162, 161, 97, 14);
		contentPane.add(lblPassword);
		
		username = new JTextField();
		username.setBounds(269, 83, 200, 33);
		contentPane.add(username);
		username.setColumns(10);
		
		password = new JPasswordField();
		password.setBounds(270, 152, 199, 33);
		contentPane.add(password);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBackground(new Color(204, 204, 204));
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
		btnBack.setFont(new Font("Candara", Font.BOLD, 12));
		btnBack.setBounds(22, 11, 79, 33);
		contentPane.add(btnBack);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String uname=username.getText();
				@SuppressWarnings("deprecation")
				String psd=password.getText();
				 
				if(uname.equals("name") && psd.equals("password"))
				{
				       //JOptionPane.showMessageDialog(null,"You have successfully logged in");
				       viewprofit vp=new viewprofit();
				    vp.setVisible(true);
				    setVisible(false);
				}
				else
				{
				      JOptionPane.showMessageDialog(null,"Please enter a valid username or password");
				        setVisible(true);
				}
			}
		});
		btnNewButton.setBackground(new Color(204, 204, 204));
		btnNewButton.setFont(new Font("Candara", Font.BOLD, 18));
		btnNewButton.setBounds(238, 224, 112, 39);
		contentPane.add(btnNewButton);
	}
}
