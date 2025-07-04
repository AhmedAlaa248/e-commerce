package Product;

import java.time.LocalDate;

public class NonShipExpirableProduct extends Product{

    private LocalDate expirationDate;

    public NonShipExpirableProduct(String name, double price, int quantity, LocalDate expirationDate) {
        super(name, price, quantity);
        this.expirationDate = expirationDate;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }
}
