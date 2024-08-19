import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("Laptop", "Electronics", 1200.0),
                new Product("Coffee Maker", "Appliances", 80.0),
                new Product("Headphones", "Electronics", 150.0),
                new Product("Blender", "Appliances", 50.0),
                new Product("TV", "Electronics", 800.0),
                new Product("Refrigerator", "Appliances", 500.0)
        );

        Map<String, Double> averagePriceByCategory = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory, Collectors.averagingDouble(Product::getPrice)));

        System.out.println("Середня ціна за категоріями: " + averagePriceByCategory);

        String maxCategory = averagePriceByCategory.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("No category");

        System.out.println("Категорія з найвищою середньою ціною: " + maxCategory);
    }
}
