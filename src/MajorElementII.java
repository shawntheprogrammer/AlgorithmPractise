import java.util.*;

public class MajorElementII {
    public List<Integer> majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<Integer>();
        }
        
        //return list
        List<Integer> result = new ArrayList<>();
        
        //result candidate n1 and n2, have c1 and c2 to record the number of "frequency"
        //basic idea is to take away three different elements at the same time whatever appers next would be a candidate
        int n1 = 0;
        int n2 = 0;
        int c1 = 0;
        int c2 = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (c1 == 0) {
                n1 = nums[i];
                c1 = 1;
            } else if (nums[i] == n1) {
                c1++;
            } else if (c2 == 0) {
                n2 = nums[i];
                c2 = 1;
            } else if (nums[i] == n2) {
                c2++;
            } else {
                c1--;
                c2--;
            }
        }
        
        //note they are just candidates, now we gotta verify the frequency
        c1 = 0;
        c2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == n1) {
                c1++;
            } else if (nums[i] == n2) {
                c2++;
            }
        }
        if (c1 > nums.length / 3) {
            result.add(n1);
        }
        if (c2 > nums.length / 3) {
            result.add(n2);
        }
        return result;
    }
    
}
