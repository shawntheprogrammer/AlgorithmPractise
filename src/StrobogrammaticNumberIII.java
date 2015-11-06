import java.util.*;

public class StrobogrammaticNumberIII {
    public int strobogrammaticInRange(String low, String high) {
        int count = 0;
        
        for (int i = low.length(); i <= high.length(); i++) {
            List<String> list =  findStrobogrammatic(i);
            if (i < high.length() && i > low.length()) {
                count += list.size();
            } else if (i == low.length() && i != high.length()) {
                for (String s : list) {
                    if (s.compareTo(low) >= 0) {
                        count++;
                    }
                }
            } else if (i == high.length() && i != low.length()) {
                for (String s : list) {
                    if (s.compareTo(high) <= 0) {
                        count++;
                    }
                }
            } else {
                for (String s : list) {
                    if (s.compareTo(low) >= 0 && s.compareTo(high) <= 0) {
                        count++;
                    }
                }
            }
        }
        
        return count;
    }
    
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
            // condition: n != 1 start position can't be 0 
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
