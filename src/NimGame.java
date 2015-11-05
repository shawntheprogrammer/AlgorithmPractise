
public class NimGame {
    public boolean canWinNim(int n) {
        if (n <= 0) {
            return true;
        }
        if (n % 4 == 0) {
            return false;
        } else {
            return true;
        }
    }
}
