import java.util.*;

class Solution {
    
    private static final int MAX = 5;
    
    private static int n,result;
    private static int[][] q;
    private static int[] ans;
    
    public int solution(int n, int[][] q, int[] ans) {

        this.n = n;
        this.q = q;
        this.ans = ans;
        
        result = 0;
        dfs(1,0,new boolean[n+1]);
        
        return result;
        
    }
    
    private static void dfs(int num, int dep, boolean[] arr){
        
        if(dep == MAX){
            if(isPossible(arr)) result ++;
            return;
        }
        
        for(int i = num; i <= n; i++){
            
            arr[i] = true;
            dfs(i+1,dep+1,arr);
            arr[i] = false;
            
        }        
        
    }
    
    private static boolean isPossible(boolean[] arr){
        
        for(int i = 0; i < q.length; i++){
            
            int cnt = 0;
            int[] qArr = q[i];
            
            for(int ele : qArr){
                if(arr[ele]) cnt++;
                if(cnt > ans[i]) return false;
            }
            
            if(cnt != ans[i]) return false;
            
        }
        
        return true;
        
        
    }
    
}