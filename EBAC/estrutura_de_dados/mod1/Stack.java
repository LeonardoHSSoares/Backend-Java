public class Stack {

    private int[] stack;
    private int top;
    private int capacity;

    public Stack(int capacity) {
        this.capacity = capacity;
        this.stack = new int[capacity];
        this.top = -1;
    }

    public void push(int value) {
        if (top == capacity - 1) {
            throw new StackOverflowError("Stack is full");
        }
        stack[++top] = value;
    }

    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return stack[top--];
    }

    public int top() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return stack[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int size() {
        return top + 1;
    }
}
