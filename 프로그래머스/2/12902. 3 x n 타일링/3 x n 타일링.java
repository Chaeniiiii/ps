import java.util.*;

class Solution {
    public int solution(int n) {
        
        int MOD = 1_000_000_007;
        int[] dp = new int[n+1];
        dp[1] = 2;
        dp[2] = 3;
        
        for(int i = 3; i <= n; i++){
            if(i % 2 == 0){
                dp[i] = (dp[i - 1] % MOD + dp[i - 2] % MOD) % MOD;
            }
            else{
                dp[i] = ((dp[i - 1] * 2) % MOD + dp[i - 2] % MOD) % MOD;
            }
        }
        
        return dp[n];
        
    }
}