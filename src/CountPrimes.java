import java.util.*;

public class CountPrimes {
    public int countPrimes(int n) {
        if (n <= 1) {
            return 0;
        }
        //initiate an array assuming it's all prime numbers
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        
        //for every number, if it's prime number, than starts from i * i to n, take off all its multipliers
        for (int i = 2; i * i < n; i++) {
            if (!isPrime[i])
                continue;
            for (int j = i * i; j < n; j+=i) {
                isPrime[j] = false;
            }
        }
        
        int count = 0;
        
        //count trues in the array
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                count++;
            }
        }
        return count;
    }
}
