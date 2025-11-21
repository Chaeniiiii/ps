import java.util.*;

class Solution {
    
    public int[] solution(int n) {
        
        int[][] board = new int[n][n];
        int max = (n*(n+1))/2;
        
        int x = -1 ,y = 0, cnt = 1;
        
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                if(i % 3 == 0) x++;
                else if(i % 3 == 1) y++;
                else if(i % 3 == 2){
                    x--;
                    y--;
                }
                board[x][y] = cnt;
                cnt++;
            }
        }        
        
        int[] result = new int[max];
        int idx = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j <= i; j++){
                if(board[i][j] == 0) continue;
                result[idx] = board[i][j];
                idx++;
            }
        }
        
        return result;
        
    }
}