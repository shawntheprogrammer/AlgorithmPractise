
public class DivideTwoIntegers {
        /**
         * @param dividend the dividend
         * @param divisor the divisor
         * @return the result
         */
         //use '+' and '-'
        public static int divide(int dividend, int divisor) {
            // Write your code here
            if (dividend == 0) {
                return 0;
            }
            //when it overflows
            if (dividend == Integer.MIN_VALUE && divisor == -1) {
                return Integer.MAX_VALUE;
            }
            //convert to long and both positive
            if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
                return -div(Math.abs((long)dividend), Math.abs((long)divisor));
            }
            if (dividend < 0 && divisor < 0) {
                return div(Math.abs((long)dividend), Math.abs((long)divisor));
            }
            return div((long)dividend, (long)divisor);
        }
        
        public static int div(long dividend, long divisor) {
            if (dividend == 0) {
                return 0;
            }
            if (dividend < divisor) {
                return 0;
            }
            int result = 1;
            long div = dividend;
            long base = divisor;
            while (div > base + base) {
                result = result + result;
                base = base + base;
            }
            return result + div(dividend - base, divisor);
        }
        
        public static void  main(String[] args) {
            System.out.println(divide(29, 3));
        }
}
