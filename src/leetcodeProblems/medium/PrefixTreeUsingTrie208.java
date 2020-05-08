package leetcodeProblems.medium;

public class PrefixTreeUsingTrie208 {
    public static void main(String[] args) {
        PrefixTreeUsingTrie208 ob = new PrefixTreeUsingTrie208();
        Trie trie = new Trie();

        trie.insert("apple");
        System.out.println(trie.search("apple"));   // returns true
        System.out.println(trie.search("app"));     // returns false
        System.out.println(trie.startsWith("app")); // returns true
        trie.insert("app");
        System.out.println(trie.search("app"));     // returns true
    }
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
        tmpRoot.countOfCompleteWord++;
    }

    public boolean search(String word) {
        TrieNode tmpRoot = root;
        for (int i = 0; i < word.length(); i++) {
            if (tmpRoot.trieNode[word.charAt(i) - 'a'] == null) {
                return false;
            }
            else if (tmpRoot.trieNode[word.charAt(i) - 'a'].countOfCompleteWord >= 1 && i == word.length() - 1) {
                return true;
            }
            tmpRoot = tmpRoot.trieNode[word.charAt(i) - 'a'];
        }
        return false;
    }

    public boolean startsWith(String prefix) {
        TrieNode tmpRoot = root;
        for (int i = 0; i < prefix.length(); i++) {
            if (tmpRoot.trieNode[prefix.charAt(i) - 'a'] == null) {
                return false;
            }
            tmpRoot = tmpRoot.trieNode[prefix.charAt(i) - 'a'];
        }
        return true;
    }
}

class TrieNode {
    char c;
    TrieNode[] trieNode;
    int countOfCompleteWord;

    public TrieNode(char c) {
        this.c = c;
        countOfCompleteWord = 0;
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
}

