package leetcodeProblems;

import java.util.*;

public class TopKFrequentElements347 {
    public static void main(String[] args) {
//        int[] a = {1, 2, 2, 3, 3, 3, 1, 1};
//        int k = 2;

//        int[] a = {1, 1, 1, 2, 2, 3};
//        int k = 2;

        int[] a = {3, 0, 1, 0};
        int k = 1;

        TopKFrequentElements347 ob = new TopKFrequentElements347();
        int[] topKFrequent = ob.topKFrequent(a, k);
        System.out.println(Arrays.toString(topKFrequent));
    }

    //Using Libs - using Max Heap
    //Time Complexity - O(nlogk)
    //Space Complexity - O(n) for map + O(k) for max heap
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> freq = new HashMap<>();
        Queue<Integer> minHeap = new PriorityQueue<>(k, (o1, o2) -> freq.getOrDefault(o1, 0) - freq.getOrDefault(o2, 0));  // Size would be k


        for (int n : nums) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
            minHeap.remove(n);
            minHeap.add(n);

            if(minHeap.size() > k){
                minHeap.poll();
            }
        }

        int[] result = new int[k];
        int i = 0;
        while (!minHeap.isEmpty()) {
            result[i] = minHeap.poll();
            i++;
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
