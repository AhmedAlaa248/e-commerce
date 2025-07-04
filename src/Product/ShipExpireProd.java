package Product;

import java.time.LocalDate;

public class ShipExpireProd extends ShippableProduct {

    private LocalDate expirationDate;

    public ShipExpireProd(String name, double price, int quantity, double weight, LocalDate expirationDate) {
        super(name, price, quantity, weight);
        this.expirationDate = expirationDate;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }
}
