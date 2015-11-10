import java.util.*;

public class WiggleSort {
    public void wiggleSort(int[] nums) {
        //basic idea: maintain the order of nums
        
        for (int i = 1; i < nums.length; i++) {
            if (i % 2 == 1 && nums[i] < nums[i - 1]) {
                swap(nums, i, i - 1);
            }
            if (i % 2 == 0 && nums[i] > nums[i - 1]) {
                swap(nums, i, i - 1);
            }
        }
    }
    
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    //NLg(N)
    public void wiggleSortII(int[] nums) {
        //basic idea  sort nums
        //two pointers  i start from 0  j start from (nums.length + 1)/2  NLg(N)
        if (nums == null || nums.length <= 1) {
            return;
        }
        Arrays.sort(nums);
        int i = 1;
        int j = (nums.length + 1) / 2;
        while (j < nums.length) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i += 2;
            j++;
        }
    }
}
