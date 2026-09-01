import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        
        int[][] floyd = new int[n+1][n+1];
        for(int i = 0; i < results.length; i++){
            int[] r = results[i];
            floyd[r[0]][r[1]] = 1;
            floyd[r[1]][r[0]] = -1;
        }
        
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                for(int k = 1; k <= n; k++){
                    if(floyd[i][k] == 1 && floyd[k][j] == 1){
                        floyd[i][j] = 1;
                        floyd[j][i] = -1;
                    }
                    else if(floyd[i][k] == -1 && floyd[k][j] == -1){
                        floyd[j][i] = 1;
                        floyd[i][j] = -1;
                    }
                    
                }
            }
        }
        
        int result = 0;
        for(int i = 1; i <= n; i++){
            int cnt = 0;
            for(int j = 1; j <= n; j++){
                if(floyd[i][j] == 0) cnt++;
            }
            if(cnt == 1) result++;
        }
        
        return result;
        
    }
}