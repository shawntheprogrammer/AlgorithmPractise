import java.util.*;

public class FlipGameII {
    public boolean canWin(String s) {
        HashMap<String, Boolean> map = new HashMap<>();
        return canWin(s.toCharArray(), map);
    }
    
    public boolean canWin(char[] ss, HashMap<String, Boolean> map) {
        if (map.containsKey(String.valueOf(ss))) {
            return map.get(String.valueOf(ss));
        }
        boolean wins = false;
        for (int is = 0; is <= ss.length-2; ++is) {
            if (ss[is] == '+' && ss[is+1] == '+') {
                ss[is] = '-'; ss[is+1] = '-';
                wins = !canWin(ss, map); 
                ss[is] = '+'; ss[is+1] = '+';
                if (wins) {
                    map.put(String.valueOf(ss), true);
                    return true;
                }
            }
        }
        map.put(String.valueOf(ss), false);
        return false;
    } 
}
