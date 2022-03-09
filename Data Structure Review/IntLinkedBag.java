class IntNode {
    public IntNode next;
    public int val;

    public IntNode(int val) {
        this.val = val;
    }
}

class IntList {
    public IntNode head;
    public IntNode cursor;

    public IntList() {
        head = cursor = null;
    }

    public int getNodeData() {
        if (cursor == null)
            throw new NullPointerException();

        // Return the data for what the cursor points to
        return cursor.val;
    }

    public void resetCursor() {
        cursor = head;
    }

    public void advanceCursor() {
        if (cursor == null)
            throw new NullPointerException();

        cursor = cursor.next;
    }

    public void addNewHead(int val) {
        IntNode newNode = new IntNode(val);

        if (head == null) {
            head = cursor = newNode;
        } else {
            newNode.next = head;
            head = newNode;
            // We shouldnt reset cursor here! We only reset on resetCursor()
        }
    }

    // This essentially returns the whole list
    private IntNode getHead() {
        return head;
    }

    public void appendList(IntList newList) {
        // If list is empty
        if(head == null) {
            head = newList.getHead();
            cursor = head;
            return;
        }

        // Get to end of this this list
        IntNode tail = head;

        while(tail.next != null) {
            tail = tail.next;
        }

        tail.next = newList.getHead();
    }
}

public class IntLinkedBag implements Cloneable {

    // Instance variables

    // Linked List
    private IntList data;
    // Keeps count of current number of items
    private int manyItems;

    public IntLinkedBag() {
        manyItems = 0;
        data = new IntList();
    }

    public int size() {
        return manyItems;
    }

    // Capacity is seemingly infinite
    public int getCapacity() {
        return Integer.MAX_VALUE;
    }

    public void ensureCapacity(int minimum) {
        /*
         * Since a linked list can easily expand, no need to ensure anything, just add.
         */
    }

    public void add(int element) {
        data.addNewHead(element);
        manyItems++;
    }

    private IntList getData() {
        return data;
    }

    public void addAll(IntLinkedBag addend) {
        data.appendList(addend.getData());
        manyItems += addend.size();
    }

    public int countOccurrences(int target) {
        int answer = 0;
        int index;
        data.resetCursor();
        for (index = 0; index < manyItems; index++) {
            if (target == data.getNodeData())
                answer++;
            data.advanceCursor();
        }
        return answer;
    }
}
