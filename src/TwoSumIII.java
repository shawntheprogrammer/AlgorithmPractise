
import java.util.*;

public class TwoSumIII {
    public int[] TwoSumIII(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }
        //value,index pair of the scanned element
        HashMap<Integer, Integer> map = new HashMap<>();
        //return array
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            //find a pair
            if (map.containsKey(target - nums[i])) {
                result[0] = map.get(target - nums[i]) + 1;
                result[1] = i + 1;
                return result;
            }
            map.put(nums[i], i);
        }
        //not found in the array
        return null;
    }
}
