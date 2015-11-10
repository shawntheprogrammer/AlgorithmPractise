import java.util.*;

public class MaximumGap {
    public int maximumGap(int[] nums) {
        //invalid input
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        
        //find out the min and max value in the array
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        
        if (min == max) {
            return 0;
        }
        
        //the size of the bucket is the ceiling of max-min / nums.length - 2
        int bucket = (max - min + nums.length - 2) / (nums.length - 1);
        int size = (max - min) / bucket + 1;
        
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int bucketNo = (nums[i] - min) / bucket;
            if (!map.containsKey(bucketNo)) {
                map.put(bucketNo, new ArrayList<Integer>());
            }
            List<Integer> list = map.get(bucketNo);
            list.add(nums[i]);
            //we only keep at most two elements in a list
            Collections.sort(map.get(bucketNo));
            //notice we delete the middle value of the 3 elements
            if (list.size() > 2) {
                list.remove(list.size() - 2);
            }
        }
        
        max = bucket;
        int i = 0;
        while (i < size) {
            int j = i + 1;
            while (!map.containsKey(j) && j < size) {
                j++;
            }
            if (j >= size) {
                break;
            }
            List<Integer> l1 = map.get(i);
            List<Integer> l2 = map.get(j);
            max = Math.max(max, l2.get(0) - l1.get(l1.size() - 1));
            i = j;
        }
        
        return max;
    }
}
