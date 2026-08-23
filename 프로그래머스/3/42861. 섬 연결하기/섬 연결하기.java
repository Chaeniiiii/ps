import java.util.*;

class Solution {
    
    private int[] parent;
    
    private void union(int x, int y){
        
        x = find(x);
        y = find(y);
        
        if(x > y){
            parent[x] = y;
        }
        else{
            parent[y] = x;
        }
    }
    
    private int find(int x){
        if(x != parent[x]) return parent[x] = find(parent[x]);
        return parent[x];
    }
    
    public int solution(int n, int[][] costs) {
        
        parent = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }
        
        Arrays.sort(costs,(a,b) -> a[2] - b[2]);
        int cost = 0;
        int edge = 0;
        
        for(int i = 0; i < costs.length; i++){
            int[] info = costs[i];
            if(find(info[0]) == find(info[1])) continue;
            union(info[0], info[1]);
            
            cost += info[2];
            edge++;
            
            if(edge == n - 1) return cost;
            
        }
        
        return cost;
        
    }
}