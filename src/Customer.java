import Product.NonShipExpirableProduct;
import Product.Product;
import Product.ShipExpireProd;
import Product.ShippableProduct;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Customer {

    private String name;
    private double balance;
    private List<Product> cart = new ArrayList<>();

    public Customer(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public void addToCart(Product product, int quantity) {
        if (product.getPrice() * quantity <= balance) {
            if (product.getQuantity() >= quantity) {
                LocalDate today = LocalDate.now();
                if (product instanceof ShipExpireProd) {
                    if (today.isAfter(((ShipExpireProd) product).getExpirationDate())) {
                        System.out.println("This " + product.getName() + " is expired and cannot be added to the cart.");
                        return;
                    }
                } else if (product instanceof NonShipExpirableProduct) {
                    if (today.isAfter(((NonShipExpirableProduct) product).getExpirationDate())) {
                        System.out.println("This " + product.getName() + " is expired and cannot be added to the cart.");
                        return;
                    }
                }
                Product purchasedProduct;

                if (product instanceof ShipExpireProd) {
                    purchasedProduct = new ShipExpireProd(product.getName(), product.getPrice(), quantity,
                            ((ShipExpireProd) product).getWeight(), ((ShipExpireProd) product).getExpirationDate());
                } else if (product instanceof ShippableProduct) {
                    purchasedProduct = new ShippableProduct(product.getName(), product.getPrice(), quantity,
                            ((ShippableProduct) product).getWeight());
                }else if (product instanceof NonShipExpirableProduct) {
                    purchasedProduct = new NonShipExpirableProduct(product.getName(), product.getPrice(), quantity,
                            ((NonShipExpirableProduct) product).getExpirationDate());
                } else {
                    purchasedProduct = new Product(product.getName(), product.getPrice(), quantity);
                }

//                Product purchasedProduct = new Product(product.getName(), product.getPrice(), quantity);
                product.decreaseQuant(quantity);

                cart.add(purchasedProduct);
                balance -= product.getPrice();
            } else {
                System.out.println("There is no enough " + product.getName() + " in stock");
            }
        } else {
            System.out.println("Your balance isn't enough to buy " + quantity + " " + product.getName() +
                    " You can only buy " + (int) (balance / product.getPrice()) + " of " + product.getName());
        }
    }

    public void checkout() {
        double totalWeight = 0.0;
        double totalPrice = 0.0;
        double shippingCost = 0.0;
        double totalWithShipping = 0.0;

        if (cart.isEmpty()) {
            System.out.println(this.name + " your cart is empty!");
        } else {
            System.out.println("##############################");
            System.out.println("** shipment notice **");

            totalWeight = ECommerce.ShippingService(cart);
            shippingCost = totalWeight * 0.025;

            System.out.println("\n** Checkout receipt **");
            for (Product product : cart) {
                double thisTotalPrice = product.getPrice() * product.getQuantity();
                totalPrice += thisTotalPrice;
                System.out.println(product.getQuantity() + "x " + product.getName() + "\t\t" + thisTotalPrice);
            }

            totalWithShipping = totalPrice + shippingCost;
            System.out.println("---------------------------------------------");
            System.out.println("Subtotal\t\t" + totalPrice);
            System.out.println("Shipping\t\t" + shippingCost);
            System.out.println("Amount\t\t" + totalWithShipping);


        }
        cart.clear();
    }
}


