package queues.medium;

// https://leetcode.com/problems/design-circular-queue/description/
// 622. Design Circular Queue
class MyCircularQueue {

    int[] buffer;
    int front;
    int rear;
    int size;
    int capacity;

    public MyCircularQueue(int k) {
        this.buffer = new int[k];
        this.front = -1;
        this.rear = -1;
        this.size = 0;
        this.capacity = k;
    }

    public boolean enQueue(int value) {
        if (isFull())
            return false;

        if (isEmpty())
            front = 0;
        rear = (rear + 1) % capacity;
        buffer[rear] = value;
        size++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty())
            return false;

        if (front == rear) {
            front = -1;
            rear = -1;
        } else
            front = (front + 1) % capacity;
        size--;
        return true;
    }

    public int Front() {
        if (isEmpty())
            return -1;
        return buffer[front];
    }

    public int Rear() {
        if (isEmpty())
            return -1;
        return buffer[rear];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }
}
