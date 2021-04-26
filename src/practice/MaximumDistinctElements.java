package practice;

import java.util.*;

class MaximumDistinctElements {

    public static int findMaximumDistinctElements(int[] nums, int k) {
        // frequency of all elements
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i : nums) {
            freq.put(i, freq.getOrDefault(i, 0) + 1);
        }

        Queue<Integer> minHeap = new PriorityQueue<>((e1, e2) -> freq.get(e1) - freq.get(e2));
        List<Integer> result = new ArrayList<>();

        for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
            int number = e.getKey();
            int frequency = e.getValue();

            if (frequency == 1) {
                result.add(number);
            } else {
                minHeap.offer(number);
            }
        }

        while (!minHeap.isEmpty() && k > 0) {
            int n = minHeap.poll();
            int f = freq.get(n);
            f--;
            if (f == 1) {
                result.add(n);
            } else {
                freq.put(n, f);
                minHeap.offer(n);
            }
            k--;
        }
        return result.size() - k;

    }

    public static void main(String[] args) {
        int result = MaximumDistinctElements.findMaximumDistinctElements(new int[]{7, 3, 5, 8, 5, 3, 3}, 2);
        System.out.println("Maximum distinct numbers after removing K numbers: " + result);

//        result = MaximumDistinctElements.findMaximumDistinctElements(new int[] { 3, 5, 12, 11, 12 }, 3);
//        System.out.println("Maximum distinct numbers after removing K numbers: " + result);
//
//        result = MaximumDistinctElements.findMaximumDistinctElements(new int[] { 1, 2, 3, 3, 3, 3, 4, 4, 5, 5, 5 }, 2);
//        System.out.println("Maximum distinct numbers after removing K numbers: " + result);
    }
}