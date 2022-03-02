class LLNode {
    public int value;
    public LLNode next;

    public LLNode(int value) {
        this.value = value;
    }

    public LLNode(int value, LLNode next) {
        this.value = value;
        this.next = next;
    }
}

// "static void main" must be defined in a public class.
public class LinkedList {
    private LLNode head;

    public void addLastNode(int value) {
        LLNode newNode = new LLNode(value);
        if (head == null) {
            head = newNode;
        } else {
            LLNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Find the mean of a singly linked list
    public double findMean() {
        double sum = 0.0;
        double numElem = 0.0;

        for (LLNode ptr = head; ptr != null; ptr = ptr.next) {
            // Increment the total
            sum += ptr.value;
            // Increment the number of elements
            numElem++;
        }

        return (sum / numElem);
    }

    /**
     * Insert an element into a sorted linked list so as to preserve order
     * 
     * precondition: The list is sorted
     * postcondition: The list is sorted aswell, with new node.
     */
    public void insertPreserveOrder(int newValue) {
        // Create the new node
        LLNode newNode = new LLNode(newValue);

        // Check if empty
        if (head == null) {
            throw new IllegalArgumentException("Is Empty!");
        }

        // Check if one element
        else if (head.next == null) {
            // Place before head
            if (newValue <= head.value) {
                newNode.next = head;
                head = newNode;
            }
            // Place after the head
            else {
                head.next = newNode;
            }
        }

        // Otherwise traverse as normal
        else {
            LLNode ptr = head.next;
            LLNode prev = head;

            while(ptr != null) {
                if(newValue <= ptr.value) {
                    prev.next = newNode;
                    newNode.next = ptr;
                    break;
                }

                ptr = ptr.next;
                prev = prev.next;
            }
        }
    }

    // Method to remove all instances of a target value
    public void removeAllInstances(int targetValue) {
        // Check if empty
        if (head == null) {
            throw new IllegalArgumentException("Is Empty!");
        }

        // If one element
        else if (head.next == null) {
            if (head.value == targetValue) {
                head = null;
            }
        }

        // If at least 2 elements
        else {
            LLNode prev = head;
            LLNode ptr = head.next;

            while (ptr != null) {
                if (ptr.value == targetValue) {
                    // Delete ptr
                    prev.next = ptr.next;
                }

                // Increment the pointers
                prev = prev.next;
                ptr = ptr.next;
            }
        }
    }

    public void addTargetNode(int targetValue, int newValue) {
        LLNode newNode = new LLNode(newValue);
        if (head == null) {
            head = newNode;
        } else {
            LLNode current = head;
            LLNode previous = null;
            while (current.value != targetValue) {
                previous = current;
                current = current.next;
            }
            previous.next = newNode;
            newNode.next = current;
        }
    }

    public LLNode deletedLastNode() {
        LLNode current = head;
        LLNode previous = null;
        while (current.next != null) {
            previous = current;
            current = current.next;
        }
        previous.next = null;
        return current;
    }

    public LLNode deletedTargetNode(int value) {
        LLNode current = head;
        LLNode previous = null;
        while (current.value != value) {
            previous = current;
            current = current.next;
        }
        previous.next = current.next;
        return current;
    }

    public String toString() {
        String temp = "";
        LLNode current = head;
        while (current != null) {
            temp = temp + current.value + " -> ";
            current = current.next;
        }
        temp += " null";
        return temp;
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
        LinkedList temp = new LinkedList();
        temp.addLastNode(1);
        temp.addLastNode(5);
        temp.addLastNode(7);
        temp.addLastNode(8);
        temp.addLastNode(9);
        System.out.println(temp.toString());
        // print 15789

        temp.addTargetNode(7, 6);
        System.out.println(temp.toString());
        // print 156789

        temp.deletedLastNode();
        System.out.println(temp.toString());
        // print 15678

        temp.deletedTargetNode(6);
        System.out.println(temp.toString());
        // print 1578
    }
}
