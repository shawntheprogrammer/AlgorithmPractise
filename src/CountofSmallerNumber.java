import java.util.*;

public class CountofSmallerNumber {
    /**
     * @param A: An integer array
     * @return: The number of element in the array that 
     *          are smaller that the given integer
     */
    public ArrayList<Integer> countOfSmallerNumber(int[] A, int[] queries) {
        // write your code here
        if (A == null || queries == null) {
            return new ArrayList<Integer>();
        }
        Arrays.sort(A);
        //return list
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            int num = binarySearch(A, queries[i], 0, A.length - 1);
            result.add(num);
        }
        return result;
    }
    
    //return the index of the least element that's greater or equal than target
    public int binarySearch(int[] A, int target, int start, int end) {
        if (start > end) {
            return 0;
        }
        int mid = start + (end - start) / 2;
        
        if (target > A[mid]) {
            return binarySearch(A, target, mid + 1, end);
        } else {
            if (start == end) {
                return start;
            }
            return binarySearch(A, target, start, mid);
        }
    }
}
