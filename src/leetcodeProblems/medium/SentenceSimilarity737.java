package leetcodeProblems.medium;

import java.util.*;

public class SentenceSimilarity737 {
    public static void main(String[] args) {

        SentenceSimilarity737 ob = new SentenceSimilarity737();
        String[] words1 = {"great", "acting", "skills"};
        String[] words2 = {"great", "acting", "skills"};
//        String[] words2 = {"fine", "drama", "talent"};

        List<List<String>> pairs = new ArrayList<>();
        pairs.add(Arrays.asList("great", "good"));
        pairs.add(Arrays.asList("fine", "good"));
        pairs.add(Arrays.asList("acting", "drama"));
        pairs.add(Arrays.asList("skills", "talent"));

        System.out.println(ob.areSentencesSimilarTwo(words1, words2, pairs));
    }

    public boolean areSentencesSimilarTwo(
            String[] words1, String[] words2, String[][] pairs) {
        if (words1.length != words2.length) return false;
        Map<String, List<String>> graph = new HashMap();
        for (String[] pair : pairs) {
            for (String p : pair)
                if (!graph.containsKey(p)) {
                    graph.put(p, new ArrayList());
                }
            graph.get(pair[0]).add(pair[1]);
            graph.get(pair[1]).add(pair[0]);
        }

        for (int i = 0; i < words1.length; ++i) {
            String w1 = words1[i], w2 = words2[i];
            Stack<String> stack = new Stack();
            Set<String> seen = new HashSet();
            stack.push(w1);
            seen.add(w1);
            search:
            {
                while (!stack.isEmpty()) {
                    String word = stack.pop();
                    if (word.equals(w2)) break search;
                    if (graph.containsKey(word)) {
                        for (String nei : graph.get(word)) {
                            if (!seen.contains(nei)) {
                                stack.push(nei);
                                seen.add(nei);
                            }
                        }
                    }
                }
                return false;
            }
        }
        return true;
    }

    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, List<List<String>> pairs) {

        if (words1 == null && words2 == null)
            return true;

        if ((words1 == null || words2 == null) || words1.length != words2.length) {
            return false;
        }

        Map<String, List<String>> graph = new HashMap<>();

        for (List<String> pair : pairs) {
            graph.computeIfAbsent(pair.get(0), s -> new ArrayList<>()).add(pair.get(1));
            graph.computeIfAbsent(pair.get(1), s -> new ArrayList<>()).add(pair.get(0));
        }

        Map<String, Boolean> isVisited = new HashMap<>();

        for (int i = 0; i < words1.length; i++) {
            String w1 = words1[i];
            String w2 = words2[i];

            if (!w1.equals(w2) && !dfs(graph, w1, w2, isVisited)) {
                return false;
            }
            isVisited.clear();
        }

        return true;
    }

    private boolean dfs(Map<String, List<String>> graph, String w1, String w2, Map<String, Boolean> isVisited) {

        if (isVisited.get(w1) != null) {
            return false;
        }

        List<String> neighbours = graph.get(w1);
        isVisited.put(w1, true);

        if (neighbours == null || neighbours.isEmpty()) {
            return false;
        }

        for (String nei : neighbours) {

            // unvisited
            if (nei.equals(w2)) {
                return true;
            }

            if (dfs(graph, nei, w2, isVisited))
                return true;
        }
        return false;
    }
}
