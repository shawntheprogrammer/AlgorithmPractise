
public class AddAndSearchWord {
    public class Trie{
        TrieNode root;
        public Trie() {
            root = new TrieNode(' ');
        }
    }
    
    public class TrieNode{
        char val;
        TrieNode[] next;
        boolean isEndWord;
        public TrieNode(char c) {
            val = c;
            next = new TrieNode[26];
        }
    }
    
    Trie myTrie = new Trie();
    // Adds a word into the data structure.
    public void addWord(String word) {
        // Write your code here
        TrieNode cur = myTrie.root;
        
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if (cur.next[index] == null) {
                cur.next[index] = new TrieNode(c);
            }
            cur = cur.next[index];
        }
        cur.isEndWord = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        // Write your code here
        if (word == null || word.length() == 0) {
            return false;
        }
        
        return search(word, 0, myTrie.root);
    }
    
    public boolean search(String word, int index, TrieNode node) {
        if (node == null) {
            return false;
        }
        if (index == word.length()) {
            return node.isEndWord;
        }
        
        if (word.charAt(index) == '.') {
            for (int i = 0; i < 26; i++) {
                if (search(word, index + 1, node.next[i])) {
                    return true;
                }
            }
            return false;
        } else {
            return search(word, index + 1, node.next[word.charAt(index) - 'a']);
        }
    }
}
