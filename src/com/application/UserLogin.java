package com.application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UserLogin {

	private static String userName;
	private static String password;

	public static void userLogin() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter UserName: ");
		String userName = scanner.nextLine();

		System.out.print("Enter Password: ");
		String password = scanner.nextLine();
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");// load Driver

			Connection project = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root"); // connection

			String query = "SELECT * FROM user WHERE userName = ? AND password = ?";

			PreparedStatement preparedStatement = project.prepareStatement(query);
			preparedStatement.setString(1, userName);
			preparedStatement.setString(2, password);

			// Executing the query
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				// Login successful
				System.out.println("User Login successful!");
			} else {
				// Login failed
				System.out.println("Invalid username or password. Please try again.");
			}

			// Closing the resources
			resultSet.close();
			preparedStatement.close();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
