import java.util.function.Function;

class HashNode 
{
    public int key;
    public String val;
    public HashNode next;

    public HashNode(int key, String val)
    {
        this.key = key;
        this.val = val;
        this.next = null;
    }

    @Override
    public String toString()
    {
        return "(key: " + this.key + " ,val: " + this.val + ")";
    }
}

class HashTable 
{
    private int currentSize, maxSize;
    private HashNode[] table;
    private Function<Integer, Integer> hashFunction;

    public HashTable(int size, Function<Integer, Integer> hashFunction) 
    {
        this.currentSize = 0;
        this.maxSize = size;
        this.table = new HashNode[size];
        this.hashFunction = hashFunction;
    }

    public boolean isEmpty()
    {
        return (this.currentSize == 0);
    }

    // Takes in key, returns index
    public int getInsertionIndex(int key)
    {
        return hashFunction.apply(key) % this.maxSize;
    }

    // Remember - no duplicate keys!
    public void insert(int key, String val) 
    {        
        int index = getInsertionIndex(key);

        // Create New Node
        HashNode node = new HashNode(key, val);

        // Get starting Node
        HashNode ptr = this.table[index];        

        // If List is empty, just insert the new node
        if(ptr == null) 
        {
            this.table[index] = node;
            return;
        }

        // Get to the end of the linked list
        // Also, check to see if we have a duplicate here
        while(ptr.next != null)
        {
            // If we find a duplicate key, we can't insert
            if(ptr.key == key)
                return;

            ptr = ptr.next;
        }

        // ** Once we reach here, ptr points to the last node (so next at ptr == null) **
        
        // We need to check if the last node is a duplicate
        if(ptr.key == key)
            return;

        // Insert new node
        ptr.next = node;

        // Increment Current Size
        this.currentSize += 1;
    }

    // Find the given value with the value 'key'
    // And then delete it.
    // If the element does not exist, return null
    public String delete(int key)
    {
        int index = getInsertionIndex(key);

        // Get starting Node of list (aka the chain)
        HashNode ptr = this.table[index];   
        // Keep track of previous pointer
        HashNode prev = null;

        // Go through entire chain
        while(ptr != null)
        {
            if(ptr.key == key)
            {
                String val = ptr.val;
                
                // If the first node in the chain
                if(prev == null)
                    this.table[index] = ptr.next;
                else
                    prev.next = ptr.next;

                // Decrement current size
                this.currentSize -= 1;

                return val;
            }

            prev = ptr;
            ptr = ptr.next;
        }

        // Reach here if we went through the entire chain.  So that means it doesn't exist
        return null;
    }

    // Given the key, find the associated value and return it
    public String find(int key)
    {
        int index = getInsertionIndex(key);

        // Get starting Node of list (aka the chain)
        HashNode ptr = this.table[index];   

        // Go through entire chain
        while(ptr != null)
        {
            if(ptr.key == key)
            {
                return ptr.val;
            }

            ptr = ptr.next;
        }

        return null;
    }

    @Override
    public String toString()
    {
        StringBuilder out = new StringBuilder();

        for(int i = 0; i < this.maxSize; i++)
        {
            out.append("[index: " + i + "] -> ");
            
            HashNode ptr = this.table[i];

            // Now go through the linked-list
            // Go through entire chain
            while(ptr != null)
            {
                out.append(ptr + " -> ");
                ptr = ptr.next;
            }

            out.append("null\n");
        }

        return out.toString();
    }
}


public class ChainHashing 
{
    public static void main(String... args)
    {
        int key;
        String val;

        // Pick your size
        // If you set the size to 1, you force all the elements into 1 chain
        int size = 3;

        // Create the hash Function
        // Simply set it to multiply the key by 19, and add 12
        Function<Integer, Integer> hashFunction = (k) -> (k * 19 + 12);

        // Create a hashtable
        HashTable tbl = new HashTable(size, hashFunction);

        // Put elements we want to insert into an array for simplicity
        String[] arr = {"I", "Love", "My", "Dog", "Named", "Shadow", "So", "Much", "!"};

        for(int i = 0; i < arr.length; i++) 
        {
            // Set the key to be i
            key = i;
            val = arr[i];

            tbl.insert(key, val);
        }

        System.out.println("With all elements:\n" + tbl);
 
        // Delete item with key 6 which here would be the "So"
        tbl.delete(6);

        System.out.println("After deleting 'So':\n" + tbl);

        // Delete item with key 4 which here would be the "Named"
        tbl.delete(4);

        System.out.println("After deleting 'So' and 'Named':\n" + tbl);
    }
}
