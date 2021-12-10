import java.util.Arrays;

enum Relationship { leftChild, rightChild, Parent, Self };

class Heap 
{
    // Holds the values
    public int[] arr;
    // May not actually be the size of the array, but represents the size of the current heap
    public int size;

    // Initize empty heap
    public Heap(int size)
    {
        this.arr = new int[size];
        this.size = size;
    }

    // Initialize the heap from an array
    public Heap(int[] arr) 
    {
        this.arr = arr;
        this.size = arr.length;
    }

    // Initialize heap from arr (arr not assumed to be a heap)
    public static Heap build_max_heap(int[] arr) {
        // Initialize the heap
        Heap h;
        int index;
        
        h = new Heap(arr);

        // Get the node with the greatest index, that is not a leaf
        index = (int) ( (h.size - 1) / 2 );

        // Call max-heapify from index -> 0
        for(; index >= 0; index--)
        {
            h.max_heapify(index);
        }

        return h;
    }

    // Get index from Relationship r
    public int getIndex(Relationship r, int index)
    {
        switch (r) {
            case Parent:
                return (int) ((index - 1) / 2);
        
            case leftChild:
                return 2 * index;

            case rightChild:
                return 2 * index + 1;

            default:
            case Self:
                return index;
        }
    }

    public void swap(int a, int b) 
    {
        int temp = this.arr[a];
        this.arr[a] = this.arr[b];
        this.arr[b] = temp;
    }

    // “The process of walking down the element”
    // Uses this.arr
    public void max_heapify(int parentIndex) 
    {
        // Quick boundary check
        if(parentIndex < 0 || parentIndex >= this.size)
            return;

        int max, left, right;

        // Initialize them
        max = left = right = -1;

        // Find the max of the parent, left child, and right child
        
        left = getIndex(Relationship.leftChild, parentIndex);
        right = getIndex(Relationship.rightChild, parentIndex);

        // Check to make sure these values are in-bounds
        if(left >= this.size)
            left = -1;

        if(right >= this.size)
            right = -1;

        // If a leaf node - do nothing
        if(left == -1 && right == -1)
            return;

        // Else get the max of the 3
        if(left != -1)
            max = (this.arr[left] > this.arr[parentIndex])? left : parentIndex;
        
        if(right != -1)
            max =  (this.arr[right] > this.arr[max])? right : max;

        // If the parent is the largest - we're done
        if(max == parentIndex)
            return;

        // Now swap with the appropriate max
        swap(parentIndex, max);

        // Call max_heapify on maxIndex
        max_heapify(max);
    }

    // Sorting method (in place sorting meaning arr itself will be sorted, 
    //  and we are not returning a new sorted array)
    public static void sort(int[] arr) 
    {
        Heap h;

        // First create the max heap
        h = build_max_heap(arr);

        for(int i = arr.length - 1; i >= 0; i--)
        {
            h.swap(0, i);
            h.size -= 1;
            h.max_heapify(0);
        }
    }
}

public class HeapSort
{   public static void main(String... args) 
    {
        // Numbers we want to sort
        int[] arr = {12, 19, 7, 77, 99, 15, 47, 3, 55, 1, 69, 31, 32, 33};
        
        System.out.println("Initial array: " + Arrays.toString(arr));

        Heap.sort(arr);

        System.out.println("After sort: " + Arrays.toString(arr));
    }
}