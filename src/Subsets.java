import java.util.*;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        //possible subsets is 2^n combinations, each element either in the list or not in the list
        //backtracking + dfs
        Arrays.sort(nums);
        dfs(nums, 0, new ArrayList<Integer>(), result);
        return result;
    }
    
    public void dfs(int[] nums, int start, ArrayList<Integer> arrayList, List<List<Integer>> result) {
        if (start == nums.length) {
            result.add(new ArrayList<Integer>(arrayList));
            return;
        }
        //add to the list
        arrayList.add(nums[start]);
        dfs(nums, start + 1, arrayList, result);
        //don't add
        arrayList.remove(arrayList.size() - 1);
        dfs(nums, start + 1, arrayList, result);
    }
}
