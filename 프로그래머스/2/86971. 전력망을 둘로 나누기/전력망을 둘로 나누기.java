import java.util.*;

class Solution {
    
    private static int[] parent;
    
    private static void union(int x, int y){
        
        x = find(x);
        y = find(y);
        
        if(x > y){
            parent[x] = y; 
        }
        else parent[y] = x;
    }
    
    private static int find(int x){
        if(parent[x] != x){
            return parent[x] = find(parent[x]);
        }
        
        return parent[x];
        
    }
    
    public int solution(int n, int[][] wires) {
        
        int answer = Integer.MAX_VALUE;
        
        for(int t = 0; t<wires.length; t++){
            
            //부모 초기화
            parent = new int[n+1];
            for(int i = 1; i<=n; i++){
                parent[i]  = i;
            }
            
            for(int i = 0; i<wires.length; i++){
                if(i == t) continue;
                union(wires[i][0],wires[i][1]);
            }
            
            for(int i = 1; i<=n; i++){
                parent[i] = find(i);
            }
            
            int cnt = 0;
            HashMap<Integer,Integer> map = new HashMap<>();
            for(int i = 1; i<=n; i++){
                map.put(parent[i],map.getOrDefault(parent[i],0)+1);
            }
            
            for(int key : map.keySet()){
                cnt = Math.abs(cnt - map.get(key));
            }
            
            answer = Math.min(answer,cnt);
            
        }
        
        return answer;
        
    }
}