import java.util.*;

class Solution {
    public long solution(int n) {
        
        if(n == 2) return 2;
        else if(n <= 1) return 1;
        
        long[] dp = new long[n+1];
        dp[0] = dp[1] = 1;
        dp[2] = 2;
        
        for(int i = 3; i <= n; i++){
            dp[i] = (dp[i-1] + dp[i-2])  % 1234567;
        }
        
        return dp[n];
        
    }
}