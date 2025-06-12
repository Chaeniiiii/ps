import java.util.*;

class Solution {
    
    public int[] solution(int target) {
        
        int[][] dp = new int[target+1][2]; //dp[i] = {다트 던진 횟수, 싱글 + 불 횟수}
        
        for(int i = 0; i <= target; i++){
            dp[i][0] = Integer.MAX_VALUE;
            dp[i][1] = 0;
        }
        
        dp[0][0] = 0;
        
        for(int i = 1; i < target + 1; i++){
            for(int j = 1; j <= 20; j++){
                if(i >= 50){
                    if(dp[i][0] > dp[i-50][0] + 1){
                        dp[i][0] = dp[i-50][0] + 1;
                        dp[i][1] = dp[i-50][1] + 1;
                    }
                    else if(dp[i][0] == dp[i-50][0] + 1){
                        dp[i][1] =  Math.max(dp[i][1], dp[i-50][1] + 1);
                    }
                }
                if(j <= i){ //싱글을 맞춘 경우
                    if(dp[i][0] > dp[i-j][0] + 1){
                        dp[i][0] = dp[i-j][0] + 1;
                        dp[i][1] = dp[i-j][1] + 1;
                    }
                    else if(dp[i][0] == dp[i-j][0] + 1){
                        dp[i][1] =  Math.max(dp[i][1], dp[i-j][1] + 1);
                    }
                }
                if(j*2 <= i){
                    if(dp[i][0] > dp[i-j*2][0] + 1){
                        dp[i][0] = dp[i-j*2][0] + 1;
                        dp[i][1] = dp[i-j*2][1];
                    }
                }
                if(j*3 <= i){
                    if(dp[i][0] > dp[i-j*3][0] + 1){
                        dp[i][0] = dp[i-j*3][0] + 1;
                        dp[i][1] = dp[i-j*3][1];
                    }
                }
            }
        }
        
        return dp[target];
        
    }
}