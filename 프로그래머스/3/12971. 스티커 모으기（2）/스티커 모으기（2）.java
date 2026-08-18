import java.util.*;

class Solution {
    public int solution(int sticker[]) {
        
        int len = sticker.length;
        if(len == 1) return sticker[0];
        if(len == 2) return Math.max(sticker[0],sticker[1]);
        
        int[] dp = new int[len - 1];
        dp[0] = dp[1] = sticker[0];
        
        for(int i = 2; i < dp.length; i++){
            dp[i] = Math.max(dp[i-1],dp[i-2] + sticker[i]);
        }
        
        int[] dp2 = new int[len];
        dp2[1] = sticker[1];
        
        for(int i = 2; i < dp2.length; i++){
            dp2[i] = Math.max(dp2[i-1],dp2[i-2] + sticker[i]);
        }
        
        return Math.max(dp[dp.length - 1],dp2[dp2.length - 1]);
        
    }
}