import java.util.*;

class Solution {
    
    private static Map<Integer,ArrayList<Integer>> map;
    
    private static boolean[] visited;
    private static int[][] dp;
    
    public int solution(int n, int[][] lighthouse) {
        
        map = new HashMap<>();
        
        visited = new boolean[n+1];
        dp = new int[n+1][2];
        
        for(int i = 1; i <= n; i++){
            map.put(i, new ArrayList<>());
        }
        
        for(int i = 0; i < lighthouse.length; i++){
            int[] now = lighthouse[i];
            map.get(now[0]).add(now[1]);
            map.get(now[1]).add(now[0]);
        }
        
        visited[1] = true;
        dfs(1);
        
        return Math.min(dp[1][0],dp[1][1]);
         
    }
    
    private static void dfs(int st){
        
        dp[st][1] = 1; //자기 자신을 무조건 켜야할 때
        
        for(int child : map.get(st)){
            if(visited[child]) continue;
            visited[child] = true;
            
            dfs(child);
            dp[st][0] += dp[child][1];
            dp[st][1] += Math.min(dp[child][0],dp[child][1]);
        }
        
                
    }
    
}