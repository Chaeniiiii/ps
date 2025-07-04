import java.util.*;

class Solution {
    
    private static ArrayList<Integer> gateArr;
    private static ArrayList<Integer> summitArr;
    
    private static Map<Integer,ArrayList<Node>> map;
    
    private static class Node{
        
        int idx;
        int cost;
        
        private Node(int idx, int cost){
            this.idx = idx;
            this.cost = cost;
        }
        
    }
    
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        
        gateArr = new ArrayList<>();
        summitArr = new ArrayList<>();
        
        for(int gate : gates) gateArr.add(gate);
        for(int summit : summits) summitArr.add(summit);
        
        map = new HashMap<>();
        
        for(int i = 1; i <= n; i++){
            map.put(i, new ArrayList<>());
        }
        
        for(int[] path : paths){
            int v = path[0];
            int u = path[1];
            int c = path[2];
            
            if(gateArr.contains(v) || summitArr.contains(u)){
                map.get(v).add(new Node(u,c));
            }
            else if(gateArr.contains(u) || summitArr.contains(v)){
                map.get(u).add(new Node(v,c));
            }
            else{
                map.get(v).add(new Node(u,c));
                map.get(u).add(new Node(v,c));
            }
        }
        
        return dijkstra(n);
    
    }
    
    private static int[] dijkstra(int n){
        
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.cost - b.cost);
        
        int[] dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
            
        for(int gate : gateArr){
            pq.add(new Node(gate,0));
            dist[gate] = 0;
        }
        
        while(!pq.isEmpty()){
            
            Node now = pq.poll();
            
            if(dist[now.idx] < now.cost) continue;
            
            for(Node nxt : map.get(now.idx)){
                
                int nxtCost = Math.max(nxt.cost,dist[now.idx]);
                
                if(nxtCost < dist[nxt.idx]){
                    dist[nxt.idx] = nxtCost;
                    pq.add(new Node(nxt.idx,nxtCost));
                }
                
            }
            
        }
        
        int[] result = new int[]{0,Integer.MAX_VALUE};
        summitArr.sort((a,b) -> a - b);
        
        for(int summit : summitArr){
            
            if(result[1] > dist[summit]){
                result[1] = dist[summit];
                result[0] = summit;
            }
        }
        
        return result;
        
    }
    
}