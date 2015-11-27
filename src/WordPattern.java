import java.util.*;
public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        if (pattern == null && str == null)
            return true;
        if (pattern == null || str == null)
            return false;
        int len1 = pattern.length();
        String[] strs = str.split(" ");
        if (pattern.length() != strs.length)
            return false;
        
        //    
        HashMap<Character, String> p_s = new HashMap<>();
        HashMap<String, Character> s_p = new HashMap<>();
        
        for (int i = 0; i < pattern.length(); i++) {
            char pc = pattern.charAt(i);
            String s = strs[i];
            if (!p_s.containsKey(pc) && !s_p.containsKey(s)) {
                p_s.put(pc, s);
                s_p.put(s, pc);
            } else if (p_s.containsKey(pc) && s_p.containsKey(s)) {
                if (pc != s_p.get(s) || !s.equals(p_s.get(pc)))
                    return false;
            } else {
                return false;
            }
        }
        
        return true;
    }
}
