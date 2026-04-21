import java.util.*;

class Solution {
    
    private int[] parent;
    
    private void union(int x, int y){
        
        x = find(x);
        y = find(y);
        
        if(x > y) parent[y] = x;
        else parent[x] = y;
        
    }
    
    private int find(int x){
        
        if(x != parent[x]) return parent[x] = find(parent[x]);
        return x;
        
    }
    
    public int solution(int n, int[][] computers) {
        
        parent = new int[n];
        
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(computers[i][j] == 1){
                    union(i,j);
                }
            }
        }
        
        for(int i = 0; i < n ; i++){
            parent[i] = find(i);
        }
        
        Set<Integer> node = new HashSet<>();
        for(int i = 0; i < n; i++){
            node.add(parent[i]);
        }
        
        return node.size();
        
    }
}