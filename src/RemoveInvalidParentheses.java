import java.util.*;

public class RemoveInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return new ArrayList<String>();
        }
        List<HashSet<String>> combinations = new ArrayList<>();
        
        int last = -1;
        int left = 0;
        int right = 0;
        //scan through, whenever it breaks the rule right > left , modify the string and return a list of possible valid string
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else if(s.charAt(i) == ')') {
                right++;
            }
            
            //condition we have to remove one '(' to maintain the rule
            if (right > left) {
                HashSet<String> list = removeRight(s.substring(last + 1, i + 1));
                if (list.size() != 0)
                    combinations.add(list);
                left = 0;
                right = 0;
                last = i;
            }
        }
        
        HashSet<String> list = new HashSet<>();
        if (left > right) {
            removeLeft(s.substring(last + 1), left - right, list);
            combinations.add(list);
        } else {
            list.add(s.substring(last + 1));
            combinations.add(list);
        }
        
        List<String> result = new ArrayList<>();
        getCombinations(combinations, 0, result, "");
        return result;
    }
    
    public void getCombinations(List<HashSet<String>> combinations, int i, List<String> list, String s) {
        if (i == combinations.size()) {
            list.add(s);
            return;
        }    
        HashSet<String> set = combinations.get(i);
        for (String ss : set) {
            getCombinations(combinations, i + 1, list, s + ss);
        }
    }
    
    public HashSet<String> removeRight(String s) {
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                String sub = s.substring(0, i) + s.substring(i + 1);
                set.add(sub);
            }
        }
        return set;
    }
    
    public void removeLeft(String s, int num, HashSet<String> list) {
        if (num == 0) {
            list.add(s);
            return;
        }
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                String sub = s.substring(0, i) + s.substring(i + 1);
                remoevLeft(sub, num - 1, list);
            }
        }
    }
}
