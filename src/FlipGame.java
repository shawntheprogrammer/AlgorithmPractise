import java.util.*;

public class FlipGame {
    public List<String> generatePossibleNextMoves(String s) {
        if (s == null || s.length() == 0) {
            return new ArrayList<String>();
        }
        List<String> result = new ArrayList<>();
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '+' && s.charAt(i + 1) == '+') {
                String ss = s.substring(0, i) + "--" + s.substring(i + 2);
                result.add(ss);
            }
        }
        return result;
    }
}
