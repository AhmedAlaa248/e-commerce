package Product;

public class Product {
    private String name;
    private double price;
    private int quantity;


    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void decreaseQuant(int q) {
        this.quantity -= q;
    }

    public Product generateObjWithQuant(int quantity) {
        return new Product(this.name, this.price, quantity);
    }}
