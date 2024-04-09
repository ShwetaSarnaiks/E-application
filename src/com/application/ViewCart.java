package com.application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ViewCart {
	public static void getViewCart() throws ClassNotFoundException, SQLException {

			Class.forName("com.mysql.cj.jdbc.Driver");

			// step-2 Establish the Connection
			Connection project = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");

			// step-3 Prepare the Statement

			String sql = "select * from cart";
			PreparedStatement preparedStatement = project.prepareStatement(sql);

			ResultSet set = preparedStatement.executeQuery();

			while (set.next()) {
				// Product_id
				System.out.println("product_id>> " + set.getInt(1) + " | Product_Name>> " + set.getString(3)
						+ " | price>> " + set.getInt(4) + " | Description>> " + set.getString(2)
						+ " |Quantity>> " + set.getInt(5));

			}
	}
	
}
			

	
