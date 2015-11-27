package Google;

public class WildcardMatching {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null)
            return false;
            
        boolean[][] dp = new boolean[p.length() + 1][s.length() + 1];
        //empty mataches empty
        dp[0][0] = true;
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = (p.charAt(i - 1) == '*' && dp[i - 1][0]);
        }
        
        for (int i = 1; i < dp.length; i++) {
            boolean local = dp[i - 1][0];
            for (int j = 1; j < dp[0].length; j++) {
                char pc = p.charAt(i - 1);
                char sc = s.charAt(j - 1);
                local = local || dp[i - 1][j];
                
                if (pc == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pc == '*') {
                    dp[i][j] = local;
                } else {
                    dp[i][j] = (pc == sc) && dp[i-1][j-1];
                }
            }
        }
        
        return dp[p.length()][s.length()];
    }
}
