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
            if (tmpRoot.child[word.charAt(i) - 'a'] == null) {
                tmpRoot.child[word.charAt(i) - 'a'] = new TrieNode(word.charAt(i));
            }
            tmpRoot = tmpRoot.child[word.charAt(i) - 'a'];
        }
        tmpRoot.countOfCompleteWord++;
    }

    public boolean search(String word) {
        TrieNode tmpRoot = root;
        for (int i = 0; i < word.length(); i++) {
            if (tmpRoot.child[word.charAt(i) - 'a'] == null) {
                return false;
            }
            else if (tmpRoot.child[word.charAt(i) - 'a'].countOfCompleteWord >= 1 && i == word.length() - 1) {
                return true;
            }
            tmpRoot = tmpRoot.child[word.charAt(i) - 'a'];
        }
        return false;
    }

    public boolean startsWith(String prefix) {
        TrieNode tmpRoot = root;
        for (int i = 0; i < prefix.length(); i++) {
            if (tmpRoot.child[prefix.charAt(i) - 'a'] == null) {
                return false;
            }
            tmpRoot = tmpRoot.child[prefix.charAt(i) - 'a'];
        }
        return true;
    }
}

class TrieNode {
    char c;
    TrieNode[] child;
    int countOfCompleteWord;

    public TrieNode(char c) {
        this.c = c;
        countOfCompleteWord = 0;
        this.child = new TrieNode[26];
    }

    public char getC() {
        return c;
    }

    public void setC(char c) {
        this.c = c;
    }

    public TrieNode[] getChild() {
        return child;
    }

    public void setChild(TrieNode[] child) {
        this.child = child;
    }
}

