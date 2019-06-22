/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


import java.util.*;

public class WordBreak139 {
    public static void main(String[] args) {
//        String s = "leetcode";
//        List<String> wordDict = Arrays.asList("leet", "code");


        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        List<String> wordDict = Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa");

//        String s = "aaaaaaa";
//        List<String> wordDict = Arrays.asList("aaaa", "aaa");

//        String s = "catsandog";
//        List<String> wordDict = Arrays.asList("cats", "dog", "sand", "and", "cat");

//        String s = "a";
//        List<String> wordDict = Arrays.asList("b");

        WordBreak139 ob = new WordBreak139();
        boolean result = ob.wordBreak(s, wordDict);

        System.out.println(result);

    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet(wordDict);
        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[s.length()];
        queue.add(0);
        while (!queue.isEmpty()) {
            int start = queue.remove();
            if (visited[start] == 0) {
                for (int end = start + 1; end <= s.length(); end++) {
                    if (wordDictSet.contains(s.substring(start, end))) {
                        queue.add(end);
                        if (end == s.length()) {
                            return true;
                        }
                    }
                }
                visited[start] = 1;
            }
        }
        return false;
    }

//    public boolean wordBreak(String s, List<String> wordDict) {
//        if (wordDict.isEmpty())
//            return false;
//
//        Set<String> set = new HashSet<>(wordDict);
//        boolean[][] bm = preprocessInput(s, set);
//
//        return contains(0, s.length() - 1, bm);
//    }

//    private boolean[][] preprocessInput(String s, Set<String> wordDict) {
//
//        boolean[][] mat = new boolean[s.length()][s.length()];
//
//        for (int start = 0; start <= s.length() - 1; start++) {
//
//            for (int end = start; end <= s.length() - 1; end++) {
//                if (wordDict.contains(s.substring(start, end + 1))) {
//                    mat[start][end] = true;
//                }
//            }
//        }
//
//        return mat;
//    }

//    private boolean contains(int start, int end, boolean[][] bm) {
//
//        if (start > end || start >= bm.length)
//            return false;
//
//        if (bm[start][end])
//            return true;
//
//        boolean isComp = false;
//        int mid = start;
//        while (mid <= end) {
//
//            if (bm[start][mid] && mid + 1 <= end) {
//                boolean result = contains(mid + 1, end, bm);
//                isComp = isComp || result;
//            }
//            mid++;
//        }
//
//        return isComp;
//    }
}
