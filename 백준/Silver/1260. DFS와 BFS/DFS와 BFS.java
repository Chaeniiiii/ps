import java.util.*;
import java.io.*;

public class Main {

    private static int n,m;
    private static ArrayList<Integer>[] graph;
    
    public static void main(String[] args) throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n+1];
        for(int i = 1; i <= n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int u = Integer.parseInt(st.nextToken());
            graph[v].add(u);
            graph[u].add(v);
        }

        for(int i = 1; i <= n; i++){
            graph[i].sort( (a,b) -> a - b);
        }

        ArrayList<Integer> dfsR = dfs(start, new ArrayList<>(), new boolean[n+1]);
        for(int i = 0; i < dfsR.size(); i++){
            System.out.printf("%d ",dfsR.get(i));
        }
        System.out.println();
        ArrayList<Integer> bfsR = bfs(start);
        for(int i = 0; i < bfsR.size(); i++){
            System.out.printf("%d ",bfsR.get(i));
        }

    }

    private static ArrayList<Integer> dfs(int start, ArrayList<Integer> result, boolean[] visited){

        if(visited[start]) return result;

        result.add(start);
        visited[start] = true;

        for(int child : graph[start]){
            dfs(child,result,visited);
        }

        return result;

    }

    private static ArrayList<Integer> bfs(int start){

        ArrayList<Integer> result = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(start);

        boolean[] visited = new boolean[n+1];

        while (!deque.isEmpty()) {

            int now = deque.poll();
            if(visited[now]) continue;
            visited[now] = true;
            result.add(now);

            for(int child : graph[now]){
                deque.add(child);
            }

        }

        return result;

    }

}
