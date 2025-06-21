import java.util.*;

class Solution {
    
    private static int n,m;
    
    private static int[][] beginning;
    private static int[][] target;
    
    private static int result = Integer.MAX_VALUE;
    
    public int solution(int[][] beginning, int[][] target) {
        
        n = beginning.length;
        m = beginning[0].length;
        
        this.beginning = beginning;
        this.target = target;
        
        dfs(0,0);
        
        return result == Integer.MAX_VALUE ? -1 : result;
        
    }
    
    private static void dfs(int dep, int cnt){
        
        if(dep == n){
            compareCol(cnt);
            return;
        }
        
        //행을 뒤집었을 경우
        reverseRow(dep);
        dfs(dep+1,cnt+1);
        
        //행을 다시 되돌릴 경우
        reverseRow(dep);
        dfs(dep+1,cnt);
        
    }
    
    private static void compareCol(int cnt){
        
        int answer = cnt; 
        for(int i = 0; i < m; i++){
            int score = 0;
            for(int j = 0; j < n; j++){
                if(beginning[j][i] != target[j][i]) score ++;      
            }
            if(score == n) answer++;
            else if(score != 0) return;
        }
        
        result = Math.min(answer,result);
        
    }
    
    private static void reverseRow(int row){
        
        for(int i = 0; i < m; i ++){
            beginning[row][i] = (beginning[row][i]+1)%2;
        }
        
    }
    
}