/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package miscellaneous;

public class FindTargetElementInSortedRotatedArray {
    public static void main(String[] args) {

        FindTargetElementInSortedRotatedArray ob = new FindTargetElementInSortedRotatedArray();

//        int[] a = {2, 4, 12, 15, 100, 101};

        // Duplicate #1 - more than one first element
//        int[] a = {2, 2, 2, 4, 12, 15, 100, 101};

        // Duplicate #2 - more than one last element
//        int[] a = {15, 100, 2, 4, 12, 12, 12, 12};


        // Duplicate #3 - more than one pivot element
        int[] a = {13, 14, 15, 16, 100, 100, 100, 100, 100, 2, 4, 12};

//        int[] a = {15, 100, 2, 4, 12};
//        int[] a = {1, 2, 4, 5, 6, 60, 75};
        int element = 2;

        int targetElementIndex = ob.findTargetElement(a, element);
        System.out.println(targetElementIndex);
    }

    private int findTargetElement(int[] a, int element) {

        if (a == null || a.length == 0) {
            return -1;
        }

        int pivotIndex = findPivot(a, 0, a.length - 1);

        if (pivotIndex == -1) {
            pivotIndex = a.length - 1;
        }

        if (element >= a[0] && element <= a[pivotIndex]) {
            return findTargetElementUtil(a, 0, pivotIndex, element);
        } else {
            return findTargetElementUtil(a, pivotIndex + 1, a.length - 1, element);
        }
    }

    private int findPivot(int[] a, int low, int high) {

        if (low >= high) {
            return -1;
        }

        int mid = low + (high - low) / 2;

        // in middle part 1
        if (mid - 1 >= low && a[mid - 1] > a[mid]) {
            return mid - 1;
        }

        // in middle part 2
        if (mid + 1 <= high && a[mid + 1] < a[mid]) {
            return mid;
        }

        int pivotIndex = findPivot(a, low, mid-1);

        if (pivotIndex != -1) {
            return pivotIndex;
        } else {
            return findPivot(a, mid + 1, high);
        }
    }


    private int findTargetElementUtil(int[] a, int low, int high, int element) {

        if (low > high)
            return -1;

        int mid = low + (high - low) / 2;

        if (a[mid] == element) {
            return mid;
        }

        if (a[mid] > element) {
            return findTargetElementUtil(a, low, mid - 1, element);
        } else
            return findTargetElementUtil(a, mid + 1, high, element);
    }

}
