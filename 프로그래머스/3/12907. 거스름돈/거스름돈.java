import java.util.*;

class Solution {
    
    private static int MAX = 1_000_000_007;
    
    public int solution(int n, int[] money) {
        
        int[] dp = new int[n+1];
        dp[0] = 1;
        
        for(int m : money){
            for(int j = m; j<=n; j++){
                dp[j] += dp[j-m]%MAX;
            }
        }
        
        return dp[n]%1000000007;
        
    }
}