import java.util.*;

class Solution {
    
    private static int [] parent;
    
    private static void union(int x, int y){
        
        x = find(x);
        y = find(y);
        
        if(x != y) {
            if(x < y) parent[x] = y;
            else parent[y] = x;
        }
        
    }
    
    private static int find(int num){
        
        if(parent[num] != num) return parent[num] = find(parent[num]);
        return num;
        
    }
    
    public int solution(int n, int[][] costs) {
    
        parent = new int[n];
        for(int i = 0; i<n; i++) parent[i] = i;
        
        Arrays.sort(costs,(a,b) -> a[2] - b[2]);
        
        int cnt = 0;
        boolean [] visited = new boolean[n];
        
        for(int [] cost : costs){
            
            if(find(cost[0]) != find(cost[1])) {
                union(cost[0],cost[1]);
                cnt += cost[2];
            }
            
        }        
        
        return cnt;
        
    }
}