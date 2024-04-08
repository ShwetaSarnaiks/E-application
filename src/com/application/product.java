package com.application;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class product {

	private static int product_id;
	private static String description;
	private static String name;
	private static int price;
	private static int quantity;

	public product(int product_id, String name, String description, int price, int quantity) {
				        this.product_id=product_id;
				        this.description=description;
				    	this.name = name;
				        this.price = price;
				        this.quantity=quantity;
				    }

	public int getproduct_id() {
		return product_id;
	}

	public String getdescription() {
		return description;
	}

	public String getname() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public int getquantity() {
		return quantity;
	}

	@Override
	public String toString() {
		return "Product{" + "product_id=" + product_id + "description=" + description + "name='" + name + "price="
				+ price + "quantity=" + quantity + '}';

	}

}
