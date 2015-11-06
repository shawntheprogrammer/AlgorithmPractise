import java.util.*;

public class RemoveInvalidParentheses {
    public static List<String> removeInvalidParentheses(String s) {
        HashSet<String> set = new HashSet<>();
        set.add(s);
        
        HashSet<String> result = new HashSet<>();
        boolean found = false;
        
        if (isValid(s)) {
            ArrayList<String> list = new ArrayList<>();
            list.add(s);
            return list;
        }
        
        while (!found && set.size() != 0) {
            //bfs
            HashSet<String> next = new HashSet<>();
            
            for (String ss : set) {
                for (int i = 0; i < ss.length(); i++) {
                    if (ss.charAt(i) == '(' || ss.charAt(i) == ')') {
                        String sub = ss.substring(0, i) + ss.substring(i + 1);
                        next.add(sub);
                        boolean valid = isValid(sub);
                        if (valid) {
                            found = true;
                            result.add(sub);
                        }
                    }
                }    
            }
            
            set = next;
        }
        
        ArrayList<String> list = new ArrayList<>();
        for (String str : result)
            list.add(str);
            
        return list;
    }
    
    public static boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        
        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else if (s.charAt(i) == ')') {
                right++;
            }
            //anytime left >= right
            if (right > left) {
                return false;
            }
        }
        return left == right;
    }
    
    public static void main(String[] args) {
        removeInvalidParentheses(")(");
    }
}
