import java.util.*;

class Solution {
    public int solution(int sticker[]) {
                
        int result = 0, size = sticker.length;
        
        if(size == 1) return sticker[0];
        
        int [] dp = new int [size];
        int [] dp2 = new int [size];
        
        dp[0] = sticker[0];
        dp[1] = sticker[0];
        
        for(int i = 2; i<size-1; i++){
            dp[i] = Math.max(dp[i-1],dp[i-2]+sticker[i]);
        }
        
        dp2[0] = 0;
        dp2[1] = sticker[1];
        
        for(int i = 2; i<size; i++){
            dp2[i] = Math.max(dp2[i-1],dp2[i-2]+sticker[i]);
        }
        
        return Math.max(dp[size-2],dp2[size-1]);
        
    }
}