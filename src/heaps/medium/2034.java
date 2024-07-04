package heaps.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

// https://leetcode.com/problems/stock-price-fluctuation/description/
// 2034. Stock Price Fluctuation 
class StockPrice {

    class Stock {
        int timestamp;
        int price;

        public Stock(int timestamp, int price) {
            this.timestamp = timestamp;
            this.price = price;
        }

    }

    Map<Integer, Integer> timestamps;
    int maxTimeStamp;
    PriorityQueue<Stock> maxHeap;
    PriorityQueue<Stock> minHeap;

    public StockPrice() {
        timestamps = new HashMap<>();
        maxTimeStamp = 0;
        maxHeap = new PriorityQueue<>((a, b) -> b.price - a.price);
        minHeap = new PriorityQueue<>((a, b) -> a.price - b.price);
    }

    public void update(int timestamp, int price) {
        maxTimeStamp = Math.max(timestamp, maxTimeStamp);
        timestamps.put(timestamp, price);
        maxHeap.add(new Stock(timestamp, price));
        minHeap.add(new Stock(timestamp, price));
    }

    public int current() {
        return timestamps.get(maxTimeStamp);
    }

    public int maximum() {
        while (!maxHeap.isEmpty() && maxHeap.peek().price != timestamps.get(maxHeap.peek().timestamp)) {
            maxHeap.poll();
        }

        return maxHeap.peek().price;
    }

    public int minimum() {
        while (!minHeap.isEmpty() && minHeap.peek().price != timestamps.get(minHeap.peek().timestamp)) {
            minHeap.poll();
        }

        return minHeap.peek().price;
    }
}
