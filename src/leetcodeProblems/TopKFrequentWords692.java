/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package leetcodeProblems;

import java.util.*;

public class TopKFrequentWords692 {
    public static void main(String[] args) {
        TopKFrequentWords692 ob = new TopKFrequentWords692();

        String[] s = {"i", "love", "leetcode", "i", "love", "coding"};
        int k =2;

//        String[] s = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
//        int k =4;
        List<String> topKFrequent = ob.topKFrequent(s, k);
        System.out.println(topKFrequent);
    }


    public List<String> topKFrequent(String[] words, int k) {

        List<String> result = new ArrayList<>();

        Map<String, Integer> m = new HashMap<>();

        for (String w : words) {
            m.put(w, m.getOrDefault(w, 0) + 1);
        }

        Comparator<String> customComp = (s1, s2) -> {
            int diff =  m.get(s1) - m.get(s2);       // Node

            if (diff != 0) {
                return diff;
            }

            return s2.compareTo(s1);
//            if (string1 > string2) it returns a positive value.
//            if both the strings are equal lexicographically
//            i.e.(string1 == string2) it returns 0.
//            if (string1 < string2) it returns a negative value
        };

        Queue<String> minHeap = new PriorityQueue<>(customComp);


        for (String w : m.keySet()) {
            minHeap.add(w);
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }

        while (!minHeap.isEmpty() && k>0) {
            result.add(minHeap.poll());
            k--;
        }

        Collections.reverse(result);
        return result;
    }


    //Using MaxHeap
    // Time Complexity - O(NlogN)
//    public List<String> topKFrequent(String[] words, int k) {
//
//        List<String> result = new ArrayList<>();
//
//        Map<String, Integer> m = new HashMap<>();
//
//        for (String w : words) {
//            m.put(w, m.getOrDefault(w, 0) + 1);
//        }
//
//        Comparator<String> customComp = (s1, s2) -> {
//            int diff =  m.get(s2) - m.get(s1);       // MaxHeap
//
//            if (diff != 0) {
//                return diff;
//            }
//
//            return s1.compareTo(s2);
////            if (string1 > string2) it returns a positive value.
////            if both the strings are equal lexicographically
////            i.e.(string1 == string2) it returns 0.
////            if (string1 < string2) it returns a negative value
//        };
//
//        Queue<String> minHeap = new PriorityQueue<>(customComp);
//
//
//        for (String w : m.keySet()) {
//            minHeap.add(w);
//        }
//
//        while (!minHeap.isEmpty() && k>0) {
//            result.add(minHeap.poll());
//            k--;
//        }
//
//        return result;
//    }
}
