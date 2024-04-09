package com.adminapplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class AddProduct {

	private static int product_id;
	private static String description;
	private static String name;
	private static int price;
	private static int quantity;

	public static void addProductItems() throws SQLException {
		try {
			// step-1 Load the Driver class
			Class.forName("com.mysql.cj.jdbc.Driver");

			// step-2 Establish the Connection
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");

			String sql = "insert into products(product_id, description, name, price, quantity)" + "values(?,?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setInt(1, product_id);
			preparedStatement.setString(2, description);
			preparedStatement.setString(3, name);
			preparedStatement.setInt(4, price);
			preparedStatement.setInt(4, quantity);
			Scanner scanner = new Scanner(System.in);
			System.out.println("Please enter product_id");
			int product_id = scanner.nextInt();

			System.out.println("Please enter description");
			String description = scanner.next();

			System.out.println("Please enter name");
			String name = scanner.next();

			System.out.println("Please enter price");
			int price = scanner.nextInt();

			System.out.println("Please enter quantity");
			int quantity = scanner.nextInt();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();

		}

		System.out.println("Record inserted Successfully..");

	}

}
