//add product into cart

package com.application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class BuyProduct {

	private static int product_id;
	private static String description;
	private static String name;
	private static int price;
	private static int quantity;

	public static void buyProduct() throws ClassNotFoundException {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection project = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");
			Scanner scanner = new Scanner(System.in);
			System.out.print("Enter the product ID: ");
			int product_id = scanner.nextInt();
			String qury = "Select * from products WHERE product_id=?";
           
            PreparedStatement preparedStatement = project.prepareStatement(qury);
            
			preparedStatement.setInt(1, product_id);
			ResultSet result = preparedStatement.executeQuery();
			if (result.next()) {
				
				System.out.println("product add into cart");
			} else {
				System.out.println("Product not found for ID: " + product_id);
			}
			
			String sql="insert into cart(product_id, description, name, price, quantity)"+"values(?,?,?,?,?)";
			  preparedStatement = project.prepareStatement(sql);
			  preparedStatement.setInt(1, product_id);
	          preparedStatement.setString(2, description);
	          preparedStatement.setString(3, name);
	          preparedStatement.setInt(4, price);
	          preparedStatement.setInt(4, quantity);
	          
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
