package leetcodeProblems;

public class LongestTurbulentSubarray978 {
    public static void main(String[] args) {

        LongestTurbulentSubarray978 ob = new LongestTurbulentSubarray978();
//        int[] inputA = {9, 9};
//        int[] inputA = {9, 4, 2, 10, 7, 8, 1, 9};
//        int[] inputA = {9, 4, 2, 10, 7, 8};
//        int[] inputA = {9, 9, 4, 2, 10, 7, 8, 8, 1, 9};
//        int[] inputA = {0, 8, 45, 88, 48, 68, 28, 55, 17, 24};
        int[] inputA = {4, 8, 12, 16};
        int turbulenceSize = ob.maxTurbulenceSizeUsingTwoPointer(inputA);
        System.out.println(turbulenceSize);
    }

    public int maxTurbulenceSizeUsingTwoPointer(int[] A) {
        if (A.length == 1)
            return 1;

        int anchor = 0, i = 1;
        int sign;
        int maxLengthSofar = 1;
        while (i <= A.length - 1) {

            sign = Integer.compare(A[i - 1], A[i]);
            // Breaking cases to write
            // Good cases don't need to write
            // Case 1 : a == b
            if (sign == 0) {
                maxLengthSofar = Math.max(maxLengthSofar, i - anchor);
                anchor = i;
            }
            // Case 2 : a < b < c
            else if (i == A.length - 1 || (sign == -1 && Integer.compare(A[i], A[i + 1]) == -1)) {
                maxLengthSofar = Math.max(maxLengthSofar, i - anchor + 1);
                anchor = i;
            }
            // Case 3 : a > b > c
            else if (sign == 1 && Integer.compare(A[i], A[i + 1]) == 1) {
                maxLengthSofar = Math.max(maxLengthSofar, i - anchor + 1);
                anchor = i;
            }
            i++;
        }
        return maxLengthSofar;
    }
}

