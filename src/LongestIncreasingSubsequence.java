
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        //in this array
        //tail[i] means the the end element of the list that's i+1 long
        int[] tail = new int[nums.length];
        int len = 1;
        tail[0] = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > tail[len - 1]) {
                tail[len++] = nums[i];
            } else if (nums[i] <= tail[0]) {
                tail[0] = nums[i];
            } else {
                //find the index that's first time greater or equal than nums[i]
                int index = binarySearch(0, len - 1, nums[i], tail);
                tail[index] = nums[i];
            }
        }
        
        return len;
    }
    
    public int binarySearch(int start, int end, int target, int[] arr) {
        if (start > end) {
            return end;
        }
        int mid = start + (end - start) / 2;
        if (arr[mid] < target) {
            return binarySearch(mid + 1, end, target, arr);
        } else {
            if (start == end) {
                return start;
            }
            return binarySearch(start, mid, target, arr);
        }
    }
}
