import java.util.*;

public class LongestSubstringwithAtMostKDistinctCharacters {
    /**
     * @param s : A string
     * @return : The length of the longest substring 
     *           that contains at most k distinct characters.
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        // write your code here
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        //maintain a window that has k characters, map record the char -> frequency in this window
        HashMap<Character, Integer> map = new HashMap<>();
        int longest = 0;
        //the starting position of the window
        int start = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, 0);
            }
            map.put(c, map.get(c) + 1);
            
            //shrink the window to size k, move start
            while (map.size() > k) {
                char sc = s.charAt(start);
                if (map.get(sc) == 1) {
                    map.remove(sc);
                } else {
                    map.put(sc, map.get(sc) - 1);
                }
                start++;
            }
            
            longest = Math.max(i - start + 1, longest);
        }
        
        return longest;
    }
}
