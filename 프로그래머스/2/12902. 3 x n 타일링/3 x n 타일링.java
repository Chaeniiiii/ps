import java.util.*;

class Solution {
    public int solution(int n) {
        
        long mod = 1_000_000_007;
        
        long[] dp = new long[n+1];
        dp[0] = 1;
        dp[2] = 3;
        
        for(int i = 4; i <= n; i+=2){
            dp[i] = (dp[i-2] * 3) % mod;
            for(int j = 0; j <= i - 4; j+=2){
                dp[i] += (dp[j] * 2);
                dp[i] %= mod;
            }
        }
        
        return (int)dp[n];
        
    }
}