package leetcodeProblems;

import java.util.*;

public class TopKFrequentWords692 {
    public static void main(String[] args) {
        TopKFrequentWords692 ob = new TopKFrequentWords692();

        String[] s1 = {"i", "love", "leetcode", "i", "love", "coding"};
        int k1 = 2;

        String[] s2 = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        int k2 = 4;
        System.out.println(ob.topKFrequent(s1, k1));
        System.out.println(ob.topKFrequent(s2, k2));
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

        for (String word : words) {
            freq.put(word, freq.getOrDefault(word, 0) + 1);

            if (freq.get(word) > 1) pq.remove(word);

            pq.offer(word);
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
