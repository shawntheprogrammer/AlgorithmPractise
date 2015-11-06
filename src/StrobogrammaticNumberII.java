import java.util.*;

public class StrobogrammaticNumberII {
    public List<String> findStrobogrammatic(int n) {
        // a map of all possible combinations
        HashMap<Character, Character> map = new HashMap<>();
        map.put('1', '1');
        map.put('0', '0');
        map.put('6', '9');
        map.put('8', '8');
        map.put('9', '6');
        //array used for backtracking
        char[] array = new char[n];
        List<String> result = new ArrayList<>();
        getStrobogrammatic(array, 0, n - 1, result, map);
        return result;
    }
    
    public void getStrobogrammatic(char[] array, int start, int end, List<String> result, HashMap<Character, Character> map) {
        if (start > end) {
            result.add(String.valueOf(array));
            return;
        }
        if (start == end) {
            if (start != 0 || array.length == 1) {
                array[start] = '0';
                getStrobogrammatic(array, start + 1, end - 1, result, map);
            }
            array[start] = '1';
            getStrobogrammatic(array, start + 1, end - 1, result, map);
            
            array[start] = '8';
            getStrobogrammatic(array, start + 1, end - 1, result, map);
        } else {
            for (Character c0 : map.keySet()) {
                if (start == 0 && c0 == '0') {
                    continue;
                }
                char c1 = map.get(c0);
                array[start] = c0;
                array[end] = c1;
                getStrobogrammatic(array, start + 1, end - 1, result, map);
            }
        }
    }
}
