package com.knewton.front;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Connect {
	public Connection con=null;
	public PreparedStatement ps;
	public ResultSet rs=null;

	public Connect() {
		super();
	}

	public  Connection getConnection() throws SQLException, ClassNotFoundException
	{ 
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/bikramjeet","root","MyNewPass");
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
		        JOptionPane.showMessageDialog(null, "error");		
			}
		return null;
	}
}
