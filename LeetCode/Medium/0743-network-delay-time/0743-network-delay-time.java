import java.util.*;

class Solution {

    private static int[][] graph;
    private static int INF = Integer.MAX_VALUE;
    private static class Node{
        
        int next;
        int cost;

        private Node(int next, int cost){
            this.next = next;
            this.cost = cost;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        
        graph = new int[n+1][n+1];

        for(int i = 1; i <= n; i++){
            Arrays.fill(graph[i], INF);
        }

        for(int[] time : times){
            
            int u = time[0];
            int v = time[1];
            int w = time[2];

            graph[u][v] = w;

        }

        int result = 0;
        int[] dist = dijkstra(n,k);

        for(int i = 1; i <= n; i++){
            if(dist[i] == INF) return -1;
            result = Math.max(result,dist[i]);
        }

        return result;

    }

    private static int[] dijkstra(int n, int k){

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.cost));
        pq.add(new Node(k,0));

        int[] dist = new int[n+1];
        Arrays.fill(dist, INF);

        dist[k] = 0;

        while(!pq.isEmpty()){

            Node now = pq.poll();

            for(int i = 1; i <= n; i++){
                if(graph[now.next][i] == INF) continue;
                if(dist[i] > graph[now.next][i] + dist[now.next]){
                    dist[i] = graph[now.next][i] + dist[now.next];
                    pq.add(new Node(i,dist[i]));
                }
            }
        }

        return dist;

    }


}