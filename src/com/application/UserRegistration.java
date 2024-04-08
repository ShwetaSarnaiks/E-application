package com.application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UserRegistration {

	private static int user_id;
	private static String firstname;
	private static String lastname;
	private static String city;
	private static String email_id;
	private static String mobile_number;
	private static String username;
	private static String password;

	public static void userRegistration() {

		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter userId: ");
		int user_id = scanner.nextInt();

		System.out.print("Enter First Name: ");
		String firstname = scanner.next();

		System.out.print("Enter Last Name: ");
		String lastname = scanner.next();

		System.out.print("Enter city: ");
		String city = scanner.next();

		System.out.print("Enter email_id: ");
		String email_id = scanner.next();

		System.out.print("Enter Mobile Number: ");
		String mobile_number = scanner.next();

		System.out.print("Enter UserName: ");
		String username = scanner.next();

		System.out.print("Enter Password: ");
		String password = scanner.next();

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");// load Driver

			Connection project = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root"); // connection

			// database Query
			String sql = "insert into user(user_id, firstname, lastname, city, email_id, mobile_number, username, password) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

			PreparedStatement preparedStatement = project.prepareStatement(sql);

			preparedStatement.setInt(1, user_id);
			preparedStatement.setString(2, firstname);
			preparedStatement.setString(3, lastname);
			preparedStatement.setString(4, city);
			preparedStatement.setString(5, email_id);
			preparedStatement.setString(6, mobile_number);
			preparedStatement.setString(7, username);
			preparedStatement.setString(8, password);
			preparedStatement.execute();

		}

		catch (ClassNotFoundException e) {

		} catch (SQLException e) {

			System.out.println(e.getMessage());
		}
		System.out.println("Register Successfully");
	}

}
