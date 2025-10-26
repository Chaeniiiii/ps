import java.util.*;

class Solution {
    
    private static final int SIZE = 5;
    private static int result;
    
    private static int[][] q;
    private static int[] ans;

    public int solution(int n, int[][] q, int[] ans) {
        
        this.q = q;
        this.ans = ans;
        
        result = 0;
        dfs(1,n,0, new boolean[n+1]);
        
        return result;
        
    }
    
    private static void dfs(int idx, int n, int dep, boolean[] arr){
        
        if(dep == SIZE ){
            if(calc(arr)) result++;
            return;
        }
        
        for(int i = idx; i <= n; i++){
            arr[i] = true;
            dfs(i+1,n,dep+1,arr);
            arr[i] = false;
        }
        
    }
    
    private static boolean calc(boolean[] arr){
        
        for(int i = 0; i < q.length; i++){
            int[] query = q[i];
            int cnt = 0;
            for(int j = 0; j < SIZE; j++){
                if(arr[query[j]]) cnt++;
            }
            if(cnt != ans[i]) return false;
        }
        
        return true;
        
    }
    
}