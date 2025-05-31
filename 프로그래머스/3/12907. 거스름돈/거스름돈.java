import java.util.*;

class Solution {
    public int solution(int n, int[] money) {
        
        long[] dp = new long[n+1];
        dp[0] = 1;
        
        for(int m : money){
            for(int j = m; j<=n; j++){
                dp[j] += dp[j-m]%1000000007;
            }
        }
        
        return (int)dp[n]%1000000007;
        
    }
}