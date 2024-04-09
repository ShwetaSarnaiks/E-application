package com.application;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FinalProject {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		DisplyProductSorting disply = new DisplyProductSorting();
		BuyProduct buyproduct = new BuyProduct();
		ViewCart viewcart = new ViewCart();

		Scanner scanner = new Scanner(System.in);
		ArrayList<Product> cart = new ArrayList<>();
		boolean shopping = true;

		while (shopping) {
			// Display sorted products
			System.out.println("Products in sorted order:");
			disply.viewAllProduct();

			// User Operations
			System.out.println("1. Buy a product");
			System.out.println("2. View cart");
			System.out.println("3. Purchase");
			System.out.println("4. Exit");
			System.out.print("Choose an option: ");
			int option = scanner.nextInt();

			switch (option) {
			// to buy product
			case 1:
				buyproduct.buyProduct();
				break;
			// to view card of purchase products
			case 2:
				viewcart.getViewCart();

				break;
			// Total Amount
			case 3:
				int purchaseTotal = 0;
				for (Product product : cart) {
					purchaseTotal += product.getPrice();
				}
				System.out.println("Total amount to be paid: " + purchaseTotal);
				System.out.print("Confirm purchase (yes/no): ");
				String confirm = scanner.next();
				if (confirm.equalsIgnoreCase("yes")) {
					// if want to purchase yes else no
					System.out.println("Purchase successful..!");
					cart.clear();
				} else {
					System.out.println("Purchase cancelled...!");
				}
				break;
			case 4:
				shopping = false;
				System.out.println("Exit...!");
				break;
			default:
				System.out.println("Invalid option..!");
				break;
			}
		}

		// } catch (SQLException | ClassNotFoundException e) {
		// e.printStackTrace();
		// }
	}

}
