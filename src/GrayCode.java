import java.util.*;

public class GrayCode {
    /**
     * @param n a number
     * @return Gray code
     */
    public ArrayList<Integer> grayCode(int n) {
        // Write your code here
        if (n < 0) {
            return null;
        }
        //initialize the list and add base case to it as n = 1
        ArrayList<Integer> result = new ArrayList<>();
        result.add(0);
        
        for (int i = 0; i < n; i++) {
            int pow = (int)Math.pow(2, i);
            //traverse the result backwards, add 2^1 to it
            for (int j = result.size() - 1; j >= 0; j--) {
                int before = result.get(j);
                int after = before + pow;
                result.add(after);
            }
        }
        
        return result;
    }
}
