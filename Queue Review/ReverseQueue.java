import java.util.Stack;

public class ReverseQueue {
    public static void reverseQueue(CircularArrayQueue queue) {
        Stack<Integer> stk = new Stack<>();

        // Move Everything from the queue to the stack
        while (!queue.isempty()) {
            try {
                stk.push(queue.dequeue());
            } 
            catch (IllegalAccessException e) {
                /* Unreachable... */
                e.printStackTrace();
            }
        }

        // Move everything from the stack to the queue
        while (!stk.isEmpty()) {
            try {
                queue.enqueue(stk.pop());
            } catch (IllegalAccessException e) {
                /* Unreachable... */
                e.printStackTrace();
            }
        }
    }

    public static void main (String... args) {
        /// Create the queue
        CircularArrayQueue queue = new CircularArrayQueue(10);

        try {
            queue.enqueue(1);
            queue.enqueue(2);
            queue.enqueue(3);
            queue.enqueue(4);
            queue.enqueue(5);
            queue.enqueue(6);
            queue.enqueue(7);
            queue.enqueue(8);
            queue.enqueue(9);
            queue.enqueue(10);
        } 
        catch (IllegalAccessException e) {
            System.err.println("Invalid access to Queue");
        }

        System.out.println("Initial Queue: " + queue);

        reverseQueue( queue );

        System.out.println("After Reverse: " + queue);
    }
}
