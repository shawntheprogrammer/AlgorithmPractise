import java.util.*;
public class SubstringwithConcatenationofAllWords {
	   public static void main(String[] args) {
		   String s = "wordgoodgoodgoodbestword";
		   String[] words = {"word","good","best","good"};
		   findSubstringII(s, words);
	   }
	   public static List<Integer> findSubstringII(String s, String[] words) {
	        if (s == null || words == null)
	            return new ArrayList<Integer>();
	        if (s.length() < words[0].length() * words.length)
	            return new ArrayList<Integer>();
	            
	        List<Integer> result = new ArrayList<>();
	        HashMap<String, Integer> word_frequency = new HashMap<>();
	        
	        for (String word : words) {
	            if (!word_frequency.containsKey(word))
	                word_frequency.put(word, 1);
	            else
	                word_frequency.put(word, word_frequency.get(word) + 1);
	        }
	        
	        int wordLen = words[0].length();
	        String[] strs = new String[s.length()];
	        
	        for (int i = 0; i + wordLen < strs.length; i++) {
	            String word = s.substring(i, i + wordLen);
	            strs[i] = word;
	        }
	        
	        for (int i = 0; i < wordLen; i++) {
	            int start = i;
	            int count = 0;
	            
	            for (int j = i; j < strs.length; j+=wordLen) {
	                String word = strs[j];
	                
	                //reset start to j + 1, count to 0,  and add all the word in the window back to map
	                if (!word_frequency.containsKey(word)) {
	                    while (start < j) {
	                        String sub = strs[start];
	                        word_frequency.put(sub, word_frequency.get(sub) + 1);
	                        start += wordLen;
	                    }
	                    start = j + wordLen;
	                    count = 0;
	                    continue;
	                }
	                
	                
	                word_frequency.put(word, word_frequency.get(word) - 1);
	                
	                if (word_frequency.get(word) == 0)
	                    count++;
	                
	                //rest start to word
	                while (word_frequency.get(word) < 0) {
	                    if (word_frequency.get(strs[start]) == 0)
	                        count--;
	                    word_frequency.put(strs[start], word_frequency.get(strs[start]) + 1);
	                    start += wordLen;
	                }
	                
	                
	                //the window start -> j is good, remove start to a possible start and update count
	                if (count == word_frequency.size()) {
	                    result.add(start);
	                    word_frequency.put(strs[start], word_frequency.get(strs[start]) + 1);
	                    count--;
	                    start += wordLen;
	                }
	            }
	        }
	        
	        Collections.sort(result);
	        
	        return result;
	    }
	
	//DFS
    public List<Integer> findSubstring(String s, String[] words) {
        if (s == null || words == null)
            return new ArrayList<Integer>();
        if (s.length() < words[0].length() * words.length)
            return new ArrayList<Integer>();
            
        List<Integer> result = new ArrayList<>();
        HashMap<String, Integer> word_frequency = new HashMap<>();
        
        for (String word : words) {
            if (!word_frequency.containsKey(word))
                word_frequency.put(word, 1);
            else
                word_frequency.put(word, word_frequency.get(word) + 1);
        }
        
        int len = words[0].length();
        int total_len =words.length;
        for (int i = 0; i + len <= s.length(); i++) {
            String word = s.substring(i, i + len);
            if (word_frequency.containsKey(word) && dfs(s, i, word_frequency, total_len, len)) 
                result.add(i);
        }
        return result;
    }
    
    public boolean dfs(String s, int index, HashMap<String, Integer> word_frequency, int total_len, int word_len) {
        if (total_len == 0)
            return true;
        if (index + word_len >= s.length())
            return false;
        String sub = s.substring(index, index + word_len);
        if (!word_frequency.containsKey(sub) || word_frequency.get(sub) == 0)
            return false;
        word_frequency.put(sub, word_frequency.get(sub) - 1);
        
        if (dfs(s, index + word_len, word_frequency, total_len - 1, word_len)) {
            word_frequency.put(sub, word_frequency.get(sub) + 1);
            return true;
        } else {
            word_frequency.put(sub, word_frequency.get(sub) + 1);
            return false;
        }
    }
}
