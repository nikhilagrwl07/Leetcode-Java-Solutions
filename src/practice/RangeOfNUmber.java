package practice;

public class RangeOfNUmber {
    public static void main(String[] args) {
        int[] result = findRange(new int[]{4, 6, 6, 6, 9}, 6);
        System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
        result = findRange(new int[]{1, 3, 8, 10, 15}, 10);
        System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
        result  = findRange(new int[]{1, 3, 8, 10, 15}, 12);
        System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
        result = findRange(new int[]{}, 1);
        System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
    }


    public static int[] findRange(int[] arr, int key) {
        int[] result = new int[]{-1, -1};
        if(arr.length==0) return result;
        int leftIndex = firstOccurrence(arr, key);
        if (leftIndex == -1) return result;

        int rightIndex = lastOccurrenceIndex(arr, key);

        return new int[]{leftIndex, rightIndex};

    }

    public static int firstOccurrence(int[] a, int key) {
        if (key < a[0])
            return -1;
        int l = 0, m, h = a.length - 1, keyIndex = -1;

        while (l <= h) {
            m = l + (h - l) / 2;

            if (a[m] < key) {
                l = m + 1;
            } else if (a[m] > key) {
                h = m - 1;
            } else {
                keyIndex = m;
                h = m-1;
            }
        }
        return keyIndex;
    }

    public static int lastOccurrenceIndex(int[] a, int key) {
        if (key > a[a.length - 1])
            return -1;

        int l = 0, m, h = a.length - 1, keyIndex = -1;

        while (l <= h) {
            m = l + (h - l) / 2;

            // key is on right
            if (a[m] < key) {
                l = m + 1;
            } else if(a[m] > key){
                h = m - 1;
            }
            else{
                keyIndex = m;
                l = m+1;
            }
        }
        return keyIndex;
    }
}
