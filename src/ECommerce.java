import Product.Product;
import Product.ShippableProduct;

import java.util.List;

public class ECommerce {
    public static double ShippingService (List<Product> products){
        double totalWeight = 0;
        for (Product product : products) {
            if(product instanceof ShippableProduct){
                double totalPWeight = ((ShippableProduct) product).getWeight() * product.getQuantity();
                totalWeight += totalPWeight;
                System.out.println(product.getQuantity() + "x " + product.getName() + "\t\t" + totalPWeight + "grams");
            }
        }

        System.out.println("Total package weight: " + totalWeight/1000 + " KG");
        return totalWeight;
    }

}
