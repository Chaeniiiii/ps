import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        
        List<Integer>[] graph = new ArrayList[n+1];
        for(int i = 1; i <= n; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int[] eg : edge){
            graph[eg[0]].add(eg[1]);
            graph[eg[1]].add(eg[0]);
        }
        
        int[] cost = bfs(n,1, graph);
        
        int max = 0;
        int cnt = 0;
        
        for(int i = 1; i < cost.length; i++){
            if(cost[i] > max){
                max = cost[i];
                cnt = 1;
            }
            else if(cost[i] == max) cnt++;
        }
        
        return cnt;
        
    }
    
    private int[] bfs(int n, int st, List<Integer>[] graph){
        
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(st);
        
        int[] cost = new int[n + 1];
        Arrays.fill(cost,n);
        cost[st] = 0;
        
        int cnt = 0;
        while(!deque.isEmpty()){
            
            int size = deque.size();
            for(int i = 0; i < size; i++){
                
                int now = deque.poll();
                for(int child : graph[now]){
                    if(cost[child] != n) continue;
                    cost[child] = cnt + 1;
                    deque.add(child);
                }
                
            }
            
            cnt++;
            
        }
        
        return cost;
        
    }
}