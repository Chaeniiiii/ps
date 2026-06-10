import java.util.*;

class Solution {
    public int solution(int[] money) {
        
        int len = money.length;
        
        int[] dp = new int[len];
        dp[0] = money[0];
        dp[1] = money[1];
        dp[2] = money[2] + dp[0];
        
        for(int i = 3; i < len - 1; i++){
             dp[i] = money[i] + Math.max(dp[i-2],dp[i-3]);
        }

        int[] dp2 = new int[len];
        dp2[0] = 0;
        dp2[1] = money[1];
        dp2[2] = money[2];
        
        for(int i = 3; i < len; i++){
            dp2[i] = money[i] + Math.max(dp2[i-2],dp2[i-3]);
        }
        
        return Math.max(Math.max(dp[len - 2],dp[len - 3]),Math.max(dp2[len - 1],dp2[len - 2]));
        
    }
}