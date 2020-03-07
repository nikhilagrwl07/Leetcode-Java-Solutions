package practice;

public class FindWordInDictionaryUsingTrie {
    public static void main(String[] args) {
        String dictionary[] = {"find", "a", "geeks", "all", "for", "on", "geeks", "answers", "inter"};
        String sentence[] = {"find", "all", "answers", "on", "geeks", "for", "geeks", "geek"};

        FindWordInDictionaryUsingTrie ob = new FindWordInDictionaryUsingTrie();
        boolean result = ob.searchGivenWordInDictionary(dictionary, sentence);
        System.out.println(result);
    }

    // Time Complexity - O(number of words in dict * average length of each word)
    public boolean searchGivenWordInDictionary(String[] dict, String[] sentence) {

        Trie trie = new Trie();
        trie.buildTrie(dict);
        return trie.searchSentence(sentence);
    }
}


class Trie {
    TrieNode root;

    public Trie() {
    }

    public void insert(String gene) {
        TrieNode tmpRoot = root;

        char[] input = gene.toCharArray();
        for (int i = 0; i < input.length; i++) {
            if (tmpRoot.getChildren()[input[i] - 'a'] == null) {
                tmpRoot.getChildren()[input[i] - 'a'] = new TrieNode(input[i]);

                tmpRoot = tmpRoot.getChildren()[input[i] - 'a'];

            } else {
                tmpRoot = tmpRoot.getChildren()[input[i] - 'a'];
            }

            if (i == input.length - 1) {
                tmpRoot.addCompleteWordFreq();
            }
        }
    }

    public boolean searchSentence(String[] words){
        for(String word : words){
            if(!search(word)){
                return false;
            }
        }
        return true;
    }

    public boolean search(String word) {
        char[] input = word.toCharArray();
        TrieNode tmpRoot = root;

        for (int i = 0; i < input.length; i++) {
            if (tmpRoot.getChildren()[input[i] - 'a'] == null) {
                return false;
            }
            tmpRoot = tmpRoot.getChildren()[input[i] - 'a'];
            if (tmpRoot.isCompleteWord() && i == input.length - 1) {
                tmpRoot.subtractCompleteWordFreq();
                return true;
            }
        }
        return false;
    }

    void buildTrie(String[] genes) {

        root = new TrieNode('\0');

        for (String i : genes) {
            insert(i);
        }
    }
}



class TrieNode {
    char c;
    TrieNode[] children;
    int countOfCompleteWord;

    public TrieNode(char c) {
        this.c = c;
        children = new TrieNode[26];
    }

    public TrieNode(char c, TrieNode[] children) {
        this.c = c;
        this.children = children;
    }

    public char getC() {
        return c;
    }

    public void setC(char c) {
        this.c = c;
    }

    public TrieNode[] getChildren() {
        return children;
    }

    public void setChildren(TrieNode[] children) {
        this.children = children;
    }

    public void addCompleteWordFreq(){
        countOfCompleteWord++;
    }

    public void subtractCompleteWordFreq(){
        countOfCompleteWord--;
    }

    public boolean isCompleteWord() {
        return countOfCompleteWord != 0;
    }
}