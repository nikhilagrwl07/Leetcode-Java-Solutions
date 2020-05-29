package practice;

import java.util.*;

public class FrequentWordsInReview {
    public static void main(String[] args) {
        FrequentWordsInReview ob = new FrequentWordsInReview();
        int k1 = 2;
        String[] keywords1 = {"anacell", "cetracular", "betacellular"};
        String[] reviews1 = {
                "Anacell provides the best services in the city",
                "betacellular has awesome services",
                "Best services provided by anacell, everyone should use anacell",
        };


        int k2 = 2;
        String[] keywords2 = {"anacell", "betacellular", "cetracular", "deltacellular", "eurocell"};
        String[] reviews2 = {
                "I love anacell Best services; Best services provided by anacell",
                "betacellular has great services",
                "deltacellular provides much better services than betacellular",
                "cetracular is worse than anacell",
                "Betacellular is better than deltacellular.",
        };

//        System.out.println(ob.getKFrequencyWord(k1, keywords1, reviews1));
        System.out.println(ob.getKFrequencyWord(k2, keywords2, reviews2));
    }

    public List<String> getKFrequencyWord(int k, String[] keywords, String[] reviews) {
        if (keywords == null || keywords.length == 0 || reviews == null || reviews.length == 0)
            return new ArrayList<>();

        List<String> result = new ArrayList<>();
        Map<String, Integer> freq = new HashMap<>();
        Queue<String> minHeap = new PriorityQueue<String>(k, (o1, o2) -> {
            int diff = freq.getOrDefault(o1, 0) - freq.getOrDefault(o2, 0);
            if (diff != 0)
                return diff;

            return o2.compareTo(o1);
        });


        List<String> keywordsAsList = Arrays.asList(keywords);
        Set<String> wordsInSameReview = new HashSet<>();

        for (String review : reviews) {
            String[] split = review.split(" ");
            for (String word : split) {
                word = word.toLowerCase();
                if (!wordsInSameReview.contains(word) && keywordsAsList.contains(word)) {
                    freq.put(word, freq.getOrDefault(word, 0) + 1);

                    wordsInSameReview.add(word);
                    minHeap.remove(word);
                    minHeap.offer(word);

                    if (minHeap.size() > k) {
                        minHeap.poll();
                    }

                }
            }
            wordsInSameReview.clear();
        }

        while (!minHeap.isEmpty()) {
            result.add(minHeap.poll());
        }

        Collections.reverse(result);

        return result;
    }
}
