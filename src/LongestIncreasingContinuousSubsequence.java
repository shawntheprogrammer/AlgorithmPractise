
public class LongestIncreasingContinuousSubsequence {
    
    public int lics(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int longest = 1;
        int localLongest = 1;
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i - 1]) {
                localLongest++;
            } else {
                localLongest = 1;
            }
            longest = Math.max(longest, localLongest);
        }
        localLongest = 1;
        for (int i = A.length - 2; i >= 0; i--) {
            if (A[i] > A[i + 1]) {
                localLongest++;
            } else {
                localLongest = 1;
            }
            longest = Math.max(longest, localLongest);
        }
        return longest;
    }

}
