package leetcodeProblems.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SearchSuggestion1268 {
    public static void main(String[] args) {
        SearchSuggestion1268 ob = new SearchSuggestion1268();
        String[] products = {"mobile", "mouse", "moneypot", "monitor", "mousepad"};
        String searchWord = "mouse";

//        String[] products = {"havana"};
//        String searchWord = "havana";

//        String[] products = {"bags","baggage","banner","box","cloths"};
//        String searchWord = "bags";

//        String[] products = {"havana"};
//        String searchWord = "tatiana";

        List<List<String>> suggestedProducts = ob.suggestedProducts(products, searchWord);
        System.out.println(suggestedProducts);
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie trie = new Trie();

        for (String product : products) {
            trie.insert(product);
        }
        List<List<String>> result = new ArrayList<>();

        for (int i = 0; i < searchWord.length(); i++) {
            List<String> search = trie.search(searchWord.substring(0, i + 1));
            result.add(search);
        }
        return result;
    }

    class Trie {
        TrieNode head = new TrieNode('\n');
        int maxLength = 0;

        public void insert(String word) {
            TrieNode parent = head;
            for (int i = 0; i < word.length(); i++) {
                TrieNode child = parent.getChild().get(word.charAt(i));
                if (child == null) {
                    TrieNode cTmp = new TrieNode(word.charAt(i));
                    parent.getChild().put(word.charAt(i), cTmp);
                }
                parent = parent.getChild().get(word.charAt(i));
            }
            parent.isCompleteWord = true;
            maxLength = Math.max(maxLength, word.length());
        }

        public List<String> search(String input) {
            List<String> result = new ArrayList<>();
            TrieNode trieNode = head;

            char[] ch = new char[maxLength];
            int index = 0;


            for (; index <= input.length() - 1; index++) {
                trieNode = trieNode.getChild().get(input.charAt(index));
                if (trieNode == null)
                    return result;

                ch[index] = input.charAt(index);
            }

            index--;
            searchUtil(trieNode, ch, index, result);
            return result;
        }

        public void searchUtil(TrieNode currentHead, char[] ch, int index, List<String> result) {
            if (result.size() >= 3)
                return;

            ch[index] = currentHead.getC();

            if (currentHead.isCompleteWord) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i <= index; i++) {
                    sb.append(ch[i]);
                }
                result.add(sb.toString());
            }
            for (Map.Entry<Character, TrieNode> e : currentHead.getChild().entrySet()) {
                searchUtil(e.getValue(), ch, index + 1, result);
            }
        }

    }

    class TrieNode {
        char c;
        Map<Character, TrieNode> child = new TreeMap<>();
        boolean isCompleteWord = false;

        public TrieNode(char c) {
            this.c = c;
        }

        public char getC() {
            return c;
        }

        public void setC(char c) {
            this.c = c;
        }

        public boolean isCompleteWord() {
            return isCompleteWord;
        }

        public void setCompleteWord(boolean completeWord) {
            isCompleteWord = completeWord;
        }

        public Map<Character, TrieNode> getChild() {
            return child;
        }

        public void setChild(Map<Character, TrieNode> child) {
            this.child = child;
        }
    }
}
