
public class SortColors {
    /* param int[] nums : an integer array
     * sort the nums by one pass as nums only contain 0, 1, 2
     */
    public static void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int c0 = 0;
        int c1 = 0;
        int c2 = 0;
        while (c0 + c1 + c2 < nums.length) {
            // if the current element is 0, sawp it with
            int i = c0 + c1;
            if (nums[i] == 0) {
                swap(nums, c0, i);
                c0++;
            }
            else if (nums[i] == 1) {
                c1++;
            }
            else {
                swap(nums, nums.length - 1 - c2, i);
                c2++;
            }
        }
    }
    
    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
