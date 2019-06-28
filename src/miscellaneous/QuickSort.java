package miscellaneous;

public class QuickSort {
    public static void main(String[] args) {

        int[] a = {2, -1, 10, 20, 13, 25, 16, 18};
        print(a);
        quickSort(a, 0, a.length - 1);
        print(a);

    }


    private static void quickSort(int[] a, int low, int high) {

        if (low < high) {
            int pivotIndex = partition(a, low, high);
            quickSort(a, low, pivotIndex - 1);
            quickSort(a, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {

        int pivotIndex = high;
        int smallerIndex = low - 1;

        for (int i = low; i < high; i++) {

            if (arr[i] < arr[pivotIndex]) {
                smallerIndex++;
                swap(arr, smallerIndex, i);
            }
        }
        swap(arr, smallerIndex + 1, pivotIndex);
        return smallerIndex + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }

    private static void print(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
}
