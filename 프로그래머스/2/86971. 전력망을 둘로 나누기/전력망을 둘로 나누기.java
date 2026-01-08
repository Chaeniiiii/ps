import java.util.*;

class Solution {
    
    private static int[][] wires;
    
    private static boolean[] visited;
    private static Map<Integer,ArrayList<Integer>> map;
    
    public int solution(int n, int[][] wires) {
        
        this.wires = wires;
        init();
        
        int result = Integer.MAX_VALUE;
        for(int i = 0; i < wires.length; i++){
            visited = new boolean[n+1];
            visited[wires[i][0]] = true;
            int cnt = dfs(n,i,wires[i][0]);
            result = Math.min(Math.abs((n - cnt) - cnt),result);
        }
        
        return result;
        
    }
    
    private static int dfs(int n, int p, int now){
        
        int cnt = 1;
        
        for(int child : map.get(now)){
            if(visited[child]) continue;
            if(now == wires[p][0] && child == wires[p][1]) continue;
            if(now == wires[p][1] && child == wires[p][0]) continue;
            visited[child] = true;
            cnt += dfs(n,p,child);
        }
        
        return cnt;
        
    }
    
    
    private static void init(){
        
        map = new HashMap<>();
        
        for(int i = 0; i < wires.length; i++){
            
            int v = wires[i][0];
            int u = wires[i][1];
            
            map.computeIfAbsent(v,c -> new ArrayList<>()).add(u);
            map.computeIfAbsent(u,c -> new ArrayList<>()).add(v);
                
        }
        
    }
    
}