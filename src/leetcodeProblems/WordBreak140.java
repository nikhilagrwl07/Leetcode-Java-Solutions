package leetcodeProblems;/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


import java.util.*;

public class WordBreak140 {
    public static void main(String[] args) {

//        String s = "leetcode";
//        List<String> wordDict = Arrays.asList("leet", "code");

//        String s = "catsanddog";
//        List<String> wordDict = Arrays.asList("cat", "cats", "and", "sand", "dog");

        String s = "aggegbnngohbggalojckbdfjakgnnjadhganfdkefeddjdnabmflabckflfljafdlmmbhijojiaaifedaihnoinedhhnolcjdam";
        List<String> wordDict = Arrays.asList("o", "b", "gbdfgiokkfnhl", "glibjohcmd", "bblcnhelanckn", "mflabckflflja", "mgda", "oheafhajjo", "cc", "cffalholojikojm", "haljiamccabh", "gjkdlonmhdacd", "ee", "bc", "mjj", "fdlmmbhij", "nn", "jiaaifedaihn", "nhligg", "hooaglldlei", "hajhebh", "ebijeeh", "me", "eibm", "ekkobhajgkem", "ohaofonhjakc", "n", "kjjogm", "mhn", "odcamjmodie", "edmagbkejiocacl", "kcbfnjialef", "lhifcohoe", "akgnn", "fbgakjhjb", "belggjekmn", "oinedhhnolc", "ddekcnag", "oneoakldakalb", "bodnokemafkhkhf", "dkefeddjdnab", "gflcngff", "fgnfmbcogmojgm", "ad", "jadhganf", "lojckbdfj", "gadkaoe", "jdam", "ljjndlnednnombl", "aggegbnngohbgga");
//        String s = "aaaaaaa";
//        List<String> wordDict = Arrays.asList("aaaa", "aa", "a");

//        String s = "catsandog";
//        List<String> wordDict = Arrays.asList("cats", "dog", "sand", "and", "cat");
//
//        String s = "pineapplepenapple";
//        List<String> wordDict = Arrays.asList("apple", "pen", "applepen", "pine", "pineapple");

//        String s = "aaaaaaa";
//        List<String> wordDict = Arrays.asList("aaaa", "aaa");

//        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
//        List<String> wordDict = Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa");


        WordBreak140 ob = new WordBreak140();
        List<String> result = ob.wordBreak(s, wordDict);

        System.out.println(result);

    }

    public List<String> wordBreak(String input, List<String> wordDict) {

        Set<String> dictionary = new HashSet<>(wordDict);

        Set<Integer> endIndexSet = new HashSet<>();
        Map<Integer, String> selectedWords = new HashMap<>();
        List<String> finalWords = new LinkedList<>();
        dfs(input, 0, dictionary, endIndexSet, selectedWords, finalWords);
        return finalWords;
    }

    public boolean dfs(String input, int startIndex, Set<String> wordDict, Set<Integer> startIndexFailureSet,
                       Map<Integer, String> selectedWords, List<String> finalResult) {

        if (startIndex == input.length()) {

            Comparator<Map.Entry<Integer, String>> comp = (o1, o2) -> o1.getKey() - o2.getKey();

            List<String> tmp = new LinkedList<>();
            selectedWords.entrySet().stream().sorted(comp).forEach(e -> tmp.add(e.getValue()));

            finalResult.add(String.join(" ", tmp));
            return true;
        }

        if (startIndexFailureSet.contains(startIndex)) {
            return false;
        }

        boolean resultGlobal = false;
        for (int end = startIndex + 1; end <= input.length(); end++) {

            String substring = input.substring(startIndex, end);
            if (wordDict.contains(substring)) {
                selectedWords.put(startIndex, substring);
                boolean result = dfs(input, end, wordDict, startIndexFailureSet, selectedWords, finalResult);
                if (result) {
                    resultGlobal = true;
                } else {
                    startIndexFailureSet.add(end);
                }

                selectedWords.remove(startIndex);
            }
        }
        return resultGlobal;
    }


    // BFS
//    public List<String> wordBreak(String s, List<String> wordDict) {
//        Set<String> wordDictSet = new HashSet<>(wordDict);
//
//        Queue<Node> queue = new LinkedList<>();
//
//        int start = 0;
//
//        List<String> result = new LinkedList<>();
//        for (int end = start + 1; end <= s.length(); end++) {
//
//            String substring = s.substring(start, end);
//            if (wordDictSet.contains(substring)) {
//
//                Node node = new Node(end-1);
//                node.addWords(substring);
//                queue.add(node);
//                if (end == s.length()) {
//                    result.add(String.join(", ", node.words));
//                }
//            }
//        }
//
//        while (!queue.isEmpty()) {
//            Node topNode = queue.poll();
//            start = topNode.index+1;
//
//            if (start <= s.length()-1) {
//                for (int end = start + 1; end <= s.length(); end++) {
//
//                    String substring = s.substring(start, end);
//                    if (wordDictSet.contains(substring)) {
//                        Node node = new Node(end-1);
//                        node.addWordsAll(topNode.words);
//                        node.addWords(substring);
//                        queue.add(node);
//
//                        if (end == s.length()) {
//                            result.add(String.join(" ", node.words));
//
//                        }
//                    }
//                }
//            }
//        }
//        return result;
//    }

//    static class Node {
//        int index;
//        List<String> words;
//
//        public Node(int index) {
//            this.index = index;
//            words = new LinkedList<>();
//        }
//
//        public void addWords(String w) {
//            words.add(w);
//        }
//
//        public void addWordsAll(List<String> w) {
//            words.addAll(w);
//        }
//    }
}
