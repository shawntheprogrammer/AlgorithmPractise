import java.util.TreeMap;

public class ContainsDuplicateIII {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        //use treemap which implement support a O(lg(N)) time on get and put and remove
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            //we maintain a window of size k + 1
            if (map.size() == k + 1) {
                map.remove(nums[i - k - 1]);
            }
            
            int element = nums[i];
            //ceil the least greater element
            Integer ceil = map.ceilingKey(element);
            //floor the greatest smaller element
            Integer floor = map.floorKey(element);
            
            //all the elment in map satisfies the K condition, we only check if difference is smaller than t
            //difference may overflow, so use long type
            if (ceil != null &&  (long)Math.abs((long)ceil - (long)element) <= (long)t) {
                return true;
            }
            if (floor != null && (long)Math.abs((long)floor - (long)element) <= (long)t) {
                return true;
            }
            map.put(element, i);
        }
        
        return false;
    }
}
