package practice;

public class SearchInMountainArray {

    public static int search(int[] arr, int key) {

        return search(arr, 0, arr.length - 1, key);
    }

    public static int search(int[] arr, int l, int h, int key) {
        int m;

        while (l < h) {
            m = l + (h - l) / 2;

            if (arr[m] == key) return m;

            // case 1 : mountain element
            if (m + 1 < arr.length && arr[m] > arr[m + 1] &&
                    m - 1 >= 0 && arr[m] > arr[m - 1] && key < arr[m]) {
                int leftIndex = search(arr, l, m, key);

                if (leftIndex != -1) return leftIndex;
                else return search(arr, m, h, key);
            }
            // case 2 : descending
            else if (arr[m] > arr[m + 1] && key > arr[m])
                h = m;
            else
                l = m + 1;
        }

        if (arr[l] == key) return l;
        else return -1;

    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{1, 3, 8, 4, 3}, 4));
        System.out.println(search(new int[]{3, 8, 3, 1}, 8));
        System.out.println(search(new int[]{1, 3, 8, 12}, 12));
        System.out.println(search(new int[]{10, 9, 8}, 10));
        System.out.println(search(new int[]{10, 9, 8}, 20));
        System.out.println(search(new int[]{10, 9, 8}, 1));

    }
}
