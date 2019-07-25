/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package miscellaneous;

import java.util.PriorityQueue;
import java.util.Queue;

public class MergeFilesInMinimumCost {
    public static void main(String[] args) {

//        int numOfSubFiles = 4;
//        int[] subFilesSize = {20, 4, 8, 2};

        int numOfSubFiles = 6;
        int[] subFilesSize = {1, 2, 5, 10, 35, 89};

        MergeFilesInMinimumCost ob = new MergeFilesInMinimumCost();
        int mergeSubFiledInMinimumCost = ob.mergeSubFiledInMinimumCost(subFilesSize, numOfSubFiles);
        System.out.println(mergeSubFiledInMinimumCost);
    }

    // Greedy Approach
    // Time Complexity - O(NLogN) where N is number of sub files
    // Space Complexity - O(N) where N is number of sub files
    public int mergeSubFiledInMinimumCost(int[] subFilesSize, int numOfSubFiles) {

        if (numOfSubFiles < 2) {
            return -1;
        }

        if (numOfSubFiles == 2) {
            return subFilesSize[0] + subFilesSize[1];
        }

        Queue<Integer> minHeap = new PriorityQueue<>(numOfSubFiles);
        for (int subFileSize : subFilesSize) {
            minHeap.add(subFileSize);
        }

        int cost = 0;
        while (minHeap.size() >= 2) {
            int file1 = minHeap.poll();
            int file2 = minHeap.poll();
            int total = file1 + file2;
            minHeap.add(total);
            cost += total;
        }

        return cost;

    }
}
