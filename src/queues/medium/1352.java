package queues.medium;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/product-of-the-last-k-numbers/description/
// 1352. Product of the Last K Numbers
class ProductOfNumbers {
    private List<Integer> prefixProducts;

    public ProductOfNumbers() {
        this.prefixProducts = new ArrayList<>();
        this.prefixProducts.add(1);
    }

    public void add(int num) {
        if (num == 0) {
            // If we add 0, we reset our list as all future products will be 0
            this.prefixProducts = new ArrayList<>();
            this.prefixProducts.add(1);
        } else {
            int lastProduct = this.prefixProducts.get(this.prefixProducts.size() - 1);
            this.prefixProducts.add(lastProduct * num);
        }
    }

    public int getProduct(int k) {
        int n = this.prefixProducts.size();
        if (k > n - 1)
            return 0;

        return this.prefixProducts.get(n - 1) / this.prefixProducts.get(n - k - 1);
    }
}