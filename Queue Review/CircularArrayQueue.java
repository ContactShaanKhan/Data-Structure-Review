import java.util.Arrays;

// Creating a queue implementation using a circular Queue
public class CircularArrayQueue implements QueueInterface<Integer> {
    private Integer[] arr;
    private int capacity;

    // Holds the index of the front and rear
    private int front, rear;

    private int currentSize;

    // Remember in a queue we add to the rear and remove from the front

    // Constructor just needs to intialize
    public CircularArrayQueue(int capacity) {
        this.arr = new Integer[capacity];
        this.capacity = capacity;
        this.front = 0;
        this.rear = 0;
        this.currentSize = 0;
    }

    public void enqueue(Integer obj) throws IllegalAccessException {
        if (isfull()) {
            throw new IllegalAccessException("Queue is full");
        }

        arr[rear] = obj;
        rear = (rear + 1) % capacity;

        this.currentSize++;
    }

    public Integer dequeue() throws IllegalAccessException {
        if (isempty())
            throw new IllegalAccessException("Queue is Empty");

        Integer out = arr[front];
        front = (front + 1) % capacity;

        this.currentSize--;

        return out;
    }

    public Integer peek() throws IllegalAccessException {
        if (isempty())
            throw new IllegalAccessException("Queue is Empty");

        return arr[front];
    }

    public boolean isfull() {
        return (this.currentSize == capacity);
    }

    public boolean isempty() {
        return (this.currentSize == 0);
    }

    public int getCapacity() {
        return this.capacity;
    }

    public String toString() {
        StringBuilder out = new StringBuilder();

        out.append("Front [");

        for (int i = this.front; i < this.front + this.currentSize; i++) {
            out.append(" (" + arr[i % capacity] + ")");
            
        }

        out.append(" ] Rear");

        return out.toString();
    }

    public void printActualQueue() {
        System.out.println(Arrays.toString(arr));
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

            queue.enqueue(8);
            queue.enqueue(9);
            queue.enqueue(10);
            queue.enqueue(11);
            queue.enqueue(12);

            System.out.println("State 4: " + queue);

            queue.dequeue();
            queue.dequeue();
        
            queue.enqueue(13);
            queue.enqueue(14);
            queue.enqueue(15);

            System.out.println("State 5: " + queue);
            queue.printActualQueue();

            System.out.println("Trying to add 1 beyond capacity...");
            queue.enqueue(15);
        } 
        catch (IllegalAccessException e) {
            System.err.println("Invalid access to Queue");
        }
    }
}
