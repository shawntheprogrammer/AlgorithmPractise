
public class PartitionArraybyOddandEven {
    /**
     * @param nums: an array of integers
     * @return: nothing
     */
    public void partitionArray(int[] nums) {
        // write your code here;
        if (nums == null || nums.length == 0) {
            return;
        }
        int odd = 0;
        //scan through the array
        for (int i = 0; i < nums.length; i++) {
            //if nums[i] is odd swap it with nums[odd]
            if (nums[i] % 2 == 1) {
                int temp = nums[i];
                nums[i] = nums[odd];
                nums[odd] = temp;
                odd++;
            }
        }
    }
}
