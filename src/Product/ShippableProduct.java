package Product;

public class ShippableProduct extends Product implements ShippableInterface {

    private double weight;

    public ShippableProduct(String name, double price, int quantity, double weight) {
        super(name, price, quantity);
        this.weight = weight;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public Product generateObjWithQuant(int quantity) {
        return new ShippableProduct(this.getName(), this.getPrice(), quantity, this.weight);

    }
}
