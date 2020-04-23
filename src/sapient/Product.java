package sapient;

import java.util.ArrayList;
import java.util.List;

public class Product {
    private String color;
    private double price;

    public Product(String color, double price) {
        this.color = color;
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public double getPrice() {
        return price;
    }

    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();

        Product p1 = new Product("red", 3);
        Product p2 = new Product("blue", 3);
        Product p3 = new Product("red", 4);
        Product p4 = new Product("green", 12);
        Product p5 = new Product("red", 5);
        products.add(p1);
        products.add(p2);
        products.add(p3);
        products.add(p4);
        products.add(p5);

        double avg = products.stream().filter(p -> p.getColor().equalsIgnoreCase("red"))
                .mapToDouble(Product::getPrice).average().orElse(Double.NaN);
        System.out.println(avg);
    }
}
