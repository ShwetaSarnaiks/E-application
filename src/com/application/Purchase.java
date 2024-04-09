package com.application;
import java.util.Scanner;

public class Purchase {
	 static int purchaseTotal = 0;
	 public static void getOurchase() {
     for (Product product : cart) {
         purchaseTotal += product.getPrice();
     }
     System.out.println("Total amount to be paid: " + purchaseTotal);
     System.out.print("Confirm purchase (yes/no): ");
     Scanner scanner=new Scanner(System.in);
     String confirm = scanner.next();
     if (confirm.equalsIgnoreCase("yes")) {
 // if want to purchase yes else no
         System.out.println("Purchase successful..!");
         cart.clear();
     }

     }
}
