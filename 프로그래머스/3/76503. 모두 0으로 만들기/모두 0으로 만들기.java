import java.util.*;

class Solution {
    
    private static long result;
    
    private static int[] a;
    private static boolean[] visited;
    private static ArrayList<Integer>[] graph;
    
    public long solution(int[] a, int[][] edges) {
        
        long sum = 0;
        for(int aNum : a){
            sum += aNum;
        }
        if(sum != 0) return -1;
        
        
        this.a = a;
        graph = new ArrayList[a.length];
        for (int i = 0; i < a.length; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        
        result = 0;
        visited = new boolean[a.length];
        
        dfs(0);
        return result;
        
    }
    
    private static long dfs(int node) {
        
        visited[node] = true;
        long sum = a[node];

        for (int i = 0; i < graph[node].size(); i++) {
            int j = graph[node].get(i);
            if (!visited[j]) {
                long childSum = dfs(j);
                sum += childSum;
                result += Math.abs(childSum);
            }
        }
        
        return sum;
        
    }
}
