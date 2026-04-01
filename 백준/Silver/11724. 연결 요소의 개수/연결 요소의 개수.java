import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    
    private static ArrayList<Integer>[] graph;
    public static void main(String[] args) throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

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

        boolean[] visited = new boolean[n+1];
        int cnt = 0;
        for(int i = 1; i <= n; i++){
            if(visited[i]) continue;
            visited[i] = true;
            visited = dfs(i,visited);
            cnt++;
        }

        System.out.println(cnt);

    }

    private static boolean[] dfs(int start, boolean[] visited) throws Exception{

        for(int child : graph[start]){
            if(visited[child]) continue;
            visited[child] = true;
            dfs(child,visited);
        }

        return visited;
    }
}
