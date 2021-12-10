import java.util.Arrays;

public class SelectionSort 
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
    public static void selectionSort(int[] arr) 
    {
        for (int i = 0; i < arr.length - 1; i++) 
        {
            int min_index = i;
            for (int k = i + 1; k < arr.length; k++) 
            {
                if (arr[k] < arr[min_index]) 
                {
                    min_index = k;
                }
            }
            swap(arr, min_index, i);
        }
    }
    
    public static void main(String[] args) 
    {
        // Selection Sort
        int[] arr = { 100, 90, 80, 70, 12, 19, 77, 69, 72 };

        System.out.println("Before sort: " + Arrays.toString(arr));
        selectionSort(arr);
        System.out.println("After sort: " + Arrays.toString(arr));
    }
    
}
