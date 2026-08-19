import java.util.*;

class Solution {
    
    private Map<Integer,ArrayList<Integer>> map;
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        
        map = new HashMap<>();
        for(int i = 1; i <= n; i++){
            map.put(i,new ArrayList<>());
        }
        
        for(int i = 0; i < roads.length; i++){
            int[] r = roads[i];
            map.get(r[0]).add(r[1]);
            map.get(r[1]).add(r[0]);
        }
        
        int[] d = dijkstra(n, destination);
        int[] result = new int[sources.length];
        for(int i = 0; i < sources.length; i++){
            if(d[sources[i]] == n) result[i] = -1;
            else result[i] = d[sources[i]];
        }
        
        return result;
        
    }
    
    private int[] dijkstra(int n, int destination){
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(destination);
        
        int[] d = new int[n+1];
        Arrays.fill(d, n);
        d[destination] = 0;
        
        while(!pq.isEmpty()){
            
            int st = pq.poll();
            int cost = d[st];
            
            for(int child : map.get(st)){
                if(d[child] <= cost + 1) continue;
                pq.add(child);
                d[child] = cost + 1;
            }
            
        }
        
        return d;
        
    }
    
}