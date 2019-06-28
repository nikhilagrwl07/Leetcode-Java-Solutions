package leetcodeProblems;

public class RotateArray {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        int distance = 3;
        printArray(arr);
        rotateByDistance(arr, distance);
        printArray(arr);
    }


    //    Time complexity : O(n)
//    Auxiliary Space : O(1)
    private static void rotateByDistance(int[] a, int r) {
        if (a == null || a.length <= r) {
            return;
        }

        //Find GCD
        int gcd = GCD(a.length, r);

        int times = 0;

        while (times < gcd) {
            rotateInBlock(a, times, r);
            times++;
        }

    }

    private static void rotateInBlock(int[] a, int startIndex, int distance) {

        int temp = a[startIndex];
        int current = startIndex;

        while ((current + distance) <= a.length - 1) {
            a[current] = a[current + distance];
            current = current + distance;
        }
        a[a.length - distance + startIndex] = temp;

    }

    private static int GCD(int a, int b) {

        if (b == 0)
            return a;
        else {
            return GCD(b, a % b);
        }
    }

    private static void printArray(int[] a) {

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
}
