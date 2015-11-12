import java.util.*;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) 
            return 0;

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++)
            set.add(nums[i]);
        
        int longest = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i])) 
                continue;
            int left = nums[i];
            int count = 0;
            while (set.contains(left)) {
                set.remove(left);
                left--;
                count++;
            }
            
            int right = nums[i] + 1;
            while (set.contains(right)) {
                set.remove(right++);
                count++;
            }
            
            longest = Math.max(longest, count);
        }
        
        return longest;
    }
}
