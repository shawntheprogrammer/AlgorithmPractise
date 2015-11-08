import java.util.*;

public class IntervalSum {
    /**
     *@param A, queries: Given an integer array and an query list
     *@return: The result list
     */
    
    public class Interval {
             int start, end;
             Interval(int start, int end) {
                 this.start = start;
                 this.end = end;
             }
    }
    
    public ArrayList<Long> intervalSum(int[] A, 
                                       ArrayList<Interval> queries) {
        //get the suffix sum array
        long[] suffix = new long[A.length];
        long sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += (long)A[i];
            suffix[i] = sum;
        }
        
        ArrayList<Long> result = new ArrayList<>();
        for (int i = 0; i < queries.size(); i++) {
            int start = queries.get(i).start;
            int end = queries.get(i).end;
            // A[start....end] = suffix[end] - suffix[start] + A[start]
            long intervalSum = suffix[end] - suffix[start] + (long)A[start];
            result.add(intervalSum);
        }
        
        return result;
    }
}
