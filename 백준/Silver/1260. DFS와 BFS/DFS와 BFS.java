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

        System.out.println(dfs(start, new StringBuilder(), new boolean[n+1]).toString());
        System.out.println(bfs(start));

    }

    private static StringBuilder dfs(int start, StringBuilder sb, boolean[] visited){

        if(visited[start]) return sb;

        sb.append(start).append(" ");
        visited[start] = true;

        for(int child : graph[start]){
            dfs(child,sb,visited);
        }

        return sb;

    }

    private static StringBuilder bfs(int start){

        StringBuilder sb = new StringBuilder();
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(start);

        boolean[] visited = new boolean[n+1];

        while (!deque.isEmpty()) {

            int now = deque.poll();
            if(visited[now]) continue;
            visited[now] = true;
            sb.append(now).append(" ");

            for(int child : graph[now]){
                deque.add(child);
            }

        }

        return sb;

    }

}
