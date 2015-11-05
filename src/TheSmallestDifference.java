import java.util.*;

public class TheSmallestDifference {
    /**
     * @param A, B: Two integer arrays.
     * @return: Their smallest difference.
     */
    public int smallestDifference(int[] A, int[] B) {
        // write your code here
        if (A == null || B == null || A.length == 0 || B.length == 0) {
            return 0;
        }
        
        int i = 0;
        int j = 0;
        int minDiff = Integer.MAX_VALUE;
        
        Arrays.sort(A);
        Arrays.sort(B);
        while (i < A.length && j < B.length) {
            int diff = (int)Math.abs(A[i] - B[j]);
            minDiff = Math.min(minDiff, diff);
            
            if (A[i] < B[j]) {
                i++;
            } else {
                j++;
            }
        }
        
        return minDiff;
    }
}
