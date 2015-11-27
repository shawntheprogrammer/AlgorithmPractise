package Google;
import java.util.*;

public class WordBreakII {
	//cache result
    public List<String> wordBreak2(String s, Set<String> wordDict) {
        if (s == null || wordDict == null || wordDict.size() == 0)
            return new ArrayList<>();
            
        HashMap<Integer, List<String>> cache = new HashMap<>();
        getWords2(s, 0, wordDict, cache);
        
        if (cache.containsKey(0))
            return cache.get(0);
        else
            return new ArrayList<>();
    }
    
    public boolean getWords2(String s, int index, Set<String> wordDict, HashMap<Integer, List<String>> cache) {
        if (cache.containsKey(index)) 
            return cache.get(index).size() != 0;
        
        List<String> res = new ArrayList<>();
        
        if (index == s.length()) {
            res.add("");
            cache.put(index, res);
            return true;
        }
        
        for (int i = index + 1; i <= s.length(); i++) {
            String sub = s.substring(index, i);
            if (wordDict.contains(sub) && getWords2(s, i, wordDict, cache)) {
                List<String> right = cache.get(i);
                if (i == s.length()) {
                    res.add(sub);
                    continue;
                }
                for (String str : right)
                    res.add(sub + " " + str);
            }
        }
        
        cache.put(index, res);
        return res.size() != 0;
    }
    
	
	
	
	//Brute Force
    public List<String> wordBreak(String s, Set<String> wordDict) {
        if (s == null || wordDict == null || wordDict.size() == 0)
            return new ArrayList<>();
            
        List<String> result = new ArrayList<>();
        
        getWords(s, "", 0, result, wordDict);
        
        return result;
    }
    
    public void getWords(String s, String str, int index, List<String> result, Set<String> wordDict) {
        if (index == s.length()) {
            result.add(str);
            return;
        }
        
        for (int i = index + 1; i <= s.length(); i++) {
            String sub = s.substring(index, i);
            if (wordDict.contains(sub)) {
                String next = (str.length() == 0) ? sub : str + " " + sub;
                getWords(s, next, i, result, wordDict);
            }
        }
    }
}
