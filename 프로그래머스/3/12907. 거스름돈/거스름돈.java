import java.util.*;

class Solution {
    public int solution(int n, int[] money) {
        
        int[] dp = new int[n+1];
        Arrays.fill(dp,Integer.MIN_VALUE);
        dp[0] = 0;
        
        for(int i = 0; i<n+1; i++){
            if(dp[i] == Integer.MIN_VALUE) continue;
            for(int j = 0; j<money.length; j++){
                int amount = i + money[j];
                if(amount >= n+1 || amount < 0) continue;
                dp[amount] = Math.max(dp[amount],dp[i]+1)%1000000007;
            }
        }
        
        System.out.println(Arrays.toString(dp));
        return dp[n]/1000000007;
        
    }
}