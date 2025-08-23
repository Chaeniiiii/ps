import java.util.*;

class Solution {
    
    private static Map<Integer,ArrayList<Integer>> map;
    private static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        
        map = new HashMap<>();
        
        for(int i = 1; i <= computers.length; i++){
            map.put(i, new ArrayList<>());
            for(int j = 1; j <= computers[i-1].length; j++){
                if(computers[i-1][j-1] == 0) continue;
                map.get(i).add(j);
            }
        }
        
        visited = new boolean[map.size()+1];
        int cnt = 0;
        for(int i = 1; i <= map.size(); i++){
            if(visited[i]) continue;
            dfs(i);
            cnt++;
        }
        
        return cnt;
                
    }
    
    private static void dfs(int node){
        
        if(visited[node]) return;
        visited[node] = true;
        
        for(int nxt : map.get(node)){
            if(visited[nxt]) continue;
            dfs(nxt);
        }
        
    }
    
}