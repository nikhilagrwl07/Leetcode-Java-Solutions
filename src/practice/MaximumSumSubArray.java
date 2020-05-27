package practice;

public class MaximumSumSubArray {
    public static void main(String[] args) {
        MaximumSumSubArray ob = new MaximumSumSubArray();
        int[] a1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] a2 = {-2};
        int[] a3 = {-2, 4};
        int[] a4 = {-2, -4, -1};
        int[] a5 = {-2, -4, 0};
//        System.out.println(ob.maxSubArray(a1));
//        System.out.println(ob.maxSubArray(a2));
//        System.out.println(ob.maxSubArray(a3));
//        System.out.println(ob.maxSubArray(a4));
//        System.out.println(ob.maxSubArray(a5));

        System.out.println(ob.maxSubArrayUsingDAndC(a1));
//        System.out.println(ob.maxSubArrayUsingDAndC(a2));
//        System.out.println(ob.maxSubArrayUsingDAndC(a3));
//        System.out.println(ob.maxSubArrayUsingDAndC(a4));
//        System.out.println(ob.maxSubArrayUsingDAndC(a5));
    }

    // Time - O(N)
    // Space - O(1)
    public int maxSubArray(int[] a) {
        if (a == null || a.length == 0)
            return 0;

        int historySum = a[0];
        int maxSum = a[0];

        for (int i = 1; i < a.length; i++) {
            historySum = Math.max(historySum + a[i], a[i]);
            maxSum = Math.max(maxSum, historySum);
        }
        return maxSum;
    }

    public int maxSubArrayUsingDAndC(int[] a) {
        if (a == null || a.length == 0)
            return 0;
        return maxSubArrayUtil(a, 0, a.length - 1);
    }

    private int maxSubArrayUtil(int[] a, int left, int right) {
        if (left == right)
            return a[left];

        int middle = left + (right - left) / 2;

        System.out.println(left + " : " + middle + " : " + right);

        int leftSum = maxSubArrayUtil(a, left, middle);
        int rightSum = maxSubArrayUtil(a, middle + 1, right);
        int crossSum = crossSum(a, left, right, middle);

        return Math.max(leftSum, Math.max(rightSum, crossSum));
    }

    private int crossSum(int[] a, int left, int right, int middle) {
        Integer leftSum = maxSubArray(a, middle, left); // right --> left
        Integer rightSum = maxSubArray(a, middle + 1, right); // left --> right
        return (leftSum != null ? leftSum : 0) + (rightSum != null ? rightSum : 0);
    }

    public Integer maxSubArray(int[] a, int low, int high) {
        if (low < 0 || high > a.length - 1)
            return null;

        if (low >= high) {
            int historySum = a[low];
            int maxSum = a[low];

            for (int i = low - 1; i >= high; i--) {
                historySum = historySum + a[i];
                maxSum = Math.max(maxSum, historySum);
            }
            return maxSum;
        }

        int historySum = a[low];
        int maxSum = a[low];

        for (int i = low + 1; i <= high; i++) {
            historySum = historySum + a[i];
            maxSum = Math.max(maxSum, historySum);
        }
        return maxSum;
    }
}
