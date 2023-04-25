package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.OrderStatus;
import entities.Product;

public class OrderMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		System.out.println("Enter client data: ");
		
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Email: ");
			String email = sc.nextLine();
			System.out.println("Birth date (dd/MM/yyyy): ");
			LocalDate date = LocalDate.parse(sc.nextLine(), fmt);
			

			Client client = new Client(name, email, date);
		
		System.out.println("Enter order data: ");
		System.out.print("Status: ");
		OrderStatus status = OrderStatus.valueOf(sc.nextLine());
		
		Order order = new Order(new Date(), status, client);
		
		System.out.print("How many items to this order: ");
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			System.out.println("Enter #" + (i + 1) + " item data: ");
			System.out.print("Product name: ");
			String productName = sc.next();
			sc.nextLine();
			System.out.print("Product price: ");
			String maskPrice = sc.nextLine();
			double price = Double.parseDouble(maskPrice);
			System.out.print("Quantity: ");
			String maskQuantity = sc.nextLine();
			int quantity = Integer.parseInt(maskQuantity);
			
			OrderItem orderItem = new OrderItem(new Product(productName, price), quantity);
			order.addItem(orderItem);
		}
		System.out.println(" ");
		System.out.println("ORDER SUMMARY: ");
		System.out.println(order.toString());
		sc.close();

	}

}
