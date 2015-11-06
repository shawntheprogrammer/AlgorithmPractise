import java.util.*;

public class WordLadderII {
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        List<String> list = new ArrayList<String>();
        list.add(beginWord);
        
        char[] array = beginWord.toCharArray();
        for (int i = 0; i < array.length; i++) {
            char ori = array[i];
            for (char c = 'a'; c <= 'z'; c++) {
                array[i] = c;
                String newWord = String.valueOf(array);
                if (newWord.equals(endWord)) {
                    List<List<String>> result = new ArrayList<>();
                    List<String> res = new ArrayList<>();
                    res.add(beginWord);
                    res.add(endWord);
                    result.add(res);
                    return result;
                }
            }
            array[i] = ori;
        }
        
        //a backwards edge map for retrieving the possible sequence
        HashMap<String, Set<String>> map = new HashMap<>();
        //bfs
        boolean found = false;
        int length = 1;
        
        if (wordList.contains(beginWord)) 
            wordList.remove(beginWord);
            
        if (wordList.contains(endWord))
            wordList.remove(endWord);
            
        while (list.size() != 0 && !found) {
            List<String> next = new ArrayList<>();
            
            for (String word : list) {
                //get the next level list and check if it's endWord
                array = word.toCharArray();
                
                for (int i = 0; i < array.length; i++) {
                    char ori = array[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == ori) {
                            continue;
                        }
                        array[i] = c;
                        String newWord = String.valueOf(array);
                        if (newWord.equals(endWord)) {
                            found = true;
                        }
                        //intermediate word or endword -> build up the edge
                        if (wordList.contains(newWord) || newWord.equals(endWord)) {
                            next.add(newWord);
                            if (!map.containsKey(newWord)) {
                                map.put(newWord, new HashSet<String>());
                            }
                            map.get(newWord).add(word);
                        }
                    }
                    array[i] = ori;
                }
            }
            
            for (String ss : next) {
                if (wordList.contains(ss)) {
                    wordList.remove(ss);
                }
            }
            
            list = next;
            length++;
        }
        
        //now from endword to beginword
        List<List<String>> result = new ArrayList<>();
        if (list.size() == 0) {
            return result;
        }
        List<String> cache = new LinkedList<>();
        cache.add(endWord);
        backtracking(beginWord, cache, map, result, length - 1);
        return result;
    }
    
    public void backtracking(String target, List<String> list, HashMap<String, Set<String>> map, List<List<String>> result, int length) {
        if (length == 0 && list.get(0).equals(target)) {
            result.add(new LinkedList<String>(list));
            return;
        }
        
        String word = list.get(0);
        Set<String> next = map.get(word);
        for (String nextWord : next) {
            list.add(0, nextWord);
            backtracking(target, list, map, result, length - 1);
            list.remove(0);
        }
    }
}
