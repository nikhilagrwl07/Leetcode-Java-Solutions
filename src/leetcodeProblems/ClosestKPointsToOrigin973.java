package leetcodeProblems;


import java.util.Arrays;

public class ClosestKPointsToOrigin973 {
    public static void main(String[] args) {
//        int[][] point = {{1, 3}, {-2, 2}, {2, -2}};
//        int k = 2;

//        int[][] point =  {{0,1},{1,0}};
//        int k = 2;
//                          4     5      4
//        int[][] point = {{3, 3}, {5, -1}, {-2, 4}};
//        int k = 2;
        //                  41      61        52
//        int[][] point = {{-5, 4}, {-6, -5}, {4, 6}};
//        int k = 2;

//        int[][] point = {{1, 3}, {-2, 2}};
//        int k = 1;

//        int[][] point = {{6, 10}, {-3, 3}, {-2, 5}, {0, 2}};
//        int k = 3;

        int[][] point = {{10,-2},{2,-2},{10,10},{9,4},{-8,1}};
        int k = 4;

        ClosestKPointsToOrigin973 ob = new ClosestKPointsToOrigin973();

        int[][] kClosest = ob.kClosest(point, k);
        System.out.println(Arrays.deepToString(kClosest));

    }


    private int[][] kClosest(int[][] points, int K) {
        quickSelect(points, 0, points.length - 1, K);
        return Arrays.copyOfRange(points, 0, K);
    }

    // Approach - QuickSelect Approach
    // Time Complexity - O(N) -- Not able to understand time complexity - Need to revisit and understand again
    // Space Complexity - O(1)
    private void quickSelect(int[][] points, int start, int end, int k) {

        if (start > end)
            return;

        int pivotIndex = end;
        int pivotDistance = distance(points[pivotIndex]);

        int s = start, e = pivotIndex - 1;
        while (s < e) {

            while (s < e && distance(points[s]) <= pivotDistance) {
                s++;
            }

            while (s < e && distance(points[e]) >= pivotDistance) {
                e--;
            }

            if (distance(points[s]) > pivotDistance
                    && distance(points[e]) < pivotDistance) {
                swap(s, e, points);
                s++;
                e--;
            }
        }

        if (distance(points[pivotIndex]) < distance(points[e])) {
            swap(pivotIndex, e, points);
        }
        else{
            e = pivotIndex;
        }



        int distance = e - start + 1;
        if (k < distance) {
            quickSelect(points, start, e - 1, k);
        } else if (k > distance) {
            quickSelect(points, e + 1, end, k - distance);
        }

    }

    private void swap(int s, int e, int[][] points) {
        int[] start = points[s];
        points[s] = points[e];
        points[e] = start;

    }

    private int distance(int[] a) {

        return (a[0] * a[0]) + (a[1] * a[1]);
    }


    // Approach - Priority Queue (Using K size Max Heap)
    // Time Complexity - O(NlogK)
    // Space Complexity - O(K)
//    private int[][] kClosest(int[][] points, int K) {
//
//        int[][] result = new int[K][2];
//
//        Comparator<Pair<Integer, Integer>> c =
//                (p1, p2) -> (((p2.getKey() * p2.getKey()) + (p2.getValue() * p2.getValue()))
//                                - ((p1.getKey() * p1.getKey()) + (p1.getValue() * p1.getValue())));
//
//        Queue<Pair<Integer, Integer>> q = new PriorityQueue<>(c);
//
//        // Create Max Heap of size K
//
//        for (int i = 0; i < points.length; i++) {
//            q.add(new Pair<>(points[i][0], points[i][1]));
//
//            if (q.size() > K) {
//                q.poll();
//            }
//        }
//
//        int row = 0;
//        while (!q.isEmpty()) {
//            Pair<Integer, Integer> pair = q.poll();
//            result[row][0] = pair.getKey();
//            result[row][1] = pair.getValue();
//            row++;
//        }
//
//        return result;
//    }
}
