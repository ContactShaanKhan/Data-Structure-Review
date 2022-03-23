public class ArrayStack {

    // First we need the array
    int[] arr;
    int size;

    public ArrayStack(int maxSize) {
        arr = new int[maxSize];
        size = 0;
    }

    // General Plan: The Bottom of the stack is fixed at index 0
    // Operations we need:
    // Push
    // Pop
    // Peek

    public void push(int val) throws IllegalArgumentException {
        // Check if the stack is full
        if (size + 1 == arr.length)
            throw new IllegalArgumentException();

        arr[size] = val;
        size++;

        // Cool enough you could write the previous 2 lines as `arr[size++] = val`
    }

    // Return the element at the top
    public int peek() {
        // Check if the array is empty
        if (size == 0)
            throw new IllegalArgumentException();

        return arr[size - 1];
    }

    public int pop() {
        // Check if the array is empty
        if (size == 0)
            throw new IllegalArgumentException();

        int top = arr[size - 1];
        size--;

        return top;

        // Cool enough you could write the previous 3 lines in 1 as `return arr[--size]`
    }

    @Override
    public String toString() {
        String out = "(Bottom) [ ";

        for (int i = 0; i < size; i++) {
            out += " " + arr[i] + " ";
        }

        out += " (top)";

        return out;
    }

    public static void main(String... args) {
        ArrayStack stk = new ArrayStack(12);

        System.out.println("Initial Stack: " + stk);

        stk.push(12);
        stk.push(24);

        System.out.println("Top Element should be 24: " + stk.peek());

        stk.pop();

        stk.push(13);
        stk.push(14);
        stk.push(15);

        System.out.println("Current Stack: " + stk);
    }
}