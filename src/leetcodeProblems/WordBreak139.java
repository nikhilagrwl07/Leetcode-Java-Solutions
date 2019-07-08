package leetcodeProblems;/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak139 {
    public static void main(String[] args) {
//        String s = "leetcode";
//        List<String> wordDict = Arrays.asList("leet", "code");
//

//        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
//        List<String> wordDict = Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa");

//        String s = "aaaaaaa";
//        List<String> wordDict = Arrays.asList("aaaa", "aaa");

//        String s = "catsandog";
//        List<String> wordDict = Arrays.asList("cats", "dog", "sand", "and", "cat");

        String s = "a";
        List<String> wordDict = Arrays.asList("b");

//        String s = "a";
//        List<String> wordDict = Arrays.asList("a");

        WordBreak139 ob = new WordBreak139();
        boolean result = ob.wordBreak(s, wordDict);

        System.out.println(result);

    }

//     BFS
//    public boolean wordBreak(String s, List<String> wordDict) {
//        Set<String> wordDictSet = new HashSet<>(wordDict);
//        Queue<Integer> queue = new LinkedList<>();
//        boolean[] visited = new boolean[s.length()];
//        queue.add(0);
//        while (!queue.isEmpty()) {
//            int start = queue.poll();
//            if (!visited[start]) {
//                for (int end = start + 1; end <= s.length(); end++) {
//                    if (wordDictSet.contains(s.substring(start, end))) {
//                        queue.add(end);
//                        if (end == s.length()) {
//                            return true;
//                        }
//                    }
//                }
//                visited[start] = true;
//            }
//        }
//        return false;
//    }

    //  DFS
    public boolean wordBreak(String input, List<String> wordDict) {

        Set<String> dictionary = new HashSet<>(wordDict);

        Set<Integer> endIndexSet = new HashSet<>();
        return dfs(input, 0, dictionary, endIndexSet);
    }


    public boolean dfs(String input, int startIndex, Set<String> wordDict, Set<Integer> startIndexFailureSet) {

        if (startIndex == input.length()) {
            return true;
        }

        if (startIndexFailureSet.contains(startIndex)) {
            return false;
        }

        boolean result;
        for (int end = startIndex + 1; end <= input.length(); end++) {
            if (wordDict.contains(input.substring(startIndex, end))) {
                result = dfs(input, end, wordDict, startIndexFailureSet);
                if (result)
                    return true;
                else {
                    startIndexFailureSet.add(end);
                }
            }
        }
        return false;
    }
}
