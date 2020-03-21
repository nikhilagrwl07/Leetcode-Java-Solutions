package leetcodeProblems.medium;

import java.util.PriorityQueue;
import java.util.Queue;

public class MinCostToConnectRopes1167 {
    public static void main(String[] args) {

        MinCostToConnectRopes1167 ob = new MinCostToConnectRopes1167();
//        int[] sticks = {1, 8, 3, 5};
        int[] sticks = {3354, 4316, 3259, 4904, 4598, 474, 3166, 6322, 8080, 9009};

        int totalCost = ob.connectSticks(sticks);
        System.out.println(totalCost);
    }

    public int connectSticks(int[] sticks) {
        if (sticks == null || sticks.length == 0)
            return 0;

        Queue<Integer> pq = new PriorityQueue<>();

        for (int i : sticks) {
            pq.offer(i);
        }

        int totalCost = 0;
        while (pq.size() >= 2) {
            int currentCost = pq.poll() + pq.poll();
            totalCost += currentCost;
            pq.offer(currentCost);
        }
        return totalCost;
    }
}
