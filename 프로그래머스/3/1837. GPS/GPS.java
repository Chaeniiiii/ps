import java.util.*;

class Solution {
    public int solution(int n, int m, int[][] edge_list, int k, int[] gps_log) {
        
        int[][] dp = new int[n+1][n+1];
        for(int i = 0; i < n+1; i++){
            Arrays.fill(dp[i],200);
        }
        dp[0][gps_log[0]] = 0;
        
        Map<Integer,ArrayList<Integer>> map = new HashMap<>();
        
        for(int[] edge : edge_list){
            int v = edge[0];
            int u = edge[1];
            map.computeIfAbsent(v, a -> new ArrayList<>()).add(u);
            map.computeIfAbsent(u, a -> new ArrayList<>()).add(v);
        }
        
        for(int i = 0 ; i < k - 1; i ++){
            for(int st = 1; st <= n; st++){
                if(dp[i][st] == 200) continue;
                for(int nxt : map.get(st)){
                    int nv = 0;
                    if(gps_log[i+1] != nxt) nv = 1;
                    dp[i+1][nxt] = Math.min(dp[i+1][nxt],dp[i][st] + nv);
                }
            }
        }
        
        int result = dp[k-1][gps_log[k-1]];
        return result == 200 ? - 1 : result;
        
        
    }
}