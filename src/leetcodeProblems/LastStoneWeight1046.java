package leetcodeProblems;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class LastStoneWeight1046 {
    public static void main(String[] args) {

        int[] stoneWeight = {2, 7, 4, 1, 8, 1};
        LastStoneWeight1046 ob = new LastStoneWeight1046();
        int lastStoneWeight = ob.lastStoneWeight(stoneWeight);
        System.out.println(lastStoneWeight);
    }

    public int lastStoneWeight(int[] stones) {

        if (stones.length == 1)
            return stones[0];


        Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int weight : stones) {
            maxHeap.offer(weight);
        }

        while (maxHeap.size() > 1) {

            Integer maximumWeight = maxHeap.poll();
            Integer secondMaximumWeight = maxHeap.poll();

            if (maximumWeight == secondMaximumWeight) {
                continue;
            }

            maxHeap.offer(maximumWeight - secondMaximumWeight);
        }

        if (maxHeap.isEmpty())
            return 0;
        else {
            return maxHeap.poll();
        }

    }
}
