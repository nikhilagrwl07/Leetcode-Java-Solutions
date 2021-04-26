package practice;

import java.util.*;

class TopKFrequentNumbers {

    public static List<Integer> findTopKFrequentNumbers(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int n : nums) {
            freq.put(n, freq.getOrDefault(freq.get(n), 0) + 1);
        }
        Queue<Integer> minHeap = new PriorityQueue<>((e1, e2) -> freq.get(e1) - freq.get(e2));

        for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
            int number = e.getKey();
            int frequency = e.getValue();

            if (minHeap.size() < k) {
                minHeap.offer(number);
            }
            else if (minHeap.size() == k && freq.get(minHeap.peek()) < frequency){
                minHeap.poll();
                minHeap.offer(number);
            }
        }

        List<Integer> result = new ArrayList<>();

        while (!minHeap.isEmpty()) {
            result.add(minHeap.poll());
        }

        return result;
    }

    public static void main(String[] args) {
        List<Integer> result = TopKFrequentNumbers.findTopKFrequentNumbers(new int[]{1, 3, 5, 12, 11, 12, 11}, 2);
        System.out.println("Here are the K frequent numbers: " + result);

        result = TopKFrequentNumbers.findTopKFrequentNumbers(new int[]{5, 12, 11, 3, 11}, 2);
        System.out.println("Here are the K frequent numbers: " + result);
    }
}
