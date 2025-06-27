import java.util.*;

class Solution {

    private static double INF = -1000.0;

    private static class Node{
        int nxt;
        double cost;
        
        private Node(int nxt, double cost){
            this.nxt = nxt;
            this.cost = cost;
        }
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        
        Map<Integer,ArrayList<Node>> graph = new HashMap<>();
        for(int i = 0; i < n; i++){
            graph.put(i,new ArrayList<>());
        }

        for(int i = 0; i < edges.length; i++){
            
            int[] edge = edges[i];
            
            int a = edge[0];
            int b = edge[1];
            double t = succProb[i];

            graph.get(a).add(new Node(b,t));
            graph.get(b).add(new Node(a,t));

        }

        return dijkstra(n, graph, start_node, end_node);

    }

    private static double dijkstra(int n, Map<Integer,ArrayList<Node>> graph, int start, int end){

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingDouble(a -> -a.cost));
        pq.add(new Node(start,1.0));

        double[] dist = new double[n];
        dist[start] = 1.0;
        
        while(!pq.isEmpty()){

            Node now = pq.poll();

            if(now.nxt == end) return dist[end];

            for(Node node : graph.get(now.nxt)){
                double newCost = node.cost * dist[now.nxt];
                if(dist[node.nxt] < newCost){
                    dist[node.nxt] = newCost;
                    pq.add(new Node(node.nxt,dist[node.nxt]));
                }
            }
        }

        return 0.0;

    }
}