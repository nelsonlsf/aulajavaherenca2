package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.Date;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Product> products = new ArrayList<>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();
				
		for(int i=1; i<=n; i++) {
			System.out.println("Product #" + i + " data:");
			System.out.print("Common, used or imported (c/u/i): ");
			char a = sc.next().charAt(0);
			if(a == 'i' || a == 'I') {
				System.out.print("Name: ");
				sc.nextLine();
				String name = sc.nextLine();
				System.out.print("Price: ");
				Double price = sc.nextDouble();
				System.out.print("Customs fee: ");
				Double CustomsFee = sc.nextDouble();
				products.add(new ImportedProduct(name, price, CustomsFee));
			}
			else if(a == 'c' || a == 'C') {
				System.out.print("Name: ");
				sc.nextLine();
				String name = sc.nextLine();
				System.out.print("Price: ");
				Double price = sc.nextDouble();
				products.add(new Product(name, price));
			}
			else {
				System.out.print("Name: ");
				sc.nextLine();
				String name = sc.nextLine();
				System.out.print("Price: ");
				Double price = sc.nextDouble();
				System.out.print("Manufacture date(DD/MM/YYYY): ");
				Date date = sdf.parse(sc.next()); //Forçar a 
				products.add(new UsedProduct(name, price, date));
				
			}
		}
		
		System.out.println();
		System.out.println();
		System.out.println("PRICE TAGS:");
		for(Product p : products) {
			System.out.println(p.priceTag());
		}

	}

}
