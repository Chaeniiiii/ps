import java.util.*;

class Solution {
    
    public int solution(int n, int[][] edge) {
        
        Map<Integer,ArrayList<Integer>> child = new HashMap<>();
        for(int i = 1; i<=n; i++) child.put(i,new ArrayList<>());

        for(int i = 0; i<edge.length; i++){
            
            int [] info = edge[i];
            
            child.get(info[0]).add(info[1]);
            child.get(info[1]).add(info[0]);
            
        }
        
        return bfs(n,child);
        
    }
    
    private static int bfs(int n, Map<Integer,ArrayList<Integer>> arr){
        
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(1);
        
        boolean [] visited = new boolean[n+1];
        visited[1] = true;
        
        int cnt = 0;
        
        while(!deque.isEmpty()){
            
            int size = deque.size();
            cnt = 0;
            
            for(int i = 0; i<size; i++){
                
                int node = deque.poll();
                
                for(int child : arr.get(node)) {
                    if(!visited[child]) {
                        visited[child] = true;
                        deque.add(child);
                    }
                }
                
                cnt = size;
            }
        }
        
        return cnt;
        
        
    }
}