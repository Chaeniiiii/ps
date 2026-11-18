import java.util.*;

class Solution {
    
    private Map<Integer,ArrayList<Integer>> map;
    private boolean[] visited;
    private int[][] wires;
    
    public int solution(int n, int[][] wires) {
        
        init(wires);
        this.wires = wires;
        int result = Integer.MAX_VALUE;
        
        for(int i = 0; i < wires.length; i++){
            visited = new boolean[n+1];
            visited[wires[i][0]] = true;
            int cnt = dfs(n,i,wires[i][0]);
            result = Math.min(result,Math.abs((n - cnt) - cnt));
        }
        
        return result;
        
    }
    
    private int dfs(int n, int rm, int now){
        
        int cnt = 1;
        
        for(int child : map.get(now)){
            if(visited[child]) continue;
            if(wires[rm][0] == now && wires[rm][1] == child) continue;
            if(wires[rm][0] == child && wires[rm][1] == now) continue;
            visited[child] = true;
            cnt += dfs(n,rm,child);
        }
        
        return cnt;
        
    }
    
    private void init(int[][] wires){
     
        map = new HashMap<>();
        
        for(int i = 0; i < wires.length; i++){
            int a = wires[i][0];
            int b = wires[i][1];
            
            map.computeIfAbsent(a, v -> new ArrayList<>()).add(b);
            map.computeIfAbsent(b, v -> new ArrayList<>()).add(a);
        }
        
    }
}