import java.util.*;

class Solution {
    
    private static int[] parent;
    
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
        
        if(x != parent[x]) return parent[x] = find(parent[x]);
        return parent[x];
        
    }
    
    public int solution(int n, int[][] wires) {
        
        int result = Integer.MAX_VALUE;
        
        for(int i = 0; i < wires.length; i++){
            
            parent = new int[n+1];
            for(int k = 1; k <= n; k++){
                parent[k] = k;
            }
            
            for(int j = 0; j < wires.length; j++){
                if(i == j) continue;
                union(wires[j][0],wires[j][1]);
            }
            
            for(int k = 1; k <= n; k++){
                parent[k] = find(parent[k]);
            }
            
            Map<Integer,Integer> map = new HashMap<>();
            for(int k = 1; k <= n ; k++){
                map.put(parent[k],map.getOrDefault(parent[k],0)+1);            
            }        

            int total = 0;
            for(int key : map.keySet()){
                total = Math.abs(total - map.get(key));
            }

            result = Math.min(result,total);
        }

        return result;    
        
    }
}