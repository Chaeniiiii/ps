import java.util.*;

class Solution {
    
    private static int[] parent;
    private static Set<Integer> network;
    
    private static void union(int x, int y){
        
        x = find(x);
        y = find(y);
        
        if(x < y){
            parent[y] = x;
        }
        else{
            parent[x] = y;
        }
        
    }
    
    private static int find(int x){
        
        if(x == parent[x]) return parent[x];
        return find(parent[x]);
        
    }
    
    public int solution(int n, int[][] computers) {
        
        network = new HashSet<>();
        parent = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }
        
        for(int i = 0 ; i < n; i++){
            for(int j = 0 ; j < n; j++){
                if(computers[i][j] == 0) continue;
                union(i, j);    
            }
        }
        
        for(int i = 0; i < n; i++){
            parent[i] = find(i);
        }
        
        
        for(int i = 0; i < n; i++){
            network.add(parent[i]);
        }
        
        return network.size();
        
    }
}