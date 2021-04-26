package practice;

public class SearchElementInBitonicArray {
    public static void main(String[] args) {
        SearchElementInBitonicArray b = new SearchElementInBitonicArray();
        System.out.println(searchElementInBitonicArray(new int[]{1, 3, 8, 12, 4, 2}, 4));
        System.out.println(searchElementInBitonicArray(new int[]{3, 8, 3, 1}, 1));
        System.out.println(searchElementInBitonicArray(new int[]{1, 3, 8, 12}, 3));
        System.out.println(searchElementInBitonicArray(new int[]{10, 9, 8}, 10));
        System.out.println(searchElementInBitonicArray(new int[]{10, 9, 8}, 100));
    }

    public static int searchElementInBitonicArray(int[] a, int key) {
        int maxElementIndex = searchMaxElementInBitonicArray(a);
        int index = binarySearch(a, 0, maxElementIndex, key);
        if(index!=-1) return index;
        return binarySearchDesc(a, maxElementIndex+1, a.length-1, key);

    }

    private static int binarySearchDesc(int[] a, int low, int high, int key) {
        if(key > a[low] || key < a[high]) return -1;

        while (low <= high) {
            int m = low + (high - low) / 2;
            if (a[m] == key)
                return m;
            else if (a[m] < key) {
                high = m - 1;
            } else
                low = m + 1;
        }
        return -1;
    }

    private static int binarySearch(int[] a, int low, int high, int key) {

        if (key < a[low] || a[high] < key) return -1;

        while (low <= high) {
            int m = low + (high - low) / 2;
            if (a[m] == key)
                return m;
            else if (a[m] < key) {
                low = m + 1;
            } else
                high = m - 1;
        }
        return -1;
    }

    public static int searchMaxElementInBitonicArray(int[] a) {

        int l = 0, m, h = a.length - 1;

        while (l < h) {
            m = l + (h - l) / 2;
            if (a[m] > a[m + 1]) {
                h = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
}
