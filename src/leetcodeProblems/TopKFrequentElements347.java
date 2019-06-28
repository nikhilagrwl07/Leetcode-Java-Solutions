/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package leetcodeProblems;

import java.util.*;

public class TopKFrequentElements347 {
    public static void main(String[] args) {
//        int[] a = {1, 2, 2, 3, 3, 3};
//        int k = 2;

        int[] a = {3,0,1,0};
        int k = 1;

        TopKFrequentElements347 ob = new TopKFrequentElements347();
        List<Integer> topKFrequent = ob.topKFrequent(a, k);
        System.out.println(topKFrequent);
    }

    //Using Libs - using Max Heap
    //Time Complexity - O(nlogk)
    //Space Complexity - O(n) for map + O(n) for max heap
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();

        if (k > nums.length) {
            return result;
        }

        Map<Integer, Integer> integerToFrequency = new HashMap<>();

        for (int n : nums) {
            integerToFrequency.put(n, integerToFrequency.getOrDefault(n, 0) + 1);
        }

        Comparator<Integer> cmp = (e1, e2) ->
                integerToFrequency.get(e1) - integerToFrequency.get(e2);

        Queue<Integer> minHeap = new PriorityQueue<>(cmp);  // Size would be k

        for (Map.Entry<Integer, Integer> e : integerToFrequency.entrySet()) {

            if (minHeap.size() < k) {
                minHeap.add(e.getKey());
            } else {
                minHeap.add(e.getKey());
                minHeap.poll();
            }
        }

        while (!minHeap.isEmpty()) {
            result.add(minHeap.poll());
        }
        return result;
    }


    //Using Libs - using Max Heap
    //Time Complexity - O(nlogn)
    //Space Complexity - O(n) for map + O(n) for max heap
//    public List<Integer> topKFrequent(int[] nums, int k) {
//
//        List<Integer> result = new ArrayList<>();
//
//        if (k > nums.length) {
//            return result;
//        }
//
//        Comparator<Node> cmp = (o1, o2) -> o2.freq - o1.freq;
//
//        Queue<Node> pq = new PriorityQueue<>(cmp);
//        Map<Integer, Node> m = new HashMap<>();
//
//        for (int i = 0; i < nums.length; i++) {
//
//            if (m.containsKey(nums[i])) {
//                Node node = m.get(nums[i]);
//                pq.remove(node);
//
//                node.setFreq(node.getFreq() + 1);
//                pq.add(node);
//            } else {
//                Node node = new Node(nums[i], 1);
//                m.put(nums[i], node);
//                pq.add(node);
//            }
//        }
//
//        while (k > 0) {
//            result.add(pq.remove().value);
//            k--;
//        }
//
//        return result;
//    }

//    static class Node {
//        int value;
//        int freq;
//
//        public Node(int value, int freq) {
//            this.value = value;
//            this.freq = freq;
//        }
//
//        public int getValue() {
//            return value;
//        }
//
//        public void setValue(int value) {
//            this.value = value;
//        }
//
//        public int getFreq() {
//            return freq;
//        }
//
//        public void setFreq(int freq) {
//            this.freq = freq;
//        }
//    }
}
