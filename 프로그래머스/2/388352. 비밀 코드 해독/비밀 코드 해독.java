import java.util.*;

class Solution {
    
    private int size = 5;
    
    private int n,result;
    private int[][] q;
    private int[] ans;
    
    public int solution(int n, int[][] q, int[] ans) {

        this.n = n;
        this.q = q;
        this.ans = ans;
        
        result = 0;
        dfs(1,0,new boolean[n+1]);
        
        return result;
        
    }
    
    private void dfs(int num, int dep, boolean[] arr){
        
        if(dep == size){
            if(isPossible(arr)) result ++;
            return;
        }
        
        for(int i = num; i <= n; i++){
            
            arr[i] = true;
            dfs(i+1,dep+1,arr);
            arr[i] = false;
            
        }        
        
    }
    
    private boolean isPossible(boolean[] arr){
        
        for(int i = 0; i < q.length; i++){
            
            int cnt = 0;
            int[] qArr = q[i];
            
            for(int j = 0; j < size; j++){
                if(arr[qArr[j]]) cnt++;
            }
            
            if(cnt != ans[i]) return false;
            
        }
        
        return true;
        
        
    }
    
}