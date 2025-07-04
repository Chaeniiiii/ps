import java.util.*;

class Solution {
    
    private static int n;
    
    private static ArrayList<Integer> gateArr;
    private static ArrayList<Integer> summitArr;
    
    private static Map<Integer,ArrayList<Node>> map;
    
    private static class Node{
        int num;
        int cost;
        
        private Node(int num, int cost){
            this.num = num;
            this.cost = cost;
        }
    }
    
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        
        this.n = n;
        
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
            int t = path[2];
            
            if(gateArr.contains(v) || summitArr.contains(u)){
                map.get(v).add(new Node(u,t));
            }
            else if(gateArr.contains(u) || summitArr.contains(v)){
                map.get(u).add(new Node(v,t));
            }
            else{
                map.get(v).add(new Node(u,t));
                map.get(u).add(new Node(v,t));
            }
            
        }
        
        return dijkstra();
        
    }
    
    private static int[] dijkstra(){
        
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.cost - b.cost);
        
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        for(int gate : gateArr){
            pq.add(new Node(gate,0));
            dist[gate] = 0;
        }
        
        while(!pq.isEmpty()){
            
            Node now = pq.poll();
            
            if(dist[now.num] < now.cost) continue;
            
            for(Node nxt : map.get(now.num)){
                int nxtDist = Math.max(dist[now.num],nxt.cost);
                if(nxtDist < dist[nxt.num]){
                    dist[nxt.num] = nxtDist;
                    pq.add(new Node(nxt.num,nxtDist));
                }
            }
            
        }
        
        int[] result = new int[]{0,Integer.MAX_VALUE};
        summitArr.sort((a,b) -> a-b);
        
        for(int summit : summitArr){
            if(result[1] > dist[summit]){
                result[1] = dist[summit];
                result[0] = summit;
            }
        }
        
        return result;
    }
}