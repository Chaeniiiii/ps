import java.util.*;

class Solution {
    
    private static Map<Integer, ArrayList<Node>> map;
    private static boolean[] gate;
    private static boolean[] summit;
    
    private static Node result;
    
    private static class Node{
        
        int num;
        int cost;
        
        private Node(int num, int cost){
            this.num = num;
            this.cost = cost;
        }
    }
    
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        
        //출발점 및 산봉우리 저장
        gate = new boolean[n+1];
        summit = new boolean[n+1];
        
        for(int g : gates){
            gate[g] = true;
        }
        
        for(int s : summits){
            summit[s] = true;
        }
        
        //그래프 만들기
        map = new HashMap<>();
        for(int i = 1; i <= n; i++){
            map.put(i, new ArrayList<>());
        }
        
        for(int[] path : paths){
            
            int dist = path[2]; 
            int v = path[0];
            int u = path[1];
            
            //출발지점이라면 나가는 방향만 저장
            if(gate[v]){
                map.get(v).add(new Node(u,dist));
                continue;
            }
            if(gate[u]){
                map.get(u).add(new Node(v,dist));
                continue;
            }
            
            //산봉우리라면 들어오는 방향만 저장
            if(summit[v]){
                map.get(u).add(new Node(v,dist));
                continue;
            }
            if(summit[u]){
                map.get(v).add(new Node(u,dist));
                continue;
            }
            
            map.get(u).add(new Node(v,dist));
            map.get(v).add(new Node(u,dist));
            
        }
        
        result = new Node(Integer.MAX_VALUE,Integer.MAX_VALUE);
        dijkstra(n,gates,summits);
        
        return new int[]{result.num, result.cost};
        
    }
    
    private static void dijkstra(int n, int[] gates, int[] summits){
        
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.cost - b.cost);
        
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        for(int g : gates){
            pq.add(new Node(g,0));
            dist[g] = 0;
        }
        
        while(!pq.isEmpty()){
            
            Node now = pq.poll();
            if(summit[now.num]) continue;
            if(dist[now.num] < now.cost) continue;
            
            for(Node nxt : map.get(now.num)){
                int newCost = Math.max(nxt.cost,dist[now.num]);
                if(newCost < dist[nxt.num]){
                    dist[nxt.num] = newCost;
                    pq.add(nxt);
                }
                
            }
            
        }
        
        Arrays.sort(summits);
        for(int s : summits){
            if(dist[s] < result.cost){
                result = new Node(s,dist[s]);
            }
        }
        
    }
    
}