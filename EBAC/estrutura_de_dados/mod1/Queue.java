public class Queue {
    private int[] queue;
    private int front;
    private int rear;
    private int capacity;
    private int count;

    public Queue(int capacity) {
        this.capacity = capacity;
        this.queue = new int[capacity];
        this.front = 0;
        this.rear = -1;
        this.count = 0;
    }

    public void enqueue(int value) {
        if (count == capacity) {
            throw new IllegalStateException("Queue is full");
        }
        rear = (rear + 1) % capacity;
        queue[rear] = value;
        count++;
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        int value = queue[front];
        front = (front + 1) % capacity;
        count--;
        return value;
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return queue[front];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int size() {
        return count;
    }
}
