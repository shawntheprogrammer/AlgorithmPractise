
public class BullsAndCows {
    public String getHint(String secret, String guess) {
        if (secret == null || guess == null) {
            return "";
        }   
        int bulls = 0;
        int cows = 0;
        //arr[i] > 0 means digit i in secret has not been paired
        //arr[i] < 0 means digit i in guess has not been paired
        int[] arr = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bulls++;
            } else {
                int sec = secret.charAt(i) - '0';
                if (arr[sec] < 0) {
                    cows++;
                }
                arr[sec]++;
                int gue = guess.charAt(i) - '0';
                if (arr[gue] > 0) {
                    cows++;
                }
                arr[gue]--;
            }
        }
        
        return String.valueOf(bulls) + "A" + String.valueOf(cows) + "B";
    }
}
