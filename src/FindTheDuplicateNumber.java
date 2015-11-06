
public class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        //using Tortoise & Hair algorithm by Donald Knuth to find cycle in a sequence.
        //This algorithm also called Floyd's cycele detection algorithm
        int slow = 0;
        int fast = 0;

       do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while(slow != fast);

        //find the starting point of the cycle
        //int mu = 0;
        slow = 0;
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
            //mu++;
        }

        return slow;
    }
}
