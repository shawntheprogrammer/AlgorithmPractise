import java.util.*;

public class LargestNumber {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }
        
        Integer[] arr = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++)
            arr[i] = nums[i];
            
        Arrays.sort(arr, new Comparator<Integer>(){
           public int compare(Integer i1, Integer i2) {
               StringBuilder s1 = new StringBuilder();
               StringBuilder s2 = new StringBuilder();
               s1.append(i1); s1.append(i2);
               s2.append(i2); s2.append(i1);
               return s1.toString().compareTo(s2.toString());
           }
        });
        
        StringBuilder result = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--)
            result.append(arr[i]);
        
        //delete the leading zero
        int j = 0;
        while (j < result.length() - 1 && result.charAt(j) == '0')
            j++;
            
        return result.substring(j);
    }
}
