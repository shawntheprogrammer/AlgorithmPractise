import java.util.*;

public class PermutationIndex {
    /**
     * @param A an integer array
     * @return a long integer
     */
    public long permutationIndex(int[] A) {
        // Write your code here
        if (A == null || A.length == 0) {
            return 0;
        }
        
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            list.add(A[i]);
        }
        Collections.sort(list);
        
        long rank = 1;
        for (int i = 0; i < A.length; i++) {
            //find its index in the list -> index
            long index = (long)list.indexOf(A[i]);
            //remove it from list
            list.remove((int)index);
            //rank += index * (A.length - i - 1) !
            rank += index * getPolynomial(A.length - i - 1);
        }
        return rank;
    }
    
    public long getPolynomial(int n) {
        long result = 1;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return result;
        }
        for (int i = 2; i <= n; i++) 
            result *= (long)i;
            
        return result;
    }
}
