import Product.NonShipExpirableProduct;
import Product.Product;
import Product.ShipExpireProd;
import Product.ShippableProduct;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        Customer customer1 = new Customer("Alaa", 10000.0);
        Customer customer2 = new Customer("Ahmed", 5000);

        ShippableProduct cheese = new ShipExpireProd("Cheese", 100.0, 5, 1500.0, LocalDate.of(2025, 12, 31));
        ShippableProduct milk = new ShipExpireProd("Milk", 100.0, 5, 1000.0, LocalDate.of(2023, 12, 31));
        ShippableProduct biscuits = new ShipExpireProd("Biscuits", 50.0, 10, 500.0, LocalDate.of(2026, 12, 31));

        ShippableProduct gum = new ShippableProduct("Gum", 10.0, 20, 100.0);
        ShippableProduct tv = new ShippableProduct("Tv", 24500.0, 20, 5100.0);

        Product ebook = new Product("E-book", 300.0, 5);

        Product psCard = new NonShipExpirableProduct("PSN card", 550, 6, LocalDate.of(2025, 8, 31));

        List<Product> products = new ArrayList<>();
        products.add(cheese);
        products.add(milk);
        products.add(biscuits);
        products.add(gum);
        products.add(tv);
        products.add(ebook);
        products.add(psCard);


        customer1.addToCart(cheese, 2);
        customer1.addToCart(biscuits, 1);
        customer1.addToCart(milk, 2);
        customer1.addToCart(ebook, 3);
        customer1.addToCart(gum, 3);
        customer1.addToCart(tv, 1);
        customer1.addToCart(ebook, 2);
        customer1.addToCart(psCard, 3);

        customer1.checkout();

        customer2.checkout();

        printSystemProducts(products);
    }

    public static void printSystemProducts(List<Product> products) {
        System.out.println("\n\n** Products in the system **");
        System.out.println("---------------------------------------------");
        System.out.printf("%-10s %-10s %-10s%n", "Name", "Price", "Quantity");
        System.out.println("---------------------------------------------");

        for (Product p : products)
            System.out.printf("%-10s %-10.1f %-10d %n", p.getName(), p.getPrice(), p.getQuantity());

        System.out.println("---------------------------------------------");
        System.out.println("** End of the program **");

    }
}