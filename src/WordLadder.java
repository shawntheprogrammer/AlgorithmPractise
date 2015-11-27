import java.util.*;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        if (beginWord == null || endWord == null || beginWord.length() != endWord.length())
            return 0;
        
        //check if beginWord is one distance away from endWord
        char[] letters = beginWord.toCharArray();
        for (int i = 0; i < letters.length; i++) {
            char ori= letters[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == ori)
                    continue;
                letters[i] = c;
                if (endWord.equals(String.valueOf(letters)))
                    return 2;
                letters[i] = ori;
            }
        }
        
        //check wordList valid input
        if (wordList == null || wordList.size() == 0) {
            return 0;
        }
        
        int len = 1;
        HashSet<String> list = new HashSet<String>();
        list.add(beginWord);
        
        //bfs  avoid cycle
        while (list.size() != 0 && !list.contains(endWord)) {
            HashSet<String> next = new HashSet<>();
            for (String word : list) {
                if (wordList.contains(word))
                    wordList.remove(word);
            }
            
            for (String word : list) 
                getWords(wordList, word, next);
            
            list = next;
            len++;
        }
        
        if (list.contains(endWord))
            return len;
        return 0;
    }
    
    public void getWords(Set<String> wordList, String word, HashSet<String> next) {
        if (word == null || word.length() == 0) 
            return;
            
        char[] letters = word.toCharArray();
        for (int i = 0; i < letters.length; i++) {
            char ori= letters[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == ori)
                    continue;
                letters[i] = c;
                if (wordList.contains(String.valueOf(letters)))
                    next.add(String.valueOf(letters));
                letters[i] = ori;
            }
        }
    }
}
