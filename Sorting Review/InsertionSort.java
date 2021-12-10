import java.util.Arrays;

public class InsertionSort 
{
    public static void swap(int[] arr, int a, int b) 
    {
        if (a == b)
            return;
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    } 
    
    // In place sorting
    public static void insertionSort(int[] arr) 
    {
        for (int i = 1; i < arr.length; i++) 
        {
            int k, key = arr[i];
            for (k = i - 1; k >= 0 && arr[k] > key; k--) 
            {
                arr[k + 1] = arr[k];
            }
            arr[k + 1] = key;
        }
    }
    public static void main(String... args)
    {
        // Insertion Sort
        int[] arr = { 100, 90, 80, 70, 12, 19, 77, 69, 72 };

        System.out.println("Before sort: " + Arrays.toString(arr));
        insertionSort(arr);
        System.out.println("After sort: " + Arrays.toString(arr));
    }
    
}
