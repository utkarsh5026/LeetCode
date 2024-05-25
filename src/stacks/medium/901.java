package stacks.medium;

import java.util.*;

// https://leetcode.com/problems/online-stock-span/description
// 901. Online Stock Span
class StockSpanner {

    class Stock {
        int price;
        int span;

        public Stock(int span, int price) {
            this.price = price;
            this.span = span;
        }
    }

    Deque<Stock> stocks;

    public StockSpanner() {
        this.stocks = new ArrayDeque<>();
    }

    public int next(int price) {
        int span = 1;

        while (!stocks.isEmpty() && stocks.peekLast().price <= price) {
            span += stocks.pollLast().span;
        }

        stocks.add(new Stock(span, price));
        return span;
    }
}