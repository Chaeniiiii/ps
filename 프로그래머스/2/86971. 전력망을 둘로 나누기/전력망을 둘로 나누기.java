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
    
    private static int find(int x) {
        
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
        
    }
    
    public int solution(int n, int[][] wires) {
        
        int idx = 0;
        int result = Integer.MAX_VALUE ;
        
        while(idx < n){
            
            parent = new int[n+1];
            Map<Integer,Integer> map = new HashMap<>();

            //부모 초기화 
            for(int i = 1; i<=n; i++) parent[i] = i;
           
            for(int i = 0; i< wires.length; i++){
               if(idx == i) continue;
               union(wires[i][0],wires[i][1]);
           }   
            
            
            for(int i = 1; i<=n; i ++){
                int key = find(i);
                map.put(key, map.getOrDefault(key,0)+1);
            }        
        
            int cnt = 0;
            for(int key : map.keySet()) {
                cnt = Math.abs(cnt-map.get(key));
            }
            
            result = Math.min(result,cnt);
            idx ++ ;
            
        }
        
        
        return result;
        
    }
}