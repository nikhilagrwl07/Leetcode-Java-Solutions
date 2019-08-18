package leetcodeProblems;

import java.util.*;

public class SlidingWindowMaximum239 {
    public static void main(String[] args) {

        SlidingWindowMaximum239 ob = new SlidingWindowMaximum239();

//        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
//        int windowSize = 3;

        int[] nums = {9, 10, 9, -7, -4, -8, 2, -6};
        int windowSize = 5;
        int[] slidingWindow = ob.maxSlidingWindow(nums, windowSize);
        System.out.println(Arrays.toString(slidingWindow));

    }

    // Time Complexity - O(N * Log(K)) where N = total number of element and K is window size

    public int[] maxSlidingWindow(int[] nums, int k) {

        if (nums == null || nums.length == 0 || nums.length < k) {
            return new int[0];
        }

        // maxHeap
        Queue<Node> maxHeap = new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());
        Map<Integer, Node> map = new HashMap<>(); // index to node mapping

        // put initial dump
        for (int i = 0; i < k; i++) {
            Node n = new Node(nums[i]);
            map.put(i, n);
            maxHeap.offer(n);
        }

        int[] result = new int[nums.length - k + 1];
        int index = 0;

        result[index++] = maxHeap.peek().getValue();

        for (int i = k; i < nums.length; i++) {

            // delete value at i-k index from mao and then heap
            Node nodeToDeleted = map.get(i - k);
            maxHeap.remove(nodeToDeleted);
            map.remove(i - k);

            // insert new element in heap and map
            Node node = new Node(nums[i]);
            map.put(i, node);
            maxHeap.offer(node);

            // find current max from sliding window
            result[index++] = maxHeap.peek().getValue();
        }

        return result;

    }

    class Node {
        int value;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }
}
