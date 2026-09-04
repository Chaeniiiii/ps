import java.util.*;

class Solution {
    public int solution(int[][] board, int[][] skill) {
        
        int n = board.length;
        int m = board[0].length;
        
        int[][] dp = new int[n+1][m+1];
        for(int i = 0; i < skill.length; i++){
            int[] sk = skill[i];
            int x1 = sk[1];
            int y1 = sk[2];
            int x2 = sk[3];
            int y2 = sk[4];
            int d = sk[0] == 1 ? -sk[5] : sk[5];
            
            dp[x1][y1] += d;
            dp[x2+1][y2+1] += d;
            
            dp[x1][y2+1] -= d;
            dp[x2+1][y1] -= d;
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 1; j < m; j++){
                dp[i][j] += dp[i][j-1];
            }
        }
        
        for(int i = 1; i < n; i++){
            for(int j = 0; j < m; j++){
                dp[i][j] += dp[i-1][j];
            }
        }
        
        int cnt = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] + dp[i][j] > 0) cnt++;
            }
        }
        
        return cnt;
        
    }
}