import java.util.*;

class Solution {
    public boolean isBipartite(int[][] graph) {
        
        int n = graph.length;
        int [] color = new int[n];

        Arrays.fill(color,-1);

        Deque<Integer> deque = new ArrayDeque<>();
        
        for(int i = 0; i<n; i++){

            if(color[i] == -1) {
                deque.add(i);
                color[i] = 0;
            }

            while(!deque.isEmpty()){
                
                int now = deque.poll();
                
                for(int node : graph[now]){
                    
                    if(color[node] != -1 && color[now] == color[node]) return false;
                    if(color[node] != -1) continue;
                
                    color[node] = (color[now] == 1) ? 0 : 1;

                    deque.add(node);
                    
                }
                
            }

        }

        return true;

    }
}