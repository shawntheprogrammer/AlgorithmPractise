import java.util.*;

public class MajorityNumberIII {
    /**
     * @param nums: A list of integers
     * @param k: As described
     * @return: The majority number
     */
    public int majorityNumber(ArrayList<Integer> nums, int k) {
        // write your code
        if (k <= 1 || nums == null || nums.size() == 0) {
            return 0;
        }
        
        //we should have k - 1 possible candidates
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (Integer element : nums) {
            //if map contains this element, update count
            if (map.containsKey(element)) {
                map.put(element, map.get(element) + 1);
            } 
            //if map's size < k - 1, means we haven't found k - 1 candidates yet
            else if (map.size() < k - 1) {
                map.put(element, 1);
            }  
            //this is a element that's not in the k - 1 candidates, decrease count by 1 for all the candidates
            else {
                List<Integer> removes = new ArrayList<>();
                for (Integer key : map.keySet()) {
                    if (map.get(key) == 1) {
                        removes.add(key);
                    } else {
                        map.put(key, map.get(key) - 1);
                    }
                }
                for (Integer key : removes) {
                    map.remove(key);
                }
            }
        }
        
        for (Integer key : map.keySet()) {
            map.put(key, 0);
        }
        
        int result = 0;
        int max = 0;
        for (Integer element : nums) {
            if (map.containsKey(element)) {
                map.put(element, map.get(element) + 1);
                if (map.get(element) > max) {
                    max = map.get(element);
                    result = element;
                }
            }
        }
        
        return result;
    }
}
