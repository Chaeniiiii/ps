import java.util.*;

class Solution {
    
    private int result;
    private int[] info;
    private ArrayList<Integer>[] graph;
    
    public int solution(int[] info, int[][] edges) {
        
        this.info = info;
        int n = info.length;
        graph = new ArrayList[n];
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();    
        }
        
        for(int i = 0; i < edges.length; i++){
            graph[edges[i][0]].add(edges[i][1]);
        }
        
        ArrayList<Integer> nxt = new ArrayList<>();
        nxt.add(0);
        
        result = 0;
        dfs(0,0,0,nxt);
        
        return result;
    }
    
    private void dfs(int st, int w, int s, ArrayList<Integer> nxt){
        
        if(info[st] == 0) s++;
        else w++;
        
        if(w >= s) return;
        
        result = Math.max(result,s);
        
        ArrayList<Integer> newNxt = new ArrayList<>(nxt);
        newNxt.remove(Integer.valueOf(st));
        
        newNxt.addAll(graph[st]);
        
        for(int child : newNxt){
            dfs(child,w,s,newNxt);
        }
        
    }
}