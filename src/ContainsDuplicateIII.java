import java.util.TreeMap;
import java.util.*;

public class ContainsDuplicateIII {
    
    //O(Nlg(N))
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
    
    //O(N)
    public boolean containsNearbyAlmostDuplicateII(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || k < 0 || t < 0) {
            return false;
        }
        //use bucket idea, element/t (ceiling) -> element
        HashMap<Long, Integer> map = new HashMap<>();
        //if there is two elements in one bucket, we have found one
        //otherwise, we only compare bucket i's element with bucket i - 1 and bucket i + 1
        
        for (int i = 0; i < nums.length; i++) {
            //maintain a window size of k + 1
            if (map.size() == k + 1) {
                //we need to remove the first element of the last round's window
                long first_no = (t == 0) ? nums[i - k - 1] : (long)((long)nums[i - k - 1] + (long)t - 1) / (long)t;
                map.remove(first_no);
            }
            
            long bucketNo = (t == 0) ? nums[i] : (long)((long)nums[i] + (long)t - 1) / (long)t;
            //return true if there are two elements in the same bucket
            if (map.containsKey(bucketNo)) {
                return true;
            }
            //check the neighboring buckets
            if (map.containsKey(bucketNo - 1) && (long)Math.abs((long)map.get(bucketNo - 1) - (long)nums[i]) <= (long)t) {
                return true;
            }
            if (map.containsKey(bucketNo + 1) && (long)Math.abs((long)map.get(bucketNo + 1) - (long)nums[i]) <= (long)t) {
                return true;
            }
            map.put(bucketNo, nums[i]);
        }
        
        return false;
    }
}
