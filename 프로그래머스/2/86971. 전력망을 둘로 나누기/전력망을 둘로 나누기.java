import java.util.*;

class Solution {
    
    private static int [] parent ;

    private static void union(int x, int y){
        x = find(x);
        y = find(y);
        
        if(x != y){
            if(x > y){
                parent[x] = y;
            }
            else{
                parent[y] = x;
            }
        }
    }
    
    private static int find(int x){
        if(x != parent[x]) {
            return parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    
    public int solution(int n, int[][] wires) {
        
        int result = Integer.MAX_VALUE;
        int idx = 0;
        
        while(idx < wires.length){
            
            parent = new int[n+1];
            for(int i = 1; i<=n; i++) {
                parent[i] = i;
            }
            
            for(int i = 0; i<wires.length; i++){
                if(i == idx) {
                    continue;
                }
                union(wires[i][0],wires[i][1]);
            }

            Map<Integer,Integer> map = new HashMap<>();
            for(int i = 1; i<=n; i++){
                parent[i] = find(i);
                map.put(parent[i],map.getOrDefault(parent[i],0)+1);
            }
            
            int cnt = 0;
            for(int key : map.keySet()){
                cnt = Math.abs(cnt - map.get(key));
            }

            result = Math.min(cnt,result);
            idx ++;
            
        }
        
        return result;
        
    }
}