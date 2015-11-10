
public class RangeSumQueryImmutable {
        int[] sum; // a suffix sum array
        public RangeSumQueryImmutable(int[] nums) {
            if (nums == null) {
                return;
            }
            sum = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                sum[i] = (i == 0) ? nums[i] : nums[i] + sum[i - 1];
            }
        }

        public int sumRange(int i, int j) {
            if (i < 0 || j >= sum.length || i > j) {
                return 0;
            }
            return (i == 0) ? sum[j] : sum[j] - sum[i - 1];
        }
}


    // Your NumArray object will be instantiated and called as such:
    // NumArray numArray = new NumArray(nums);
    // numArray.sumRange(0, 1);
    // numArray.sumRange(1, 2);
