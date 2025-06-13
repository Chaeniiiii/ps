import java.util.*;

class Solution {
    
    private static int n;
    private static int[] result;
    
    private static ArrayList<Node>[] graph;
    
    private static ArrayList<Integer> gateArr;
    private static ArrayList<Integer> summitArr;
        
    private static class Node{
        int idx;
        int cost;
        
        private Node(int idx, int cost){
            this.idx = idx;
            this.cost = cost;
        }
    }
    
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        
        this.n = n;
        result = new int[]{Integer.MAX_VALUE,Integer.MAX_VALUE};
        
        graph = new ArrayList[n+1];
        for(int i = 1; i <= n; i++){
            graph[i] = new ArrayList<>();
        }
        
        gateArr = new ArrayList<>();
        for(int gate : gates){
            gateArr.add(gate);
        }
        
        summitArr = new ArrayList<>();
        for(int summit : summits){
            summitArr.add(summit);
        }
        
        //그래프 설계
        for(int[] path : paths){
            
            Node v = new Node(path[0],path[2]);
            Node u = new Node(path[1],path[2]);
            
            if(gateArr.contains(v.idx) || summitArr.contains(u.idx)){
                graph[v.idx].add(u);
            }
            else if(gateArr.contains(u.idx) || summitArr.contains(v.idx)){
                graph[u.idx].add(v);
            }
            else{
                graph[u.idx].add(v);
                graph[v.idx].add(u);
            }
        }
        
        dijkstra();
        return result;
        
    }
    
    private static void dijkstra(){
        
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.cost));
        
        int[] dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        
        for(int gate : gateArr){
            pq.add(new Node(gate,0));
            dist[gate] = 0;
        }
        
        while(!pq.isEmpty()){
            
            Node now = pq.poll();
            
            if(dist[now.idx] < now.cost){
                continue;
            }
            
            for(Node nxt : graph[now.idx]){
                int nxtDist = Math.max(nxt.cost,dist[now.idx]);
                if(nxtDist < dist[nxt.idx]){
                    dist[nxt.idx] = nxtDist;
                    pq.add(new Node(nxt.idx,nxtDist));
                }
            }            
        }

        summitArr.sort((a,b) -> a - b);
        for(int summit : summitArr){
            if(result[1] > dist[summit]){
                result[1] = dist[summit];
                result[0] = summit;
            }
            else if(result[1] == dist[summit]){
                result[0] = Math.min(result[0],summit);
            }
        }
        
    }
}