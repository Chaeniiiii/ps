import java.util.*;

class Solution {
    public int solution(int sticker[]) {
        
        int len = sticker.length;
        if(len == 1) return sticker[0];
        else if(len == 2) return Math.max(sticker[0],sticker[1]);

        //첫번째 스티커를 선택했을 때
        int[] dp = new int[sticker.length];
        dp[0] = dp[1] = sticker[0];
        
        for(int i = 2; i < sticker.length - 1; i++){
            dp[i] = Math.max(dp[i-1],dp[i-2] + sticker[i]);
        }
        
        //첫번째 스티커를 선택하지 않았을 때
        int[] dp2 = new int[sticker.length];
        dp2[1] = sticker[1];
        for(int i = 2; i < sticker.length; i++){
            dp2[i] = Math.max(dp2[i-1],dp2[i-2] + sticker[i]);
        }
        
        return Math.max(dp[sticker.length - 2], dp2[sticker.length - 1]);
        
    }
}