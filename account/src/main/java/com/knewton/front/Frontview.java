   package com.knewton.front;

import java.awt.EventQueue;
import com.knewton.front.functionDefinition;
import com.knewton.model.DailyTransaction;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
//import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JList;

public class Frontview extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static Connection con = null;
	public functionDefinition fd= new functionDefinition();
	int i;
	//private JTable table;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {

					Frontview frame = new Frontview();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	 public static DefaultTableModel buildTableModel(ResultSet rs)
		        throws SQLException {

		    ResultSetMetaData metaData = rs.getMetaData();

		    // names of columns
		    Vector<String> columnNames = new Vector<String>();
		    int columnCount = metaData.getColumnCount();
		    for (int column = 1; column <= columnCount; column++) {
		        columnNames.add(metaData.getColumnName(column));
		    }

		    // data of the table
		    Vector<Vector<Object>> data = new Vector<Vector<Object>>();
		    while (rs.next()) {
		        Vector<Object> vector = new Vector<Object>();
		        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
		            vector.add(rs.getObject(columnIndex));
		        }
		        data.add(vector);
		    }

		    return new DefaultTableModel(data, columnNames);

		}
	
	public Frontview() throws SQLException {
		setBackground(new Color(204, 204, 255));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 942, 570);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(176, 196, 222));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("ADD ITEM");
		btnNewButton.setFont(new Font("Candara", Font.BOLD, 14));
		btnNewButton.setBackground(new Color(245, 245, 245));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				additem ai = new additem();
				ai.setVisible(true);
				setVisible(false);

			}
		});
		btnNewButton.setBounds(44, 168, 200, 50);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("ADD CATEGORY");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addcategory ac = new addcategory();
				ac.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_1.setBackground(new Color(245, 245, 245));
		btnNewButton_1.setFont(new Font("Candara", Font.BOLD, 14));
		btnNewButton_1.setBounds(44, 94, 200, 50);
		contentPane.add(btnNewButton_1);

		JButton btnViewProfit = new JButton("VIEW PROFIT");
		btnViewProfit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login lo = new login();
				lo.setVisible(true);
				setVisible(false);
			}
		});
		btnViewProfit.setBackground(new Color(245, 245, 245));
		btnViewProfit.setFont(new Font("Candara", Font.BOLD, 14));
		btnViewProfit.setBounds(44, 242, 200, 50);
		contentPane.add(btnViewProfit);

		JButton btnNewButton_2 = new JButton("VIEW STOCK");
		btnNewButton_2.setFont(new Font("Candara", Font.BOLD, 14));
		btnNewButton_2.setForeground(new Color(0, 0, 0));
		btnNewButton_2.setBackground(new Color(245, 245, 245));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewstock vs = new viewstock();
				vs.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_2.setBounds(44, 315, 200, 50);
		contentPane.add(btnNewButton_2);

		JButton button = new JButton("+");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				transactiontype tt = new transactiontype();
				tt.setVisible(true);
				setVisible(false);

			}
		});
		button.setBackground(new Color(245, 245, 245));
		button.setFont(new Font("Tahoma", Font.BOLD, 16));
		button.setBounds(755, 94, 109, 36);
		contentPane.add(button);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(100, 149, 237));
		panel.setBounds(0, 0, 936, 57);
		contentPane.add(panel);

		JLabel lblNewLabel = new JLabel("KNEWTON ACCOUNTING");
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 22));
		lblNewLabel.setBackground(new Color(240, 240, 240));
		lblNewLabel.setForeground(new Color(0, 0, 102));
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(70, 130, 180));
		panel_1.setBounds(0, 486, 936, 55);
		contentPane.add(panel_1);

		JButton btnUpdateItem = new JButton("UPDATE ITEM");
		btnUpdateItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnUpdateItem.setBackground(new Color(245, 245, 245));
		btnUpdateItem.setFont(new Font("Candara", Font.BOLD, 14));
		btnUpdateItem.setBounds(44, 388, 200, 50);
		contentPane.add(btnUpdateItem);
		
		JList<String> list = new JList<String>();
		list.setBounds(387, 156, 310, 297);
		contentPane.add(list);
		
		JLabel lblNewLabel_1 = new JLabel("Bill-Id   Item-Id    Price    Quantity     TT-Id           Date");
		lblNewLabel_1.setFont(new Font("Candara", Font.BOLD, 12));
		lblNewLabel_1.setBounds(388, 142, 321, 14);
		contentPane.add(lblNewLabel_1);
		
		DefaultListModel<String> DLM=new DefaultListModel<String>();
		ArrayList<DailyTransaction> al=fd.showdailytransactions();
		
		System.out.println(al);
		for(int i=0;i<al.size();i++)
		{
			DLM.addElement(al.get(i).toString());
			list.setModel(DLM);
		}
		
		
	}
}
