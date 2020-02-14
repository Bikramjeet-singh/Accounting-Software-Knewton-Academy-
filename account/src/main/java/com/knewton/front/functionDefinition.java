package com.knewton.front;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.knewton.model.Category;
import com.knewton.model.DailyTransaction;
import com.knewton.model.Item;
import com.knewton.model.ItemComposite;

public class functionDefinition {
	public functionDefinition() {

	}

	PreparedStatement ps;
	ResultSet rs;

	void addcategory(JTextField a)			 // add category function for confirm button
	{
	String s1 = a.getText();
	try {
	Connect connect = new Connect();
	Connection connection = connect.getConnection();
	connect.ps = connection.prepareStatement("insert into category(categoryName) values(?);");
	//connect.ps.setString(1, "categoryName");
	connect.ps.setString(1, s1);
	connect.ps.executeUpdate();
	JOptionPane.showMessageDialog(null, "data saved successfully");
	} catch (Exception ex) {
	ex.printStackTrace();
	JOptionPane.showMessageDialog(null, "error");
	}
	}

	public String ViewProfit(Date date1, Date date2) {
		float profit = 0;
		String x = null;

		try {
			Connect connect = new Connect();
			Connection connection = connect.getConnection();
			connect.ps = connection.prepareStatement("select * from dailytransactions  where date BETWEEN ? AND ? ;");
			connect.ps.setDate(1, date1);
			connect.ps.setDate(2, date2);
			rs = connect.ps.executeQuery();

			List<DailyTransaction> listdl = new ArrayList<DailyTransaction>();

			while (rs.next()) {
			//	System.out.println(rs);
				// int p=dailytransactions.itemcomposite;

				ItemComposite itemComposite = new ItemComposite(rs.getInt("itemId"), rs.getInt("billId"));

				DailyTransaction d = new DailyTransaction(itemComposite, rs.getFloat("actualPrice"),
						rs.getInt("quantity"), rs.getInt("transactionTypeId"), rs.getDate("date"));
				listdl.add(d);
			}
		//	System.out.println(listdl + "\n" + date1 + "\n" + date2);
			int q1 = 0, q2 = 0, q3 = 0;
			float costprice = 0, cp = 0, cpp = 0;
			for (DailyTransaction dc : listdl) {
				if (dc.getTransactionTypeId() == 1) {
					q3 = dc.getQuantity();
					cpp = dc.getActualPrice();
					profit -= (q3 * cpp);

				}

				else if (dc.getTransactionTypeId() == 2) {
					cp = dc.getActualPrice();
					q1 = dc.getQuantity();
					profit += (cp * q1);

				} else if (dc.getTransactionTypeId() == 3) {
					q2 = dc.getQuantity();
					costprice = dc.getActualPrice();
					profit -= (q2 * costprice);

				}
			}
			x = String.valueOf(profit);

		} catch (SQLException | ClassNotFoundException e) {

			e.printStackTrace();
		}

		return x;

	}

	ArrayList<String> getcategoryname() {
		ArrayList<String> categoryname = new ArrayList<String>();
		try {
			Connect connect = new Connect();
			Connection connection = connect.getConnection();
			connect.ps = connection.prepareStatement("select * from category");
			rs = connect.ps.executeQuery();
			while (rs.next()) {
				Category c = new Category(rs.getInt("categoryId"), rs.getString("categoryName"));
				categoryname.add(c.getCategoryName());
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "error");
		}

		return categoryname;
	}



	public ArrayList<String> getiname(String cname) {
		ArrayList<String> al = new ArrayList<>();
		int x = 0;

		try {

			Connect connect = new Connect();
			Connection connection = connect.getConnection();
			connect.ps = connection.prepareStatement("select categoryId from category  where categoryName = ?;");
			connect.ps.setString(1, cname);

			rs = connect.ps.executeQuery();
			if (rs.next()) {
				x = rs.getInt("categoryId");
			}
			// x = rs.getInt("categoryId");
			connect.ps = connection.prepareStatement("select * from item  where categoryId = ?;");
			connect.ps.setInt(1, x);
			rs = connect.ps.executeQuery();

			while (rs.next()) {
				Item d = new Item(rs.getInt("categoryId"), rs.getInt("itemId"), rs.getString("itemName"),
						rs.getFloat("sellingPrice"), rs.getFloat("buyingPrice"), rs.getInt("quantity"));
				al.add(d.getItemName());
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return al;

	}

	public ArrayList<DailyTransaction> showdailytransactions() {
		ArrayList<DailyTransaction> al = new ArrayList<>();

		try {

			Connect connect = new Connect();
			Connection connection = connect.getConnection();
			connect.ps = connection.prepareStatement("select * from dailytransactions;");

			rs = connect.ps.executeQuery();

			while (rs.next()) {

				ItemComposite itemComposite = new ItemComposite(rs.getInt("itemId"), rs.getInt("billId"));

				DailyTransaction d = new DailyTransaction(itemComposite, rs.getFloat("actualPrice"),
						rs.getInt("quantity"), rs.getInt("transactionTypeId"), rs.getDate("date"));
				al.add(d);

			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return al;

	}
	
	void additem(JTextField a, String cname, float buy, float sell) {
		String s1 = a.getText();
		int x = 0;
		try {
		Connect connect = new Connect();
		Connection connection = connect.getConnection();
		connect.ps = connection.prepareStatement("select categoryId from category  where categoryName = ?;");
		connect.ps.setString(1, cname);

		rs = connect.ps.executeQuery();
		if(rs.next())
		{
		x = rs.getInt("categoryId");
		}
		connect.ps = connection.prepareStatement("insert into item(?,?,?) values(?,?,?) where categoryId = ?;");
		connect.ps.setString(1, "itemName");
		connect.ps.setString(2, "sellingPrice");
		connect.ps.setString(3, "buyingPrice");
		connect.ps.setString(4, s1);
		connect.ps.setFloat(5, buy);
		connect.ps.setFloat(6, sell);
		connect.ps.setInt(7, x);

		connect.ps.executeUpdate();
		JOptionPane.showMessageDialog(null, "data saved successfully");
		} catch (Exception ex) {
		ex.printStackTrace();
		JOptionPane.showMessageDialog(null, "error");
		}
		}


	ArrayList<DailyTransaction> tplist = new ArrayList<DailyTransaction>();

	public void qtyChangeBuy() {
	int p = 0, oqty = 0;
	while (p < tplist.size()) {
	try {

	Connect connect = new Connect();
	Connection connection = connect.getConnection();

	connect.ps = connection.prepareStatement("select quantity from item  where itemid = ?;");
	connect.ps.setInt(1, tplist.get(p).getItemcomposite().getItemId());

	rs = connect.ps.executeQuery();
	int x = rs.getInt("quantity");
	if (tplist.get(p).getQuantity() > x) {
	System.out.println("Enter valid quantity");

	} else {

	oqty = x - tplist.get(p).getQuantity();
	connect.ps = connection.prepareStatement("update item set quantity=?  where itemid = ?;");
	connect.ps.setInt(1, oqty);
	connect.ps.setInt(2, tplist.get(p).getItemcomposite().getItemId());
	rs = connect.ps.executeQuery();

	}
	} catch (Exception ex) {
	ex.printStackTrace();
	}

	}
	}
	// ArrayList<DailyTransaction> tplist = new ArrayList<DailyTransaction>();
	ItemComposite itemcomp = new ItemComposite();

	public void templist(ItemComposite itemcomp, float price, int quant, int ttid, Date date) {
	int p = 0;
	for (int i = 0; i < tplist.size(); i++) {
	ItemComposite itemcomp1 = tplist.get(i).getItemcomposite();
	if (itemcomp1.getItemId() == itemcomp.getItemId()) {
	tplist.get(i).setQuantity(quant);
	p = 1;
	break;

	}

	}
	if (p == 0) {
	DailyTransaction dt = new DailyTransaction(itemcomp, price, quant, ttid, date);
	tplist.add(dt);

	}

	}
	


	public ArrayList<Item> viewStock() {
		ArrayList<Item> list = new ArrayList<>();

		try {

		Connect connect = new Connect();
		Connection connection = connect.getConnection();
		connect.ps = connection.prepareStatement("select * from item");

		rs = connect.ps.executeQuery();

		while (rs.next()) {
		Item i = new Item(rs.getInt("categoryId"), rs.getInt("itemId"), rs.getString("itemName"),
		rs.getFloat("sellingPrice"), rs.getFloat("buyingPrice"), rs.getInt("quantity"));
		list.add(i);
		}
		} catch (Exception ex) {
		ex.printStackTrace();
		}

		return list;

		}



	
	public String getprice(int ttid, String iname) {
		String x = null;
		try {

			Connect connect = new Connect();
			Connection connection = connect.getConnection();
			if (ttid == 2 || ttid == 3) {
				connect.ps = connection.prepareStatement("select sellingPrice from item  where itemName = ? ;");
				connect.ps.setString(1, iname);
				rs = connect.ps.executeQuery();

				if (rs.next()) {
					x = rs.getString("sellingPrice");
				}
			} else if (ttid == 1) {
				connect.ps = connection.prepareStatement("select buyingPrice from item  where itemName = ? ;");
				connect.ps.setString(1, iname);
				rs = connect.ps.executeQuery();

				if (rs.next()) {
					x = rs.getString("buyingPrice");
				}
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return x;

	}

}
