import java.util.Arrays;
import java.util.Comparator;

public class ECommerceSearchTest {

    public static void main(String[] args) {

        // Array of products for linear search (order doesn't matter)
        Product[] products = {
            new Product(105, "Wireless Mouse", "Electronics"),
            new Product(102, "Cotton T-Shirt", "Apparel"),
            new Product(108, "Bluetooth Speaker", "Electronics"),
            new Product(101, "Yoga Mat", "Fitness"),
            new Product(110, "Office Chair", "Furniture")
        };

        // Sorted copy of the same products, required for binary search
        Product[] sortedProducts = products.clone();
        Arrays.sort(sortedProducts, Comparator.comparingInt(Product::getProductId));

        int targetId = 108;

        // Linear Search
        long startLinear = System.nanoTime();
        Product foundLinear = SearchAlgorithms.linearSearch(products, targetId);
        long endLinear = System.nanoTime();

        System.out.println("--- Linear Search ---");
        System.out.println(foundLinear != null ? "Found: " + foundLinear : "Product not found.");
        System.out.println("Time taken: " + (endLinear - startLinear) + " ns");

        // Binary Search
        long startBinary = System.nanoTime();
        Product foundBinary = SearchAlgorithms.binarySearch(sortedProducts, targetId);
        long endBinary = System.nanoTime();

        System.out.println("\n--- Binary Search ---");
        System.out.println(foundBinary != null ? "Found: " + foundBinary : "Product not found.");
        System.out.println("Time taken: " + (endBinary - startBinary) + " ns");
    }
}