import java.util.Arrays;
import java.util.function.Function;

// Stores key value pair
class LinHashNode 
{
    public int key;
    public String val;

    public LinHashNode(int key, String val)
    {
        this.key = key;
        this.val = val;
    }

    @Override
    public String toString()
    {
        return "(key: " + this.key + " ,val: " + this.val + ")";
    }
}

class LinHashTable 
{
    private int currentSize, maxSize;
    private LinHashNode[] table;
    private Function<Integer, Integer> h1;

    public LinHashTable(int size, Function<Integer, Integer> h1) 
    {
        this.currentSize = 0;
        this.maxSize = size;
        this.table = new LinHashNode[size];
        this.h1 = h1;
    }

    public boolean isEmpty()
    {
        return (this.currentSize == 0);
    }

    // Takes in key and probenum, returns index
    public int getInsertionIndex(int key, int probenum)
    {
        return (h1.apply(key) + (probenum * 1)) % this.maxSize;
    }

    // Remember - no duplicate keys!
    public void insert(int key, String val) 
    {        
        int index, probenum;

        // Call find to make sure we don't already have this key
        if(find(key) != null)
        {
            // Do nothing if we already have this key
            return;
        }

        // Create the node
        LinHashNode newNode = new LinHashNode(key, val);

        // Quick way to make sure we don't loop infinitely
        // Best way would be to check if we ever reach a duplicate element
        for(probenum = 0; probenum < this.maxSize; probenum++)
        {
            index = getInsertionIndex(key, probenum);

            // If this spot is empty, insert here
            if( this.table[index] == null )
            {
                this.table[index] = newNode;
                
                // Increment Current Size
                this.currentSize += 1;
                
                return;
            }
        }

        // Reach here if we cannot insert - this is the case when every location we
        //  tried to insert at had a collision              
    }

    // Find the given value with the value 'key'
    // And then delete it.
    // If the element does not exist, return null
    public String delete(int key)
    {
        int index, probenum;
        String val;

        // Quick way to make sure we don't loop infinitely
        // Best way would be to check if we ever reach a duplicate element
        for(probenum = 0; probenum < this.maxSize; probenum++)
        {
            index = getInsertionIndex(key, probenum);

            if(this.table[index] == null)
                continue;

            // Compare the key, if the same return the val
            if(this.table[index].key == key)
            {
                val = this.table[index].val;
                
                this.table[index] = null;

                return val;
            }
        }

        // Could not find the element
        return null;
    }

    // Given the key, find the associated value and return it
    public String find(int key)
    {
        int index, probenum;

        // Quick way to make sure we don't loop infinitely
        // Best way would be to check if we ever reach a duplicate element
        for(probenum = 0; probenum < this.maxSize; probenum++)
        {
            index = getInsertionIndex(key, probenum);

            if(this.table[index] == null)
                continue;

            // Compare the key, if the same return the val
            if(this.table[index].key == key)
            {
                return this.table[index].val;
            }
        }

        // Could not find the element
        return null;
    }

    @Override
    public String toString()
    {
        return Arrays.toString(this.table);
    }
}

public class LinearHashing 
{
    public static void main(String... args)
    {
        int key;
        String val;

        // Pick your size
        int size = 12;

        // Create the hash Function
        // Simply set it to multiply the key by 19, and add 12
        Function<Integer, Integer> h1 = (k) -> (k * 19 + 12);

        // Create a hashtable
        LinHashTable tbl = new LinHashTable(size, h1);

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
