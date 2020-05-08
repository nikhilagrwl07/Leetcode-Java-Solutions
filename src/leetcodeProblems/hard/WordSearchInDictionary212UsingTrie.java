package leetcodeProblems.hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearchInDictionary212UsingTrie {
    public static void main(String[] args) {
        WordSearchInDictionary212UsingTrie ob = new WordSearchInDictionary212UsingTrie();
//        char[][] board = {
//                {'o', 'a', 'a', 'n'},
//                {'e', 't', 'a', 'e'},
//                {'i', 'h', 'k', 'r'},
//                {'i', 'f', 'l', 'v'}
//        };
//
//        String[] words = new String[4];
//        words[0] = "oath";
//        words[1] = "pea";
//        words[2] = "eat";
//        words[3] = "rain";

//        char[][] board = {{'a','b'},{'c','d'}};
//        String[] words = {"ab","cb","ad","bd","ac","ca","da","bc","db","adcb","dabc","abb","acb"};

//        char[][] board = {{'a', 'a'}};
//        String[] words = {"aaa"};
//
        char[][] board = {
                {'b', 'a', 'a', 'b', 'a', 'b'},
                {'a', 'b', 'a', 'a', 'a', 'a'},
                {'a', 'b', 'a', 'a', 'a', 'b'},
                {'a', 'b', 'a', 'b', 'b', 'a'},
                {'a', 'a', 'b', 'b', 'a', 'b'},
                {'a', 'a', 'b', 'b', 'b', 'a'},
                {'a', 'a', 'b', 'a', 'a', 'b'}
        };

        String[] words = {"bbaabaabaaaaabaababaaaaababb", "aabbaaabaaabaabaaaaaabbaaaba",
                "babaababbbbbbbaabaababaabaaa", "bbbaaabaabbaaababababbbbbaaa",
                "babbabbbbaabbabaaaaaabbbaaab", "bbbababbbbbbbababbabbbbbabaa",
                "babababbababaabbbbabbbbabbba", "abbbbbbaabaaabaaababaabbabba",
                "aabaabababbbbbbababbbababbaa", "aabbbbabbaababaaaabababbaaba",
                "ababaababaaabbabbaabbaabbaba", "abaabbbaaaaababbbaaaaabbbaab",
                "aabbabaabaabbabababaaabbbaab", "baaabaaaabbabaaabaabababaaaa",
                "aaabbabaaaababbabbaabbaabbaa", "aaabaaaaabaabbabaabbbbaabaaa",
                "abbaabbaaaabbaababababbaabbb", "baabaababbbbaaaabaaabbababbb",
                "aabaababbaababbaaabaabababab", "abbaaabbaabaabaabbbbaabbbbbb",
                "aaababaabbaaabbbaaabbabbabab", "bbababbbabbbbabbbbabbbbbabaa",
                "abbbaabbbaaababbbababbababba", "bbbbbbbabbbababbabaabababaab",
                "aaaababaabbbbabaaaaabaaaaabb", "bbaaabbbbabbaaabbaabbabbaaba",
                "aabaabbbbaabaabbabaabababaaa", "abbababbbaababaabbababababbb",
                "aabbbabbaaaababbbbabbababbbb", "babbbaabababbbbbbbbbaabbabaa"};

        List<String> result = ob.findWords(board, words);
        System.out.println(result);
    }

    public List<String> findWords(char[][] board, String[] words) {
        if (board == null || board[0].length == 0 || words == null)
            return new ArrayList<>();

        Trie trie = createTrieFromWords(words);
        Set<String> result = new HashSet<>();
        boolean[][] isVisited = new boolean[board.length][board[0].length];

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (trie.root.trieNode[board[r][c] - 'a'] != null) {
                    dfs(trie.root.trieNode[board[r][c] - 'a'], trie.root, r, c, isVisited, board, result);
                }
            }
        }
        return new ArrayList<>(result);
    }

    private void dfs(TrieNode root, TrieNode parent, int r, int c, boolean[][] isVisited,
                     char[][] board, Set<String> result) {

        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || isVisited[r][c])
            return;

        if (root == null || root.c != board[r][c])
            return;

        isVisited[r][c] = true;

        if (root.word != null) {
            result.add(root.word);
        }

        // leaf node
        if (root.isLeafNode()) {
            parent.trieNode[root.c - 'a'] = null;
        }

        for (TrieNode child : root.getTrieNode()) {
            dfs(child, root, r - 1, c, isVisited, board, result);
            dfs(child, root, r + 1, c, isVisited, board, result);
            dfs(child, root, r, c - 1, isVisited, board, result);
            dfs(child, root, r, c + 1, isVisited, board, result);
        }

        isVisited[r][c] = false;
    }

    private Trie createTrieFromWords(String[] words) {
        Trie trie = new Trie();
        for (String w : words) {
            trie.insert(w);
        }
        return trie;
    }


    class Trie {
        TrieNode root;

        public Trie() {
            root = new TrieNode('\0');
        }

        public void insert(String word) {
            TrieNode tmpRoot = root;

            for (int i = 0; i < word.length(); i++) {
                if (tmpRoot.trieNode[word.charAt(i) - 'a'] == null) {
                    tmpRoot.trieNode[word.charAt(i) - 'a'] = new TrieNode(word.charAt(i));
                }
                tmpRoot = tmpRoot.trieNode[word.charAt(i) - 'a'];
            }
            tmpRoot.word = word;
        }
    }

    class TrieNode {
        char c;
        TrieNode[] trieNode;
        String word = null;

        public TrieNode(char c) {
            this.c = c;
            this.trieNode = new TrieNode[26];
        }

        public char getC() {
            return c;
        }

        public void setC(char c) {
            this.c = c;
        }

        public TrieNode[] getTrieNode() {
            return trieNode;
        }

        public void setTrieNode(TrieNode[] trieNode) {
            this.trieNode = trieNode;
        }

        public String getWord() {
            return word;
        }

        public void setWord(String word) {
            this.word = word;
        }

        public boolean isLeafNode() {
            for (TrieNode tn : trieNode) {
                if (tn != null)
                    return false;
            }
            return true;
        }
    }
}