package hash_tables.medium;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/apply-discount-every-n-orders/description/
// 1357. Apply Discount Every n Orders
class Cashier {
    private int n;
    private int discount;
    private int customerCount;
    private Map<Integer, Integer> productPrices;

    public Cashier(int n, int discount, int[] products, int[] prices) {
        this.n = n;
        this.discount = discount;
        this.customerCount = 0;
        this.productPrices = new HashMap<>();

        for (int i = 0; i < products.length; i++) {
            productPrices.put(products[i], prices[i]);
        }
    }

    public double getBill(int[] product, int[] amount) {
        customerCount++;
        double total = 0;

        for (int i = 0; i < product.length; i++) {
            total += productPrices.get(product[i]) * amount[i];
        }

        if (customerCount % n == 0) {
            total = total * (1 - discount / 100.0);
        }

        return total;
    }
}
