package com.application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DisplyProductSorting {

	public static void viewAllProduct() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");// load Driver
			Connection project = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root"); // connection
			String query = "Select * from products ORDER by name,price";
			PreparedStatement ps = project.prepareStatement(query);

			ResultSet resultSet = ps.executeQuery();
			while (resultSet.next()) {
				// Product_id
				System.out.println("product_id>> " + resultSet.getInt(1) + " | Product_Name>> " + resultSet.getString(3)
						+ " | price>> " + resultSet.getString(4) + " | Description>> " + resultSet.getString(2)
						+ " |Quantity>> " + resultSet.getString(5));

			}
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Sorting Order.....");
		}

	}

}
