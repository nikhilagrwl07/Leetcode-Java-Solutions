package practice;

public class FindMaxElementInBitonicArray {

    public static void main(String[] args) {
        SearchElementInBitonicArray b = new SearchElementInBitonicArray();
        System.out.println(searchMaxElementInBitonicArray(new int[] { 1, 3, 8, 12, 4, 2 }));
        System.out.println(searchMaxElementInBitonicArray(new int[] { 3, 8, 3, 1 }));
        System.out.println(searchMaxElementInBitonicArray(new int[] { 1, 3, 8, 12 }));
        System.out.println(searchMaxElementInBitonicArray(new int[] { 10, 9, 8 }));
    }

    public static int searchMaxElementInBitonicArray(int[] a) {

        int l = 0, m, h = a.length - 1;

        while (l < h) {
            m = l + (h - l) / 2;
            if (a[m] > a[m+1]) {
                h = m;
            } else {
                l = m+1;
            }
        }
        return l;
    }
}
