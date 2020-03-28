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

//        String[] s = {"i", "love", "leetcode", "i", "love", "coding"};
//        int k = 2;

        String[] s = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        int k =4;
        List<String> topKFrequent = ob.topKFrequent(s, k);
        System.out.println(topKFrequent);
    }


    // Using MinHeap
//    Time Complexity - N * logK
//    Space Complexity - N
    public List<String> topKFrequent(String[] words, int k) {

        Map<String, Integer> freq = new HashMap<>();

        Queue<String> pq = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int result = freq.getOrDefault(o1, 0) - freq.getOrDefault(o2, 0);
                if (result != 0) {
                    return result;
                } else {
                    return o2.compareTo(o1);
                }
            }
        });

        for (String w : words) {
            freq.put(w, freq.getOrDefault(w, 0) + 1);
        }

        for (Map.Entry<String, Integer> e : freq.entrySet()) {
            pq.offer(e.getKey());

            if (pq.size() > k) {
                pq.poll();
            }
        }

        List<String> result = new ArrayList<>(pq.size());
        while (!pq.isEmpty()) {
            result.add(pq.poll());
        }

        Collections.reverse(result);
        return result;
    }


    //Using MaxHeap
//    Time Complexity - N * logN
//    Space Complexity - N
//    public List<String> topKFrequent(String[] words, int k) {
//
//        Map<String, Integer> freq = new HashMap<>();
//
//        Queue<String> pq = new PriorityQueue<>(new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                int result = freq.getOrDefault(o2, 0) - freq.getOrDefault(o1, 0);
//                if (result != 0) {
//                    return result;
//                } else {
//                    return o1.compareTo(o2);
//                }
//            }
//        });
//
//        for (String w : words) {
//            freq.put(w, freq.getOrDefault(w, 0) + 1);
//        }
//
//        pq.addAll(freq.keySet());
//        List<String> result = new ArrayList<>(k);
//
//        while (!pq.isEmpty() && k > 0) {
//            result.add(pq.poll());
//            k--;
//        }
//        return result;
//    }
}
