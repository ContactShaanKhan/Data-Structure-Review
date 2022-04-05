// Creating a queue implementation using a circular Queue
public class CircularArrayQueue implements QueueInterface<Integer> {
    private Integer[] arr;
    private int capacity;

    // Holds the index of the front and rear
    private int front, rear;

    // Remember in a queue we add to the rear and remove from the front

    // Constructor just needs to intialize
    public CircularArrayQueue(int capacity) {
        this.arr = new Integer[capacity];
        this.capacity = capacity;
        this.front = this.rear = 0;
    }

    public void enqueue(Integer obj) throws IllegalAccessException {
        if (isfull()) {
            throw new IllegalAccessException("Queue is full");
        }

        arr[rear] = obj;
        rear = (rear + 1) % capacity;
    }

    public Integer dequeue() throws IllegalAccessException {
        if (isempty())
            throw new IllegalAccessException("Queue is Empty");

        Integer out = arr[front];
        front = (front + 1) % capacity;

        return out;
    }

    public Integer peek() throws IllegalAccessException {
        if (isempty())
            throw new IllegalAccessException("Queue is Empty");

        return arr[front];
    }

    public boolean isfull() {
        return ((rear + 1) % capacity == front);
    }

    public boolean isempty() {
        return (front == rear);
    }

    public int getCapacity() {
        return this.capacity;
    }

    public String toString() {
        StringBuilder out = new StringBuilder();

        out.append("Front [");

        // We assume type T has a toString
        for (int i = front; i != rear; i = (i + 1) % capacity) {
            out.append(" (" + arr[i] + ")");
        }

        out.append(" ] Rear");

        return out.toString();
    }

    /* ------------------------ Testing ------------------------ */

    public static void main (String... args) {
        CircularArrayQueue queue = new CircularArrayQueue(10);

        try {
            queue.enqueue(1);
            queue.enqueue(2);
            queue.enqueue(3);
            queue.enqueue(4);
            queue.enqueue(5);
            queue.enqueue(6);

            System.out.println("State 1: " + queue);

            Integer out = queue.dequeue();

            System.out.println("State 2: " + queue + " | Removed: " + out);

            queue.dequeue();
            queue.dequeue();
            queue.enqueue(7);

            System.out.println("State 3: " + queue);
        } 
        catch (IllegalAccessException e) {
            System.err.println("Invalid access to Queue");
        }
    }
}
