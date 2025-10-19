import java.util.*;

class Solution {
    public int solution(int alp, int cop, int[][] problems) {
        
        //최대 알고력, 코딩력 구해줌
        int maxA = 0, maxC = 0;
        for(int i = 0; i < problems.length; i++){
            maxA = Math.max(maxA,problems[i][0]);
            maxC = Math.max(maxC,problems[i][1]);
        }
        
        if(alp >= maxA && cop >= maxC) return 0;
        if(alp > maxA){
            alp = maxA;
        }
        if(cop > maxC){
            cop = maxC;
        }
        
        int[][] dp = new int[maxA+2][maxC+2];
        for(int i = alp; i <= maxA; i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        dp[alp][cop] = 0;
        
        for(int i = alp; i <= maxA; i++){
            for(int j = cop; j <= maxC; j++){
                dp[i+1][j] = Math.min(dp[i+1][j],dp[i][j]+1);
                dp[i][j+1] = Math.min(dp[i][j+1],dp[i][j]+1);
                
                for(int k = 0; k < problems.length; k++){
                    int kAlp = problems[k][0];
                    int kCop = problems[k][1];
                    int adAlp = problems[k][2];
                    int adCop = problems[k][3];
                    int time = problems[k][4];
                    
                    if(i < kAlp || j < kCop) continue;
                    if(i + adAlp > maxA && j + adCop > maxC){
                        dp[maxA][maxC] = Math.min(dp[maxA][maxC],dp[i][j]+time);
                    }
                    else if(i + adAlp > maxA){
                        dp[maxA][j+adCop] = Math.min(dp[maxA][j+adCop],dp[i][j]+time);
                    }
                    else if(j + adCop > maxC){
                       dp[i + adAlp][maxC] = Math.min(dp[i + adAlp][maxC],dp[i][j]+time);  
                    }
                    else{
                        dp[i+adAlp][j+adCop] = Math.min(dp[i+adAlp][j+adCop], dp[i][j]+time);
                    }
                }
            }
        }
        
        return dp[maxA][maxC];
        
        
    }
}