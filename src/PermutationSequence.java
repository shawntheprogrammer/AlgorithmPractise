import java.util.*;

public class PermutationSequence {
    public static String getPermutation(int n, int k) {
        //make a list of integers from 1 to n
        List<Integer> nums = new ArrayList<>();
        long polynomial = 1;
        for (int i = 1; i <= n; i++) {
            nums.add(i);
            polynomial *= (long)i;
        }
        
        if (k > polynomial || k < 0 || n <= 0) {
            return null;
        }
        
        polynomial /= n;
        long remainder = (long)k - 1;
        StringBuilder sb = new StringBuilder();
        while (nums.size() != 0) {
            int index = (int)(remainder / polynomial);
            remainder -= (long)index * polynomial;
            if (nums.size() != 1) {
                polynomial /= (nums.size() - 1);
            }
            sb.append(nums.remove(index));
        }
        
        return sb.toString();
    }
    
    public static void main(String[] args) {
        System.out.println(getPermutation(3, 3));
        System.out.println(getPermutation(3, 2));
        System.out.println(getPermutation(3, 1));
    }
}
