
public class HouseRubber {
    /**
     * @param A: An array of non-negative integers.
     * return: The maximum amount of money you can rob tonight
     */
    public long houseRobber(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return 0;
        }
        long last1 = 0;
        long last2 = 0;
        for (int i = 0; i < A.length; i++) {
            long temp = last2;
            last2 = Math.max(last2, last1 + A[i]);
            last1 = temp;
        }
        return last2;
    }
}
