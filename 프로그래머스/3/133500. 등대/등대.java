import java.util.*;

class Solution {
    
    private static int[][] dp;
    private static Map<Integer,ArrayList<Integer>> graph;
    
    public int solution(int n, int[][] lighthouse) {
        
        graph = new HashMap<>();
        dp = new int[n+1][2];
        
        for(int i = 1; i <= n; i++){
            graph.put(i, new ArrayList<>());
        }
        
        for(int[] light : lighthouse){
            graph.get(light[0]).add(light[1]);
            graph.get(light[1]).add(light[0]);
        }

        dfs(1,0);
        
        return Math.min(dp[1][0], dp[1][1]);
        
    }
    
    private static void dfs(int st, int parent){
        
        dp[st][0] = 0;
        dp[st][1] = 1;
        
        for(int child : graph.get(st)){
            
            if(child == parent) continue;
            
            dfs(child,st);
            
            dp[st][0] += dp[child][1];
            dp[st][1] += Math.min(dp[child][0], dp[child][1]);
            
        }
        
    }
    
}