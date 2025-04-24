import java.util.*;

class Solution {
    
    private static int [] parent;
    
    private static void union(int x, int y){
        
        x = find(x);
        y = find(y);
        
        if(x != y){
            if(x < y) parent[y] = x;
            else parent[x] = y;
        }
        
    }
    
    private static int find(int x){
        
        if(parent[x] == x) return parent[x];
        
        return parent[x] = find(parent[x]);
        
    }
    
    public int solution(int n, int[][] computers) {
        
        Set<Integer> set = new HashSet<>();
        parent = new int[n+1];
        
        //부모 초기화
        for(int i = 1; i<=n ; i++) parent[i] = i;
        
        //부모 갱신
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(computers[i][j] == 1) union(i+1,j+1);
            }
        }
        
        for(int i = 1; i<=n; i++){
            set.add(find(i));
        }
        
        return set.size();
        
    }
}