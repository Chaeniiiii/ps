import java.util.*;

class Solution {
    
    private static final int MAX = 1_000_000;
    
    public int solution(int x, int y, int n) {
        
        int[] dp = new int[MAX+1];
        Arrays.fill(dp,MAX);
        dp[x] = 0;
        
        for(int i = x; i <= y; i++){
            for(int num : new int[]{i*2,i*3,i+n}){
                if(num > MAX) continue;
                dp[num] = Math.min(dp[num],dp[i]+1);
            }
        }        
        
        return dp[y] == MAX ? -1 : dp[y];
        
        
    }
}