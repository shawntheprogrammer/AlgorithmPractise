
public class ReverseInteger {
    /**
     * @param n the integer to be reversed
     * @return the reversed integer
     */
    public int reverseInteger(int n) {
        // Write your code here
        long result = reverse(Math.abs((long)n));
        // when it overflows
        if ((result > Integer.MAX_VALUE && n > 0) || (result < Integer.MIN_VALUE && n < 0)) {
            return 0;
        }
        return (n > 0) ? (int)result : -(int)result;
    }
    
    public long reverse(long n) {
        long result = 0;
        //get the last digit and make result = result * 10 + digit
        while (n != 0) {
            long digit = n % 10;
            result = result * 10 + digit;
            n = n / 10;
        }
        return result;
    }
}
