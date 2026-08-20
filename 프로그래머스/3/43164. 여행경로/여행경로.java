import java.util.*;

class Solution {
    
    private int n;
    private String[] st, en, result;
    private boolean[] visited;
    
    public String[] solution(String[][] tickets) {
        
        n = tickets.length;
        st = new String[n];
        en = new String[n];
        result = new String[n + 1];
        
        visited = new boolean[n];
        
        for(int i = 0; i < n; i++){
            String[] tk = tickets[i];
            st[i] = tk[0];
            en[i] = tk[1];
        }
        
        dfs(0,"ICN", new String[n + 1]);
        return result;
        
    }
    
    private void dfs(int dep, String tk, String[] route){
        
        route[dep] = tk;
        if(dep == n){
            for(int i = 0; i < n; i++){
                if(result[i] == null || result[i].compareTo(route[i]) > 0){
                    result = route.clone();
                    return;
                }
                else if(result[i].compareTo(route[i]) < 0){
                    return;
                }
            }
            return;
        }

        for(int i = 0; i < n; i++){
            if(visited[i] || !st[i].equals(tk)) continue;
            visited[i] = true;
            dfs(dep+1,en[i],route);
            visited[i] = false;
        }
        
    }
}