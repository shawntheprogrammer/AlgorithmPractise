
public class CoinsInALine {
    /**
     * @param n: an integer
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int n) {
        // write your code here
        if (n % 3 == 1 || n % 3 == 2) {
            return true;
        } else {
            return false;
        }
    }
}
