/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


import java.util.Arrays;

public class ClosestKpointsToOrigin {
    public static void main(String[] args) {
        int[][] point = {{1, 3}, {-2, 2}, {2, -2}};
        int k = 2;

//        int[][] point =  {{0,1},{1,0}};
//        int k = 2;
//                          4     5      4
//        int[][] point = {{3, 3}, {5, -1}, {-2, 4}};
//        int k = 2;

//        int[][] point = {{1, 3}, {-2, 2}};
//        int k = 1;

//        int[][] point = {{6, 10}, {-3, 3}, {-2, 5}, {0, 2}};
//        int k = 3;

        int[][] kClosest = kClosest(point, k);
        System.out.println(Arrays.deepToString(kClosest));

    }

//    public static int[][] kClosest(int[][] points, int K) {
//        int len = points.length, l = 0, r = len - 1;
//        while (l <= r) {
//            int mid = helper(points, l, r);
//            if (mid == K)
//                break;
//
//            if (mid < K) {
//                l = mid + 1;
//            }
//            else {
//                r = mid - 1;
//            }
//        }
//        return Arrays.copyOfRange(points, 0, K);
//    }
//
//    private static int helper(int[][] A, int l, int r) {
//        int[] pivot = A[l];
//
//        while (l < r) {
//            while (l < r && compare(A[r], pivot) >= 0)
//                r--;
//
//            A[l] = A[r];
//
//            while (l < r && compare(A[l], pivot) <= 0)
//                l++;
//
//            A[r] = A[l];
//        }
//        A[l] = pivot;
//        return l;
//    }
//
//    private static int compare(int[] p1, int[] p2) {
//        return p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1];
//    }


    // QuickSelect approach
    private static int[][] kClosest(int[][] points, int K) {
        int low = 0, high = points.length - 1;
        while (low <= high) {
            int partitionMiddle = partition(points, low, high, high);

            if (partitionMiddle == K) {
                break;
            } else if (partitionMiddle < K) {
                low = partitionMiddle + 1;
            } else {
                high = partitionMiddle - 1;
            }
        }
        return Arrays.copyOfRange(points, 0, K);

    }

    private static int partition(int[][] points, int low, int high, int partitionIndex) {

        int[] patitionCoordinates = points[partitionIndex];

        double partitionKey = distance(points, partitionIndex);

        while (low < high) {

            while (low < high && distance(points, low) < partitionKey) {
                low++;
            }

            points[high] = points[low];

            while (low < high && distance(points, high) > partitionKey) {
                high--;
            }

            points[low] = points[high];
        }

        points[high] = patitionCoordinates;
        return high;
    }

    private static double distance(int[][] points, int row) {
        int x = points[row][0];
        int y = points[row][1];

        return Math.sqrt((x * x) + (y * y));
    }

}
