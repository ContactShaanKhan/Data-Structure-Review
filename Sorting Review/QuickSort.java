import java.util.Arrays;

public class QuickSort 
{
    // Worst case of qsort: When already sorted, because if so... our pivot is
    // always at the start/end.

    private static void swap(int[] arr, int i, int j) 
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static int partition(int[] arr, int low, int high) 
    {
        int pivot, i, j;

        // Select the pivot using your prefered method
        // I'll choose the last element
        pivot = arr[high];

        // Goal:
        // [ every elem < pivot, pivot, every elem >= pivot ] ]

        // Pivot index: will me index of the right most elem in the elem < pivot section
        // we start before low since there may not even be an elem < pivot
        i = (low - 1);

        // We ignore the pivot for now
        for (j = low; j < high; j++) 
        {
            if (arr[j] < pivot) 
            {
                i = i + 1;
                swap(arr, i, j);
            }
        }

        // Place the pivot at the right location
        swap(arr, i + 1, high);

        return (i + 1);
    }

    private static void qsort(int[] arr, int low, int high) 
    {
        int pivot;

        if (low < high) 
        {
            pivot = partition(arr, low, high);

            qsort(arr, low, pivot - 1);
            qsort(arr, pivot + 1, high);
        }
    }

    public static void sort(int[] arr) 
    {
        qsort(arr, 0, arr.length - 1);
    }
    public static void main(String[] args) 
    {
        int[] arr = { 10, 13, 12, 7, 50, 25, 1, 72, 77, 31, 32, 19, 69, 19, 2 };

        System.out.println("Before sort: " + Arrays.toString(arr));

        QuickSort.sort(arr);

        System.out.println("After sort: " + Arrays.toString(arr));
    }
}
