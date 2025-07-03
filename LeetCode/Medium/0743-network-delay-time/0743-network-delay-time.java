import java.util.*;

class Solution {

    private static Map<Integer,ArrayList<Node>> map;

    private static class Node{

        int nxt;
        int cost;

        private Node(int nxt, int cost){
            this.nxt = nxt;
            this.cost = cost;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        
        map = new HashMap<>();
        for(int i = 1; i <= n; i++){
            map.put(i, new ArrayList<>());
        }

        for(int[] time : times){
            int v = time[0];
            int u = time[1];
            int cost = time[2];

            map.get(v).add(new Node(u,cost));
        }

        int[] cost = dijkstra(times,n,k);
        int result = 0;
        for(int i = 1; i <= n; i++){
            result = Math.max(result, cost[i]);
        }

        return result == Integer.MAX_VALUE ? -1 : result;

    }

    private static int[] dijkstra(int[][] times, int n, int k){

        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.cost - b.cost);
        pq.add(new Node(k,0));

        int[] costs = new int[n+1];
        Arrays.fill(costs, Integer.MAX_VALUE);

        costs[k] = 0;

        while(!pq.isEmpty()){

            Node now = pq.poll();

            for(Node next : map.get(now.nxt)){
                
                int nextCost = costs[now.nxt] + next.cost;
                if(nextCost < costs[next.nxt]){
                    costs[next.nxt] = nextCost;
                    pq.add(next);
                }

            }

        }

        return costs;

    }
}