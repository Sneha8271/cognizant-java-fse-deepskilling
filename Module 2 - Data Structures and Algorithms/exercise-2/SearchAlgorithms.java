public class SearchAlgorithms {

    // Linear Search: works on unsorted array, checks every element one by one
    public static Product linearSearch(Product[] products, int targetId) {
        for (int i = 0; i < products.length; i++) {
            if (products[i].getProductId() == targetId) {
                return products[i]; // found
            }
        }
        return null; // not found
    }

    // Binary Search: requires a SORTED array, repeatedly halves the search space
    public static Product binarySearch(Product[] sortedProducts, int targetId) {
        int low = 0;
        int high = sortedProducts.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int midId = sortedProducts[mid].getProductId();

            if (midId == targetId) {
                return sortedProducts[mid]; // found
            } else if (midId < targetId) {
                low = mid + 1; // search right half
            } else {
                high = mid - 1; // search left half
            }
        }
        return null; // not found
    }
}